import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
    private static boolean isValid(String string) {
        return string.matches("[0-9]*") && string != null;
    }

    public static void main(String[] args)throws Exception {
        List<Token> tknArr = new ArrayList<>();
        Stack<String> s = new Stack<String>();

        File text = new File("input.stk");
        
        try(Scanner scanner = new Scanner(text)) {
            while (scanner.hasNextLine()) {
                String element = scanner.nextLine();
                if (isValid(element)) {
                    Token tkn = new Token(TokenType.NUM, element);
                    tknArr.add(tkn);
                } else if (element.equals("*")) {
                    Token tkn = new Token(TokenType.STAR, element);
                    tknArr.add(tkn);
                } else if (element.equals("+")) {
                    Token tkn = new Token(TokenType.PLUS, element);
                    tknArr.add(tkn);
                } else if (element.equals("/")) {
                    Token tkn = new Token(TokenType.SLASH, element);
                    tknArr.add(tkn);
                } else if (element.equals("-")) {
                    Token tkn = new Token(TokenType.MINUS, element);
                    tknArr.add(tkn);
                } else {
                    throw new Exception();
                }
            }
        }

        while (!tknArr.isEmpty()) {
            String element = tknArr
                .remove(0)
                .lexeme;
            if (element == "+" || element == "-" || element == "/" || element == "*") {
                int fst,
                snd;

                fst = Integer.parseInt(s.pop()); snd = Integer.parseInt(s.pop());

                if (element == "+") {
                    s.push(Integer.toString(snd + fst));
                } else if (element == "-") {
                    s.push(Integer.toString(snd - fst));
                } else if (element == "/") {
                    s.push(Integer.toString(snd / fst));
                } else if (element == "*") {
                    s.push(Integer.toString(snd * fst));
                }
                break;
            } else {
                s.push(element);
            }
            break;
        }
        System
            .out
            .println(s.pop());
    }
}
