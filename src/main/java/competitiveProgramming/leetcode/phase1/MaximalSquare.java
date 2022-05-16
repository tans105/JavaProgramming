package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;

/*
221. Maximal Square

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
        MaximalSquare sq = new MaximalSquare();
        System.out.println(sq.maximalSquare(arr));
    }

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        ArrayUtils.print2DArray(dp);
        return maxsqlen * maxsqlen;
    }
}
