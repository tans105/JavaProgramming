package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.week3;


import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/

Valid Parenthesis String

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
 */
public class ValidParenthesisString {
    public static void main(String[] args) {
        String s;

        s = "(*))";
        System.out.println(checkValidString(s)); //true

        s = "()";
        System.out.println(checkValidString(s)); //true

        s = "(*)";
        System.out.println(checkValidString(s)); //true

        s = "((*";
        System.out.println(checkValidString(s)); //false

        s = "(((******))";
        System.out.println(checkValidString(s)); //true

        s = ")";
        System.out.println(checkValidString(s)); //false

        s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        System.out.println(checkValidString(s)); //false
    }

    public static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == ')' && !stack.isEmpty()) {
                stack.pop();
            } else if (current == ')') {
                if (count > 0) count--;
                else return false;
            }

            if (current == '(') {
                stack.push(s.charAt(i));
            }

            if (current == '*') {
                count++;
            }
        }


        return stack.isEmpty() || (count != 0 && stack.size() <= count);
    }
}
