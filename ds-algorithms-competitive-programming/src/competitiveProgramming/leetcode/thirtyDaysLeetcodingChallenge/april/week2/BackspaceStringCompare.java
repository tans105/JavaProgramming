package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.april.week2;


import java.util.Stack;

/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3291/

Backspace String Compare

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
        System.out.println(backspaceCompare(S, T));

        S = "a#c";
        T = "b";
        System.out.println(backspaceCompare(S, T));

        S = "ab##";
        T = "c#d#";
        System.out.println(backspaceCompare(S, T));

        S = "a##c";
        T = "a##c";
        System.out.println(backspaceCompare(S, T));
    }

    public static boolean backspaceCompare(String S, String T) {
        String sComp = getCompressedString(S);
        String tComp = getCompressedString(T);
        return sComp.equals(tComp);
    }

    private static String getCompressedString(String s) {
        Stack<Character> one = new Stack<>();
        Stack<Character> two = new Stack<>();

        char[] chars = s.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            one.push(chars[i]);
        }

        while (!one.isEmpty()) {
            char c = one.pop();
            if (c == '#') {
                if (two.size() > 0) {
                    two.pop();
                }
            } else {
                two.push(c);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (char c : two) {
            builder.append(c);
        }

        return builder.toString();
    }
}
