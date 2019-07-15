package competitiveProgramming.leetcode;

import Utils.LoggingUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/word-ladder/
 * <p>
 * 127. Word Ladder
 * Medium
 * <p>
 * 1559
 * <p>
 * 832
 * <p>
 * Favorite
 * <p>
 * Share
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        getMinLadderLength(beginWord, endWord, wordList, 1);
        return MAX_COUNT;
    }

    private static int MAX_COUNT = Integer.MAX_VALUE;

    private static void getMinLadderLength(String beginWord, String endWord, List<String> remainingWordList, int count) {
        List<String> nextValidWords = getNextValidWords(beginWord, remainingWordList);
        LoggingUtil.logNewLine(beginWord, nextValidWords, remainingWordList, count);
        if (nextValidWords.contains(endWord)) {
            if (count < MAX_COUNT) {
                MAX_COUNT = count + 1;
            }
        }
        for (String nextValidWord : nextValidWords) {
            List<String> list = createNewList(nextValidWord, remainingWordList);
            getMinLadderLength(nextValidWord, endWord, list, count + 1);
        }
    }

    private static List<String> createNewList(String s, List<String> remainingWordList) {
        List<String> remaining = new ArrayList<>();
        int i = 0;
        int count = remainingWordList.size();
        while (i != count) {
            if (!remainingWordList.get(i).equals(s)) {
                remaining.add(remainingWordList.get(i));
            }
            i++;
        }
        return remaining;
    }

    private static List<String> getNextValidWords(String beginWord, List<String> remainingWordList) {
        List<String> nextValidWords = new ArrayList<>();
        for (String s : remainingWordList) {
            int diff = 0;
            for (int j = 0; j < beginWord.length(); j++) {
                if (beginWord.charAt(j) != s.charAt(j)) diff++;
            }
            if (diff == 1) {
                nextValidWords.add(s);
            }
        }
        return nextValidWords;
    }
}
