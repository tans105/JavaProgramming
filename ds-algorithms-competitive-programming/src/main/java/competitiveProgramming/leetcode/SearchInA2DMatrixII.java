package competitiveProgramming.leetcode;

import utils.ArrayUtils;

/*
240. Search a 2D Matrix II

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

{
  {1,   4,  7, 11, 15},
  {2,   5,  8, 12, 19},
  {3,   6,  9, 16, 22},
  {10, 13, 14, 17, 24},
  {18, 21, 23, 26, 30}
}
Given target = 5, return true.

Given target = 20, return false.

 */
public class SearchInA2DMatrixII {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(searchMatrix(arr, 31));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 ) return false;

        int rows = matrix.length - 1;
        int columns = matrix[0].length - 1;

        int current;
        int i = 0;
        int j = columns;

        while (i >= 0 && j >= 0 && j <= columns && i <= rows) {
            current = matrix[i][j];

            if (target == current) {
                return true;
            }
            if (target < current) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
