package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.july.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3406/

Word Break II

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]


 */
public class WordBreakII {
    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentance = new ArrayList<>();
        wordBreakHelper(s, "", wordDict, sentance);
        return sentance;
    }

    private static void wordBreakHelper(String s, String out, List<String> wordDict, List<String> sentance) {
        if (s.length() == 0) {
            sentance.add(out);
        }

        for (int i = 1; i < s.length() + 1; i++) {
            String temp = s.substring(0, i);
            if (wordDict.contains(temp)) {
                if(out.equals("")) {
                    wordBreakHelper(s.substring(i), temp, wordDict, sentance);
                } else {
                    wordBreakHelper(s.substring(i), out + " " + temp, wordDict, sentance);
                }
            }
        }
    }
}
