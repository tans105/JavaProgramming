package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.june.week2;

/*
https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3355/

Is Subsequence

Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("abc", ""));
        System.out.println(isSubsequence("", "abc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() == 0 && t.length() == 0) return true;
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[][] dp = new int[sArr.length + 1][tArr.length + 1];


        for (int i = 1; i <= sArr.length; i++) {
            for (int j = 1; j <= tArr.length; j++) {
                if (sArr[i - 1] == tArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }


        return dp[sArr.length][tArr.length] == sArr.length;
    }
}
