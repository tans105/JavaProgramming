package competitiveProgramming.leetcode;

/*
63. Unique Paths II

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?


An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(arr));
    }

    static int paths = 0;

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        uniquePathHelper(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length);
        return paths;
    }

    private static void uniquePathHelper(int[][] obstacleGrid, int i, int j, int row, int col) {

        if (i < 0 || j < 0 || i >= row || j >= col) {
            return;
        }

        if (obstacleGrid[i][j] == 1) return;

        if (i == row - 1 && j == col - 1) {
            paths++;
        }

        uniquePathHelper(obstacleGrid, i + 1, j, row, col);
        uniquePathHelper(obstacleGrid, i, j + 1, row, col);
    }

}
