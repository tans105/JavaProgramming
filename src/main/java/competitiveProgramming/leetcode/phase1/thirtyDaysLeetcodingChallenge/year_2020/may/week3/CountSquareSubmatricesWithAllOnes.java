package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week3;

import utils.ArrayUtils;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/

Count Square Submatrices with All Ones

Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.



Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Example 2:

Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.



Constraints:

    1 <= arr.length <= 300
    1 <= arr[0].length <= 300
    0 <= arr[i][j] <= 1


 */
public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] arr = ArrayUtils.parse2DArray(
                "[\n" +
                        "  [0,1,1,1],\n" +
                        "  [1,1,1,1],\n" +
                        "  [0,1,1,1]\n" +
                        "]");

        System.out.println(countSquares(arr));

        arr = ArrayUtils.parse2DArray("[[1,0,1],[1,1,0],[1,1,0]]");
        System.out.println(countSquares(arr));
    }

    public static int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int count = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] != 0) {
                    int cellValue = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    count += cellValue;
                    dp[i][j] = cellValue;
                } else {
                    dp[i][j] = matrix[i - 1][j - 1];
                }
            }
        }


        return count;
    }
}
