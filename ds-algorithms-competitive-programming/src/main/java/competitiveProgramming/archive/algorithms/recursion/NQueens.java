package competitiveProgramming.archive.algorithms.recursion;

public class NQueens {

    private static int N;

    public static void main(String[] args) {

        int board[][] = new int[5][5];
        N = 5;
        initNQueen(board);
    }

    private static void initNQueen(int[][] board) {
        if (nQueen(board, 0)) {
            printSolution(board);
        }
    }

    private static boolean nQueen(int[][] board, int col) {
        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, col, i)) {
                board[i][col] = 1;
                if (nQueen(board, col + 1)) {
                    return true;
                }
            }
            board[i][col] = 0;
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int col, int row) {
        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }
}
