package competitiveProgramming.geekforgeeks;

import utils.ArrayUtils;

public class MaxSumPathOfMatrixFromTopToBottom {
    public static void main(String[] args) {
        int mat[][] = new int[][]{
                {5, 6, 1, 7},
                {-2, 10, 8, -1},
                {3, -7, -9, 11},
                {12, -4, 2, 6}};

        System.out.println(maxSum(mat));
    }

    static int[] overallSum = new int[4];

    public static int maxSum(int[][] mat) {
        for (int i = 0; i < mat[0].length; i++) {
            maxSumHelper(mat, 0, i, mat[0][i], i);
        }
        ArrayUtils.printArray(overallSum);
        return 0;
    }

    private static void maxSumHelper(int[][] mat, int i, int j, int sum, int row) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length) return;

        int column = 0;

        if (i + 1 < mat.length) {
            if (j + 1 >= mat[i].length) {
                column = j - 1;
                sum += mat[i + 1][j - 1];
            } else if (j - 1 < 0) {
                column = j + 1;
                sum += mat[i + 1][j + 1];
            } else {
                if (mat[i + 1][j - 1] > mat[i + 1][j + 1]) {
                    column = j - 1;
                    sum += mat[i + 1][j - 1];
                } else {
                    column = j + 1;
                    sum += mat[i + 1][j + 1];
                }
            }
        }

        if (i == mat.length - 1) {
            if (sum > overallSum[row]) {
                overallSum[row] = sum;
            }
            return;
        }

        maxSumHelper(mat, i + 1, column, sum, row);
    }

}
