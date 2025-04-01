import generated.MiniCBaseListener;
import generated.MiniCParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiniCPrintListener extends MiniCBaseListener implements ParseTreeListener {
    private static String output = "";
    private final java.util.List<String> junkStrings = loadJunkStrings(); // 삽입할 문자열 리스트
    ParseTreeProperty<String> cTree = new ParseTreeProperty<>();
    private final Map<String, String> varNameMap = new HashMap<>();

    public static String getOutput() {
        return output;
    }
    private java.util.List<String> loadJunkStrings() { // 파일의 문자열을 읽어와 주석으로 추가하는 함수 구현.
        java.util.List<String> chunks = new java.util.ArrayList<>();
        try {
            String content = java.nio.file.Files.readString(java.nio.file.Paths.get("./src/text.txt")).trim();
            if (content.isEmpty()) {
                // 파일이 비어 있으면 랜덤 문자열 여러 개 생성
                for (int i = 0; i < 100; i++) {
                    chunks.add(generateRandomAlpha(5));
                }
            } else {
                // 내용을 일정 길이로 쪼개서 사용
                int i = 0;
                while (i < content.length()) {
                    int len = Math.min(5, content.length() - i);
                    chunks.add(content.substring(i, i + len));
                    i += len;
                }
            }
        } catch (Exception e) {
            // 파일 읽기 실패 시 fallback
            for (int i = 0; i < 100; i++) {
                chunks.add(generateRandomAlpha(5));
            }
        }
        return chunks;
    }
    private String getRandomVarName(String original) {
        return varNameMap.computeIfAbsent(original,
                k -> "var_" + UUID.randomUUID().toString().replace("-", "").substring(0, 8));
    }

    private String insertJunkComments(String code) {
        String[] tokens = code.split("(?<=\\W)|(?=\\W)");
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                result.append(token);
                // 난수로 길이 결정 (예: 3 ~ 8자)
                int len = rand.nextInt(6) + 3;
                String junk = junkStrings.get(rand.nextInt(junkStrings.size()));
                // 길이 초과 시 잘라서 사용
                junk = junk.length() > len ? junk.substring(0, len) : junk;
                result.append("/*" + junk + "*/");
            }
        }
        return result.toString();
    }


    private String generateRandomAlpha(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(rand.nextInt(alphabet.length())));
        }
        return sb.toString();
    }



    // 리터럴 난독화: 숫자를 무의미한 수식으로 변환
    private String obfuscateLiterals(String text) {
        Pattern p = Pattern.compile("\\b\\d+\\b");
        Matcher m = p.matcher(text);
        StringBuffer sb = new StringBuffer();

        while (m.find()) {
            int val = Integer.parseInt(m.group());
            int a = (int) (Math.random() * val);
            int b = val - a;
            m.appendReplacement(sb, "(" + a + "+" + b + ")");
        }
        m.appendTail(sb);
        return sb.toString();
    }

    // 제어 흐름 조건식에 의미 없는 난수 조건 추가
    private String obfuscateConditionRaw(String condition) {
        int rand = new Random().nextInt(10000);
        return "((" + condition + ") && (" + rand + " == " + rand + "))";
    }

    @Override
    public void exitProgram(MiniCParser.ProgramContext ctx) {
        StringBuilder program = new StringBuilder();
        for (MiniCParser.DeclContext decl : ctx.decl()) {
            program.append(cTree.get(decl));
        }
        output = program.toString().replaceAll("\\s+", " ");
    }

    @Override
    public void exitDecl(MiniCParser.DeclContext ctx) {
        String result = ctx.fun_decl() != null ?
                cTree.get(ctx.fun_decl()) : cTree.get(ctx.var_decl());
        cTree.put(ctx, result);
    }

    @Override
    public void exitVar_decl(MiniCParser.Var_declContext ctx) {
        if (ctx.IDENT() != null) {
            String newName = getRandomVarName(ctx.IDENT().getText());
            String text = ctx.getText().replace(ctx.IDENT().getText(), newName);
            text = obfuscateLiterals(text);
            text = insertJunkComments(text);
            cTree.put(ctx, obfuscateLiterals(text).replaceAll("\\s+", " "));
        }
    }


    /**
     * ctx.getText()는 해당 노드의 원본 소스 코드만 문자열로 반환한다.
     * 따라서 이전 단계에서 while_stmt 등에 적용된 불투명 조건과 같은 난독화 결과는 반영되지 않는다.
     * 또한 여기서 다시 리터럴 난독화를 수행하면, 이미 적용된 난독화 결과가 덮어쓰이게 되어 의도한 효과가 사라진다.
     *
     * 따라서 exitFun_decl에서는 각 구성 요소(type, name, params, body)를 직접 조합하여,
     * 이전 단계에서 생성된 난독화 결과(cTree.get(...))를 그대로 활용해야 한다.
     */
    @Override
    public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
        String type = ctx.type_spec().getText();
        String oldName = ctx.IDENT().getText();
        String newName = getRandomVarName(oldName);
        String params = ctx.params().getText();
        String body = cTree.get(ctx.compound_stmt());  // 우리가 만든 난독화 코드가 여기에 있음

        String result = type + " " + newName + "(" + params + ")" + body;
        cTree.put(ctx, result);
    }



    @Override
    public void exitLocal_decl(MiniCParser.Local_declContext ctx) {
        if (ctx.IDENT() != null) {
            String newName = getRandomVarName(ctx.IDENT().getText());
            String text = ctx.getText().replace(ctx.IDENT().getText(), newName);
            text = obfuscateLiterals(text);
            text = insertJunkComments(text);
            cTree.put(ctx, obfuscateLiterals(text).replaceAll("\\s+", " "));
        }
    }

    @Override
    public void exitExpr(MiniCParser.ExprContext ctx) {
        if (ctx.IDENT() != null) {
            String newName = getRandomVarName(ctx.IDENT().getText());
            String text = ctx.getText().replace(ctx.IDENT().getText(), newName);
            text = obfuscateLiterals(text);
            text = insertJunkComments(text);
            cTree.put(ctx, obfuscateLiterals(text).replaceAll("\\s+", " "));
        } else {
            cTree.put(ctx, obfuscateLiterals(ctx.getText()).replaceAll("\\s+", " "));
        }
    }

    @Override
    public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
        String text = obfuscateLiterals(ctx.getText());
        text = insertJunkComments(text); //주석 기반 쓰레기 삽입
        cTree.put(ctx, text);
    }
    @Override
    public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
        String cond = ctx.expr().getText();
        String thenStmt = cTree.get(ctx.stmt(0));
        String elseStmt = (ctx.ELSE() != null && ctx.stmt(1) != null)
                ? " else " + cTree.get(ctx.stmt(1)) : "";

        String result = "if (" + obfuscateConditionRaw(cond) + ") " + thenStmt + elseStmt;
        cTree.put(ctx, result);
    }

    @Override
    public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
        String cond = ctx.expr().getText();
        String stmt = cTree.get(ctx.stmt());

        String result = "while (" + obfuscateConditionRaw(cond) + ") " + stmt;
        cTree.put(ctx, result);
    }

    @Override
    public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
        String text = obfuscateLiterals(ctx.getText());
        text = insertJunkComments(text);  //주석 난독화 추가
        cTree.put(ctx, text);
    }

    @Override
    public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
        StringBuilder body = new StringBuilder("{");
        for (MiniCParser.Local_declContext decl : ctx.local_decl()) {
            body.append(cTree.get(decl));
        }
        for (MiniCParser.StmtContext stmt : ctx.stmt()) {
            body.append(cTree.get(stmt));
        }
        body.append("}");
        cTree.put(ctx, body.toString());
    }

    @Override
    public void exitParams(MiniCParser.ParamsContext ctx) {
        cTree.put(ctx, ctx.getText().replaceAll("\\s+", " "));
    }

    @Override
    public void exitParam(MiniCParser.ParamContext ctx) {
        if (ctx.IDENT() != null) {
            String newName = getRandomVarName(ctx.IDENT().getText());
            String result = ctx.getText().replace(ctx.IDENT().getText(), newName)
                    .replaceAll("\\s+", " ");
            cTree.put(ctx, result);
        }
    }

    @Override
    public void exitStmt(MiniCParser.StmtContext ctx) {
        //이미 while_stmt에서 조립했을 가능성이 있으니 get 먼저 확인
        if (cTree.get(ctx) != null) return;

        if (ctx.while_stmt() != null) {
            cTree.put(ctx, cTree.get(ctx.while_stmt()));
        } else if (ctx.if_stmt() != null) {
            cTree.put(ctx, cTree.get(ctx.if_stmt()));
        } else {
            cTree.put(ctx, ctx.getText());
        }
    }

    @Override
    public void exitArgs(MiniCParser.ArgsContext ctx) {
        cTree.put(ctx, ctx.getText().replaceAll("\\s+", " "));
    }

    @Override
    public void exitType_spec(MiniCParser.Type_specContext ctx) {
        cTree.put(ctx, ctx.getText());
    }
}

