package competitiveProgramming.leetcode.topinterviewquestions;

/*
https://leetcode.com/problems/longest-palindromic-substring/

5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("aabababaa"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("b"));
        System.out.println(longestPalindrome(null));
    }

    public static String longestPalindrome(String s) {
        if(s == null) {
            return s;
        }

        String result = "";
        int length = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            String odd = pivot(s, i, i); // odd case
            String even = pivot(s, i, i + 1); // even case
            if (odd.length() > length || even.length() > length) {
                result = odd.length() > even.length() ? odd : even;
                length = Math.max(odd.length(), even.length());
            }
        }

        return result;
    }

    public static String pivot(String s, int i, int j) {
        String palindrome = s.substring(i, j);
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                palindrome = s.substring(i, j + 1);
                j++;
                i--;
            } else {
                break;
            }
        }

        return palindrome;
    }
}
