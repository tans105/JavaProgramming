package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
678. Valid Parenthesis String

https://leetcode.com/problems/valid-parenthesis-string/

Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.

Example 1:
Input: "()"
Output: True

Example 2:
Input: "(*)"
Output: True

Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
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
        int low = 0; // minimum value of the range
        int high = 0; // maximum value of the range

        for (char c : s.toCharArray()) {
            if (c == '(') { // this would always increase the bound
                low++;
                high++;
            } else if (c == ')') {
                if (low > 0) low--; // reduce if there is bandwidth
                high--;
            } else {
                if (low > 0) low--; // reduce if there is bandwidth
                high++;
            }
            if (high < 0) return false; //nothing can balance it now, something like ')**()'
        }

        return low == 0;
    }

}
