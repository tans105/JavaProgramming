package competitiveProgramming.geekforgeeks;

import utils.ArrayUtils;

/*
Source:  Mircosft Archives
https://www.geeksforgeeks.org/microsoft-interview-experience-for-full-time-position-of-software-engineer-at-bangalore/

Given a binary 2D matrix; sort the martix row wise without converting binary value to decimal
 */
public class RowWiseSortBinaryMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1}
        };

        sort(matrix);
        ArrayUtils.print2DArray(matrix);

    }

    private static void sort(int[][] matrix) {
        sort(matrix, 0, matrix.length - 1, 0);
    }

    private static void sort(int[][] matrix, int start, int end, int col) {
        if (end == start) return;
        if (col == matrix[0].length) return;


        int i = start;
        int j = end;

        while (i < j) {
            if (matrix[i][col] == 0) {
                swap(matrix, i, j);
                j--;
            }

            if (matrix[i][col] == 1) {
                i++;
            }
        }

        int swaps = 0;
        for (int k = start; k <= end; k++) {
            if (matrix[k][col] == 0) swaps++;
        }

        sort(matrix, start, end - swaps, col + 1);
        sort(matrix, end - swaps + 1, end, col + 1);
    }


    private static void swap(int[][] matrix, int i, int j) {
        int[] temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }
}
