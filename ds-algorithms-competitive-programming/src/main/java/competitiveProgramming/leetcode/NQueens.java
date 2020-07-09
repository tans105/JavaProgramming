package competitiveProgramming.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(board, 0, res, board.length);
        return res;
    }

    private static void dfs(char[][] board, int col, List<List<String>> res, int len) {
        if (col == len) {
            res.add(construct(board));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (isSafe(board, col, i, len)) {
                board[i][col] = 'Q';
                dfs(board, col + 1, res, len);
                board[i][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] grid, int col, int row, int n) {
        int i, j;

        /*
        - => yet to decide
        X => targeted to check
        . => not our concern

       [
        X   .   X   -   -
        .   X   X   -   -
        .   .   Q   -   -
        .   X   X   -   -
        X   .   X   -   -
       ]
         */

        //no need to check for the row

        for (i = 0; i < col; i++) { //check all columns in that row
            if (grid[row][i] == 'Q') return false;
        }

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) { //diagonally left upward
            if (grid[i][j] == 'Q')
                return false;
        }

        for (i = row, j = col; j >= 0 && i < n; i++, j--) { //diagonally left downward
            if (grid[i][j] == 'Q')
                return false;
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }
}
