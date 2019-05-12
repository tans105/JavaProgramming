package competitiveProgramming.leetcode;

import Utils.LoggingUtil;

//https://leetcode.com/problems/longest-palindromic-substring
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "";
        System.out.println(longestPalindromicSubstring(s));
    }

    private static String longestPalindromicSubstring(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }

        int maxLen = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = expandAroundCenter(s, i);
            if(len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int index) {
        int left = index - 1;
        int right = index + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
