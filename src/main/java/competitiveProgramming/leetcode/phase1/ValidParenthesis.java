package competitiveProgramming.leetcode.phase1;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParenthesis {
    public static void main(String[] args) {
        String input = "[(){}";
        System.out.println(isValid(input));
    }

    private static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        int counter = 0;
        while (counter != arr.length) {
            if (stack.isEmpty()) {
                stack.push(arr[counter]);
                counter++;
                continue;
            }
            char top = stack.peek();
            char next = arr[counter];
            if (getOpposite(top) == next) {
                stack.pop();
            } else {
                stack.push(next);
            }
            counter++;

        }

        return stack.isEmpty();
    }

    private static char getOpposite(char c) {
        char opp = 0;
        switch (c) {
            case '{':
                opp = '}';
                break;
            case '[':
                opp = ']';
                break;
            case '(':
                opp = ')';
                break;
        }
        return opp;
    }
}
