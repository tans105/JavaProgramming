package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.june.week5;

import utils.ArrayUtils;

import java.util.*;

/*
https://leetcode.com/explore/featured/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3376/

Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]



Note:

    All inputs are consist of lowercase letters a-z.
    The values of words are distinct.


 */
public class WordSearchII {
    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();
        char[][] arr = ArrayUtils.parse2DCharArray("[\n" +
                "  ['o','a','a','n'],\n" +
                "  ['e','t','a','e'],\n" +
                "  ['i','h','k','r'],\n" +
                "  ['i','f','l','v']\n" +
                "]");

        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(ws.findWords(arr, words));

        ArrayUtils.print2DArray(arr);
        words = new String[]{"aaa"};
        System.out.println(ws.findWords(arr, words));
    }

    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null || words.length == 0) {
            return result;
        }

        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                recursiveFindWords(board, root, i, j);
            }
        }

        return result;
    }

    private void recursiveFindWords(char[][] board, TrieNode parent, int x, int y) {
        if (outOfBounds(board, x, y) || board[x][y] == '#' || parent.children.get(board[x][y]) == null) {
            return; // return if out of bounds, if visited and if current cell is not a character in the trie
        }

        char xy = board[x][y];
        TrieNode child = parent.children.get(xy);
        if (child.isEndOfWord) { // Found a word
            result.add(child.word);
            child.isEndOfWord = false; // Set to false to avoid adding word to result multiple times
            // Don't RETURN since child.word can be a prefix of other words, e.g., 'ane' and 'aneis'
        }

        board[x][y] = '#'; // '#' marks a cell as visited

        recursiveFindWords(board, child, x, y - 1); // left
        recursiveFindWords(board, child, x - 1, y); // up
        recursiveFindWords(board, child, x, y + 1); // right
        recursiveFindWords(board, child, x + 1, y); // down

        board[x][y] = xy; // Set as unvisited since we are about to backtracking
    }

    private boolean outOfBounds(char[][] board, int x, int y) {
        return x < 0 || x >= board.length || y < 0 || y >= board[0].length;
    }

    // The trie is represented by a root node, not a Trie object
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            if (word == null || word.isEmpty()) {
                continue;
            }

            TrieNode parent = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);

                TrieNode child = parent.children.get(cur);
                if (child == null) {
                    child = new TrieNode();
                    parent.children.put(cur, child);
                }

                parent = child;
            }

            parent.isEndOfWord = true;
            parent.word = word; // Store a word at the leaf node
        }

        return root;
    }

    private class TrieNode {
        boolean isEndOfWord; // this.word is null if isEndOfWord is false
        String word; // Store the word so that no StringBuilder is needed to build the word char by char
        Map<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
        }
    }
}
