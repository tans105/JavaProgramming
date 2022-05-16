package applications.TicTacToe.pojo;

import utils.ArrayUtils;

public class Board {
    private int[][] board;
    private int dim;
    int moves;

    public Board(int dim) {
        this.dim = dim;
        board = new int[dim][dim];
        moves = 0;
    }

    public boolean setMove(Move move) {
        int x = move.getX();
        int y = move.getY();
        int user = move.getUser();

        if (x >= dim || y >= dim) {
            System.out.println("Invalid move...");
            return false;
        }

        if (board[x][y] != 0) {
            System.out.println("Cell occupied.. try another move...");
            return false;
        }

        board[x][y] = user;
        moves++;

        return true;
    }

    public void displayBoard() {
        ArrayUtils.print2DArray(board);
        System.out.println();
    }

    public boolean isTie() {
        return moves == dim * dim;
    }

    public boolean checkIfOver(Move move) {
        int x= move.getX();
        int y= move.getY();
        int user = move.getUser();

        //row
        int count = 0;
        for (int i = 0; i < dim; i++){
            if (board[i][y] == user) count++;
            else break;
        }
        if (count == dim) return true;

        //col
        count = 0;
        for (int i = 0; i < dim; i++) {
            if (board[x][i] == user) count++;
            else break;
        }
        if (count == dim) return true;

        //diagonal 1
        count = 1;
        for (int i = 1; i < dim; i++) {
            if (x + i < dim && y + i < dim) {
                if (board[x + i][y + i] == user) count++;
                else break;
            } else break;
        }

        for (int i = 1; i < dim; i++) {
            if (x - i >= 0 && y - i >= 0) {
                if (board[x - i][y - i] == user) count++;
                else break;
            } else break;
        }

        if (count == dim) return true;


        //diagonal 2
        count = 1;
        for (int i = 1; i < dim; i++) {
            if (x - i >= 0 && y + i < dim) {
                if (board[x - i][y + i] == user) count++;
                else break;
            } else break;
        }

        for (int i = 1; i < dim; i++) {
            if (x + i < dim && y - i >= 0) {
                if (board[x + i][y - i] == user) count++;
                else break;
            } else break;
        }

        return count == dim;
    }
}
