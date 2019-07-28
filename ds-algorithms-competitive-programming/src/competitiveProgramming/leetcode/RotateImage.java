package competitiveProgramming.leetcode;

//https://leetcode.com/problems/rotate-image/
public class RotateImage {

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */
    public static void main(String[] args) {
        int arr[][] = {
                {2, 1, 0, 1},
                {1, 0, 1, 2},
                {1, 0, 0, 3},
                {1, 0, 2, 3}
        };
        rotate(arr);
    }

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len > 0) {
            int len2 = matrix[0].length;
            if (len2 == 0) {
                return;
            }
            if (len != len2) {
                return;
            }
        } else {
            return;
        }

        int top = 0;
        int bottom = len - 1;

        while (top < bottom) {
            reverseRows(matrix, top, bottom);
            top++;
            bottom--;
        }
        symmetricSwap(matrix, len);
    }

    private static void symmetricSwap(int[][] matrix, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && j > i) {
                    swap(matrix, i, j);
                }
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private static void reverseRows(int[][] matrix, int top, int bottom) {
        int[] auxArray = matrix[top];
        matrix[top] = matrix[bottom];
        matrix[bottom] = auxArray;
    }
}
