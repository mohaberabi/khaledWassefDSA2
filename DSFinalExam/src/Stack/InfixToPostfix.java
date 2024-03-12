package Stack;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {


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
        return c == '+' || c == '-' || c == '/' || c == '*' || c == '^';
    }


    static boolean isLeft(char c) {
        return c == '(';
    }

    static boolean isRight(char c) {
        return c == ')';
    }


    static String postFix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (isOperator(c)) {
                while (!stack.isEmpty() && precedence().get(c) <= precedence().get(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else if (isLeft(c)) {
                stack.push(c);
            } else if (isRight(c)) {
                while (!stack.isEmpty() && !isLeft(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String infix = "a+b/c-d*e";
        System.out.println(postFix(infix));
    }

}
