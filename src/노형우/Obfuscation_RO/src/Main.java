package obfuscation;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.ParseTree;
import generated.*;

import java.util.Random;

public class Main{
    public static void main(String[] args) throws Exception{

        CharStream code = CharStreams.fromFileName("src/test.c");
        MiniCLexer lexer = new MiniCLexer(code);
        CommonTokenStream tokens = new CommonTokenStream(lexer);


        try{
            MiniCParser parser = new MiniCParser(tokens);
            ParseTree tree = parser.program();
            //System.out.println(tree.getText());

            ParseTreeWalker walker = new ParseTreeWalker();
            MiniCPrintListener_obfuscation listener = new MiniCPrintListener_obfuscation();
            walker.walk(listener, tree);

            System.out.println(MiniCPrintListener_obfuscation.getOutput());
        } catch (RuntimeException e){
            System.out.println("Error");
        }
    }

 }