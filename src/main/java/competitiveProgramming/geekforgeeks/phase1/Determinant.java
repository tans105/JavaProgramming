package competitiveProgramming.geekforgeeks.phase1;

/*
https://www.geeksforgeeks.org/determinant-of-a-matrix/

Matrix Determinant
Have the function MatrixDeterminant(strArr) read strArr which will be an array of integers represented as strings. Within the array there will also be "<>" elements which represent break points. The array will make up a matrix where the (number of break points + 1) represents the number of rows. Here is an example of how strArr may look: ["1","2","<>","3","4"]. The contents of this array are row1=[1 2] and row2=[3 4]. Your program should take the given array of elements, create the proper matrix, and then calculate the determinant. For the example above, your program should return -2. If the matrix is not a square matrix, return -1. The maximum size of strArr will be a 6x6 matrix. The determinant will always be an integer.
Examples
Input: new String[] {"5","0","<>","0","5"}
Output: 25
Input: new String[] {"1","2","4","<>","2","1","1","<>","4","1","1"}
Output: -4
 */
public class Determinant {
    public static void main(String[] args) {
        System.out.println(MatrixDeterminant(new String[]{"1", "2", "4", "<>", "2", "1", "1", "<>", "4", "1", "1"}));
    }

    public static String MatrixDeterminant(String[] strArr) {
        int n = 0;

        for (String s : strArr) if (s.equals("<>")) n++;


        int[][] matrix = new int[n + 1][n + 1];
        int row = 0;
        int col = 0;

        for (String s : strArr) {
            if (s.equals("<>")) {
                row++;
                col = 0;
                continue;
            }

            matrix[row][col] = Integer.parseInt(s);
            col++;
        }

        return String.valueOf(calculateDeterminant(matrix, matrix.length));
    }

    private static int calculateDeterminant(int[][] matrix, int n) {
        int sum = 0;
        int sign = 1;
        int len = matrix.length;

        if (len == 1) {
            return matrix[0][0];
        }

        for (int i = 0; i < len; i++) {//finds determinant using row-by-row expansion
            int[][] part = new int[len - 1][len - 1];
            getCofactor(matrix, part, 0, i, n); //creates smaller matrix- values not in same row, column
            sum += sign * matrix[0][i] * (calculateDeterminant(part, n - 1)); //recursive step: determinant of larger determined by smaller.
            sign = sign * -1;
        }


        return sum;
    }

    static void getCofactor(int mat[][], int temp[][], int refRow, int refCol, int n) {
        int i = 0, j = 0;

        // Looping for each element of the matrix
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                // Copying into temporary matrix
                // only those element which are
                // not in given row and column
                if (row != refRow && col != refCol) {
                    temp[i][j++] = mat[row][col];

                    // Row is filled, so increase
                    // row index and reset col
                    //index
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
}
