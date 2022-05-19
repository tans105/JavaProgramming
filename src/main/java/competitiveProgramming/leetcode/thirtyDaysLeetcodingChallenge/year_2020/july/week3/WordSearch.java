package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.july.week3;

import utils.ArrayUtils;

import java.util.*;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3397/

Word Search

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



Constraints:

    board and word consists only of lowercase and uppercase English letters.
    1 <= board.length <= 200
    1 <= board[i].length <= 200
    1 <= word.length <= 10^3


 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] arr = ArrayUtils.parse2DCharArray("[\n" +
                "  ['A','B','C','E'],\n" +
                "  ['S','F','C','S'],\n" +
                "  ['A','D','E','E']\n" +
                "]");

        System.out.println(exist(arr, "ABCCED"));
        System.out.println(exist(arr, "SEE"));
        System.out.println(exist(arr, "ABCB"));

        arr = new char[][]{{'a'}};
        System.out.println(exist(arr, "b"));
    }

    public static boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return false;

        boolean[][] visited;

        Map<Character, List<List<Integer>>> charactersMapping = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<List<Integer>> characterMap = charactersMapping.getOrDefault(board[i][j], new ArrayList<>());
                characterMap.add(Arrays.asList(i, j));
                charactersMapping.put(board[i][j], characterMap);
            }
        }


        if(charactersMapping.containsKey(word.charAt(0))) {
            for (List<Integer> coordinates : charactersMapping.get(word.charAt(0))) {
                visited = new boolean[board.length][board[0].length];
                if (checkRecursive(board, word, coordinates.get(0), coordinates.get(1), board.length - 1, board[0].length - 1, visited, 0))
                    return true;
            }
        }

        return false;
    }

    private static boolean checkRecursive(char[][] board, String word, Integer i, Integer j, int rows, int cols, boolean[][] traversed, int currentIndex) {
        if (i < 0 || j < 0 || i > rows || j > cols || board[i][j] != word.charAt(currentIndex) || traversed[i][j]) {
            return false;
        }

        if (currentIndex == word.length() - 1) {
            return true;
        }

        traversed[i][j] = true;

        if (checkRecursive(board, word, i + 1, j, rows, cols, traversed, currentIndex + 1)
                || checkRecursive(board, word, i, j + 1, rows, cols, traversed, currentIndex + 1)
                || checkRecursive(board, word, i - 1, j, rows, cols, traversed, currentIndex + 1)
                || checkRecursive(board, word, i, j - 1, rows, cols, traversed, currentIndex + 1)) return true;

        traversed[i][j] = false;

        return false;
    }
}
