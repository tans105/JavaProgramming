package competitiveProgramming.leetcode;

/*
79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */

public class WordSearch {
    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(arr, "SEE"));
    }


    static boolean[][] visited;

    private static boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((word.charAt(0) == board[i][j]) && existHelper(board, arr, i, j, board.length, board[0].length, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean existHelper(char[][] board, char[] arr, int i, int j, int rows, int columns, int index) {
        if (index == arr.length - 1) {
            return true;
        }

        if (i < 0 || i >= rows || j < 0 || j >= columns || board[i][j] != arr[index] || visited[i][j]) return false;

        visited[i][j] = true;
        if (existHelper(board, arr, i + 1, j, rows, columns, index + 1) ||
                existHelper(board, arr, i - 1, j, rows, columns, index + 1) ||
                existHelper(board, arr, i, j + 1, rows, columns, index + 1) ||
                existHelper(board, arr, i, j - 1, rows, columns, index + 1)) return true;

        visited[i][j] = false;
        return false;
    }

}
