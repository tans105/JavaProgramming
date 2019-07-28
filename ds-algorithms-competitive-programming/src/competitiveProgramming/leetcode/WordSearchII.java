package competitiveProgramming.leetcode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/word-search/
 * 79. Word Search
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearchII {
    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'K', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(arr, "ABCD"));
    }

    private static boolean exist(char[][] board, String str) {
        ArrayList<String> startIndexes = getIndexes(board, str.charAt(0));
        for (String startIndex : startIndexes) {
            int x = startIndex.charAt(0) - '0';
            int y = startIndex.charAt(1) - '0';

            if (existHelper(board, str, 0, x, y)) {
                return true;
            }

        }
        return false;
    }

    private static boolean existHelper(char[][] arr, String str, int currentIndex, int x, int y) {

        if(currentIndex == str.length()) {
            return true;
        }

        if (x > arr.length - 1 || y > arr[0].length - 1 || x < 0 || y < 0) {
            return false;
        }

        if (arr[x][y] != str.charAt(currentIndex)) {
            return false;
        } else {
            return existHelper(arr, str, currentIndex + 1, x + 1, y) ||
                    existHelper(arr, str, currentIndex + 1, x - 1, y) ||
                    existHelper(arr, str, currentIndex + 1, x, y + 1) ||
                    existHelper(arr, str, currentIndex + 1, x, y - 1);
        }
    }

    private static ArrayList<String> getIndexes(char[][] arr, char myChar) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == myChar) {
                    list.add(i + "" + j);
                }
            }
        }
        return list;
    }
}
