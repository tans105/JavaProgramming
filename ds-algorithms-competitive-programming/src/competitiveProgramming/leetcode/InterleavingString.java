package competitiveProgramming.leetcode;

import Utils.LoggingUtil;

import java.util.Stack;

/**
 * 97. Interleaving String
 * Hard
 * <p>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        isInterleave(s1, 0, s2, 0, s3, 0);
        return is_Interleave(s1, 0, s2, 0, "", s3);
    }

    private static boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i1 == s1.length() - 1 && i2 == s2.length() - 1 && i3 == s3.length() - 1) {
            return true;
        }
        LoggingUtil.logNewLine(i1, i2, i3);
        boolean ans = false;
        if (i1 < s1.length()) {
            ans |= isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1);
        } else if (i2 < s2.length()) {
            ans |= isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1);
        }

        return ans;
    }

    public static boolean is_Interleave(String s1, int i, String s2, int j, String res, String s3) {
        if (res.equals(s3) && i == s1.length() && j == s2.length())
            return true;
        boolean ans = false;
        LoggingUtil.logNewLine(i, j, res);
        if (i < s1.length())
            ans |= is_Interleave(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        if (j < s2.length())
            ans |= is_Interleave(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        return ans;

    }
}
