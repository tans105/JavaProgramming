package competitiveProgramming.leetcode;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/*
73. Set Matrix Zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = ArrayUtils.parse2DArray("[" +
                "[3,7,2,8,2]," +
                "[2,2,4,1,8]," +
                "[0,5,7,6,3]," +
                "[8,1,0,7,7]," +
                "[1,3,7,4,1]," +
                "[6,5,5,6,3]," +
                "[7,1,0,1,9]," +
                "[5,4,4,9,7]," +
                "[2,2,4,1,0]," +
                "[7,1,1,9,1]," +
                "[8,0,4,7,6]," +
                "[7,5,1,2,3]," +
                "[7,2,5,9,3]" +
                "]");
        setZeroes(matrix);
        ArrayUtils.print2DArray(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        int columLength = matrix.length;
        int rowLength = matrix[0].length;
        List<int[]> zeroIndexes = getZeroesIndexes(matrix);
        for (int[] index : zeroIndexes) {
            int row = index[0];
            int col = index[1];
            for (int i = 0; i < rowLength; i++) {
                matrix[row][i] = 0;
            }
            for (int i = 0; i < columLength; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    private static List<int[]> getZeroesIndexes(int[][] matrix) {
        List<int[]> zeroList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroList.add(new int[]{i, j});
                }
            }
        }
        return zeroList;
    }
}
