package competitiveProgramming.leetcode.topinterviewquestions;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/

20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
Accepted
2,305,289
Submissions

 */
public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("("));
        System.out.println(isValid("(["));
        System.out.println(isValid("([]"));
        System.out.println(isValid("([]]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid(""));
        System.out.println(isValid("({[)"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {return false;}

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int i = 1;

        while (i < s.length()) {
            char next = s.charAt(i);
            if(stack.size() > 0) {
                Character top = stack.peek();
                char opposite = getOpposite(top);
                if(next == opposite) stack.pop();
                else stack.push(next);
            } else {
                stack.push(next);
            }

            i++;
        }

        return stack.size() == 0;
    }

    public static char getOpposite(char c) {
        switch (c) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
        }

        return '-';
    }
}
