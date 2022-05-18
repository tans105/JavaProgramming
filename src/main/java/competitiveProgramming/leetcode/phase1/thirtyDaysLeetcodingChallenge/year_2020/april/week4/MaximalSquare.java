package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.april.week4;

/*
Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'0', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '0', '1', '1', '1'}
        };
        competitiveProgramming.leetcode.phase1.MaximalSquare sq = new competitiveProgramming.leetcode.phase1.MaximalSquare();
        System.out.println(sq.maximalSquare(arr));
    }

    public static int maximalSquare(char[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0)
            return 0;

        int max = 0, n = a.length, m = a[0].length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }
}
