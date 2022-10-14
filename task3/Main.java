import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static boolean is_operan(String str) {
        try {Double.parseDouble(str);} catch (NumberFormatException nfe) {return false;}
        return true;
    }

    public static List<Token> tokenize(List<String> allLines) throws Exception {
        List<Token> token_arr = new ArrayList<Token>();

        for (int i = 0; i < allLines.size(); i++) {
            String it = allLines.get(i);
            
            if (is_operan(it)) {token_arr.add(new Token(TokenType.NUM, it));}
            else if (it.equals("*")) {token_arr.add(new Token(TokenType.STAR, it));}
            else if (it.equals("+")) {token_arr.add(new Token(TokenType.PLUS, it));}
            else if (it.equals("-")) {token_arr.add(new Token(TokenType.MINUS, it));}
            else if (it.equals("/")) {token_arr.add(new Token(TokenType.SLASH, it));}
            else {throw new Exception("Caracter errado ai paizao: " + it);}
        }

        return token_arr;
    }

    public static Float apply(Float snd, Float fst, String operation) {
        if (operation.equals("*")) {return snd * fst;}
        else if (operation.equals("-")) {return snd - fst;}
        else if (operation.equals("+")) {return snd + fst;}
        else {return snd / fst;}
    }

    public static Float scan(List<Token> token_arr) {
        Regex validator = new Regex();
        Stack<Float> RPNStacker = new Stack<>();
        while (!token_arr.isEmpty()) {
            Token curr = token_arr.remove(0); String it = curr.lexeme; TokenType t = curr.type;

            if (t == TokenType.NUM) {
                RPNStacker.add(Float.parseFloat(it));
            }
            else if (validator.is_Operator(it)) {
                Float fst = RPNStacker.pop(); 
                Float snd = RPNStacker.pop();
                RPNStacker.add(apply(snd, fst, it));
            }
        }
        return RPNStacker.pop();
    }

    public static Float postfix(String filepath) throws Exception {
        List<Token> token_arr = tokenize(Files.readAllLines(Paths.get(filepath)));
        Float answer = scan(token_arr);
        
        return answer;
    }

    public static void main(String[] args) throws Exception {
        Float valid = postfix("input.stk"); 
        System.out.println(valid);

        Float invalid = postfix("output_error.stk");
        System.out.println(invalid);
    }
}