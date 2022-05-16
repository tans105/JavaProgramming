package competitiveProgramming.leetcode.phase1;

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

    private static boolean isInterleave(String s1, String s2, String s3) {
        int[][] memo = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return isInterleave(s1, 0, s2, 0, s3, 0, memo);
    }


    private static boolean isInterleave(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }

        if (memo[i][j] >= 0) {
            return memo[i][j] == 1;
        }
        boolean ans = false;

        if (s3.charAt(k) == s1.charAt(i) && isInterleave(s1, i + 1, s2, j, s3, k + 1, memo)
                || s3.charAt(k) == s2.charAt(j) && isInterleave(s1, i, s2, j + 1, s3, k + 1, memo)) {
            ans = true;
        }

        memo[i][j] = ans ? 1 : 0;
        return ans;

    }
}
