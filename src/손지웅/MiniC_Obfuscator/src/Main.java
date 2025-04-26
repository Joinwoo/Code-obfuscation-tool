import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import generated.*;

public class Main {
    public static void main(String[] args) {
        try {
            CharStream code = CharStreams.fromFileName("/Users/sonjiwoong/Code-obfuscation-tool/src/손지웅/MiniC_Obfuscator/src/test.c");

            MiniCLexer lexer = new MiniCLexer(code);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniCParser parser = new MiniCParser(tokens);

            // 파싱 트리 생성
            ParseTree tree = parser.program();

            ParseTreeWalker walker = new ParseTreeWalker();
            MiniCPrintListener listener = new MiniCPrintListener();
            walker.walk(listener, tree);

            System.out.println(MiniCPrintListener.getOutput());

        } catch (Exception e) {
            System.err.println("Parsing failed: " + e.getMessage());
        }
    }

}