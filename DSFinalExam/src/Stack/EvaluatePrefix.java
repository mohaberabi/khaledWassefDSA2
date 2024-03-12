package Stack;

import java.util.Objects;
import java.util.Stack;

public class EvaluatePrefix {


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

    static double evaluatePrefix(String prefix) {

        Stack<Double> stack = new Stack<>();

        String[] arr = prefix.split(" ");

        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            String exp = arr[i];

            if (isOperator(exp)) {
                double pop1 = stack.pop();
                double pop2 = stack.pop();
                double val = evaluate(pop1, pop2, exp);
                stack.push(val);
            } else {

                stack.push(Double.parseDouble(exp));
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {

        String prefix = "+ 10 2";
        System.out.println(evaluatePrefix(prefix));
    }
}
