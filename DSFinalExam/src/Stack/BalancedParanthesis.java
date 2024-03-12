package Stack;

import java.util.Stack;

public class BalancedParanthesis {


    static boolean balanced(String exp) {

        Stack<Character> stack = new Stack<>();


        for (char c : exp.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else if (stack.isEmpty() || !isBalanced(stack.pop(), c)) {
                return false;
            }

        }

        return stack.isEmpty();

    }

    static boolean isOpen(char c) {
        return c == '(' ||
                c == '[' ||
                c == '{';
    }


    static boolean isBalanced(char a, char b) {
        return (a == '(' && b == ')') ||
                (a == '{' && b == '}') ||
                (a == '[' && b == ']');
    }

    public static void main(String[] args) {
        String exp = "[((({{{}}})))]";
        boolean bal = balanced(exp);
        System.out.println(bal);
    }
}
