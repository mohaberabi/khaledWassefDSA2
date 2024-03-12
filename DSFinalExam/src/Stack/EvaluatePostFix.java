package Stack;

import java.util.Objects;
import java.util.Stack;

public class EvaluatePostFix {


    static double evaluate(double a, double b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            case "*" -> a * b;
            default -> Math.pow(a, b);
        };
    }


    static boolean isOperator(String op) {

        return Objects.equals(op, "+") ||
                Objects.equals(op, "-") ||
                Objects.equals(op, "/") ||
                Objects.equals(op, "*") ||
                Objects.equals(op, "^");
    }

    static double evaluatePostFix(String postfix) {

        String[] arr = postfix.split(" ");
        Stack<Double> stack = new Stack<>();
        for (String exp : arr) {

            if (isOperator(exp)) {
                double pop1 = stack.pop();
                double pop2 = stack.pop();
                double val = evaluate(pop2, pop1, exp);
                stack.push(val);
            } else {
                stack.push(Double.parseDouble(exp));
            }
        }

        return stack.peek();

    }

    public static void main(String[] args) {
        String postFix = "10 2 * 3 +";
        double val = evaluatePostFix(postFix);
        System.out.println(val);
    }

}
