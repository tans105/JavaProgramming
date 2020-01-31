package competitiveProgramming.mustdoquestions.strings;

import utils.LoggingUtil;

/*
Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index ).

NOTE: Required Time Complexity O(n2).

Input:
The first line of input consists number of the testcases. The following T lines consist of a string each.

Output:
In each separate line print the longest palindrome of the string given in the respective test case.

Constraints:
1 ≤ T ≤ 100
1 ≤ Str Length ≤ 104

Example:
Input:
1
aaaabbaa

Output:
aabbaa

Explanation:
Testcase 1: The longest palindrome string present in the given string is "aabbaa".
 */
public class LongestPalindromeInString {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("baabaa"));
    }

    private static String longestPalindromicSubstring(String s) {
        int max = 1;
        String result = "";
        boolean isOdd = false;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            isOdd = len1 > len2;

            int len = Math.max(len1, len2);

            if (len > max) {
                max = len;
                if (isOdd) {
                    result = s.substring(i - len + 1, i + len);
                } else {
                    result = s.substring(i - len + 1, i + len + 1);
                }
            }
        }

        return result;
    }

    private static int expandAroundCenter(String s, int l, int r) {
        int count = 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            count++;
        }

        return count;
    }
}
