package competitiveProgramming.random;

/*
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

        return String.valueOf(calculateDeterminant(matrix));
    }

    private static int calculateDeterminant(int[][] matrix) {
        int sum = 0;
        int sign;
        int len = matrix.length;

        if (len == 1) {
            return matrix[0][0];
        }

        for (int i = 0; i < len; i++) {
            int[][] part = new int[len - 1][len - 1];
            for (int a = 1; a < len; a++) {
                for (int b = 0; b < len; b++) {
                    if (b < i) part[a - 1][b] = matrix[a][b];
                    else if (b > i) part[a - 1][b - 1] = matrix[a][b];
                }
            }

            if (i % 2 == 0) sign = 1;
            else sign = -1;

            sum += sign * matrix[0][i] * (calculateDeterminant(part));
        }


        return sum;
    }

}
