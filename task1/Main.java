import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Main {
    public static boolean isOp(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            Stack<Float> rpn = new Stack<>();
            List<String> lines = Files.readAllLines(Paths.get("Calc1.stk")); 
            
            for (int i = 0; i < lines.size(); i++) {
                String it = lines.get(i);
                if (isOp(it)) {
                    rpn.add(Float.parseFloat(it));
                } else {
                    Float b = rpn.pop(); Float a = rpn.pop();

                    if (it.equals("*")) {
                        rpn.add(a * b);
                    } else if (it.equals("-")) {
                        rpn.add(a - b);
                    } else if (it.equals("/")) {
                        rpn.add(a / b);
                    } else if (it.equals("+")) {
                        rpn.add(a + b);
                    }
                }
            }
            System.out.println(rpn.pop());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}