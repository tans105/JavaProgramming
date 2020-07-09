package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week5;

import utils.ArrayUtils;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3346/

Edit Distance
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */
public class EditDistance {
    public static void main(String[] args) {
        String word1;
        String word2;

        word2 = "horse";
        word1 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null || word1.equals("")) return word2.length();
        if (word2 == null || word2.equals("")) return word1.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < dp.length; i++) dp[i][0] = i;
        for (int j = 1; j < dp[0].length; j++) dp[0][j] = j;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
