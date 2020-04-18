package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.week3;

import utils.ArrayUtils;

/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3303/

Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = ArrayUtils.parse2DArray("[\n" +
                "  [1,3,1],\n" +
                "  [1,5,1],\n" +
                "  [4,2,1]\n" +
                "]");
        System.out.println(minPathSum(grid));
        System.out.println(minPathSumDp(grid));


        grid = ArrayUtils.parse2DArray("[\n" +
                "  [1]\n" +
                "]");
        System.out.println(minPathSum(grid));
        System.out.println(minPathSumDp(grid));
    }

    static int minSum = Integer.MAX_VALUE;

    /**
     * Solution 1 using Recursion
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        minPathSumHelper(grid, 0, 0, grid.length, grid[0].length, 0);
        return minSum;
    }

    private static void minPathSumHelper(int[][] grid, int i, int j, int rows, int cols, int sum) {
        if (i < 0 || j < 0 || i >= rows || j >= cols) return;

        if (i == rows - 1 && j == cols - 1) minSum = Math.min(sum + grid[i][j], minSum);

        minPathSumHelper(grid, i + 1, j, rows, cols, sum + grid[i][j]);
        minPathSumHelper(grid, i, j + 1, rows, cols, sum + grid[i][j]);

    }

    /**
     * Solution 2 using Dynamic programming
     *
     * @param grid
     * @return
     */
    public static int minPathSumDp(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < cols; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
