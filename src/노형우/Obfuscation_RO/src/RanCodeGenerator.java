package obfuscation;
import java.util.Random;
import java.util.regex.*;

public class RanCodeGenerator {
    // C 코드에서 사용할 타입 목록
    private static final String[] TYPES = {"int", "float"};
    private static final String[] OPERATORS = {"+", "-", "*", "/", "%"};
    private static final String[] VARIABLES = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private static final Random random = new Random();

    public static String generateVarDecl() {
        String type = TYPES[random.nextInt(TYPES.length)];
        String variable = VARIABLES[random.nextInt(VARIABLES.length)];
        return type + " " + variable + " = " + random.nextInt(10) + ";";
    }

    public static String generateFun() {
        String returnType = TYPES[random.nextInt(TYPES.length)];
        String functionName = "func_" + VARIABLES[random.nextInt(VARIABLES.length)];
        return returnType + " " + functionName + "() {" + generateVarDecl() + "  return 0;" + "}";
    }

    public static String generateIfStmt() {
        String variable = VARIABLES[random.nextInt(VARIABLES.length)];
        return "if (" + variable + " > 5) {" + "  " + generateVarDecl() + "} else {" + "  " + generateVarDecl() + "}";
    }

    public static String generateExpr() {
        String variable1 = VARIABLES[random.nextInt(VARIABLES.length)];
        String variable2 = VARIABLES[random.nextInt(VARIABLES.length)];
        String operator = OPERATORS[random.nextInt(OPERATORS.length)];
        return variable1 + " = " + variable1 + " " + operator + " " + variable2 + ";";
    }

    public static String generateRandomCCode() {
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            code.append(generateVarDecl());
        }

        code.append(generateFun());
        code.append(generateIfStmt());

        for (int i = 0; i < 2; i++) {
            code.append(generateExpr());
        }

        return code.toString();
    }
}
