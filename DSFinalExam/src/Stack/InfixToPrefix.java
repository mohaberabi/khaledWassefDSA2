package Stack;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPrefix {
    static HashMap<Character, Integer> precedence() {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('^', 3);
        map.put('*', 2);
        map.put('/', 2);
        map.put('+', 1);
        map.put('-', 1);

        return map;
    }

    static boolean isOperator(char c) {
        return c == '+'
                || c == '-'
                || c == '/'
                || c == '*'
                || c == '^';
    }


    static boolean isLeft(char c) {
        return c == '(';
    }

    static boolean isRight(char c) {
        return c == ')';
    }


    static String infixToPrefix(String exp) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int n = exp.length();
        for (int i = n - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (isOperator(c)) {
                while (!stack.isEmpty() && precedence().get(c) <= precedence().get(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else if (isLeft(c)) {
                while (!stack.isEmpty() && !isLeft(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else if (isRight(c)) {
                stack.push(c);
            } else {
                sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {

        String exp = "x^y^z";
        System.out.println(infixToPrefix(exp));
    }
}
