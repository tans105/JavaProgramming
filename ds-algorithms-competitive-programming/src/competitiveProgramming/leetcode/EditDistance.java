package competitiveProgramming.leetcode;

import utils.ArrayUtils;

/*
https://leetcode.com/problems/edit-distance/

72. Edit Distance

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
        System.out.println(minDistance("intention", "execution"));
    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;

        if (word1 == null || word1.equals("")) {
            return word2.length();
        }

        if (word2 == null || word2.equals("")) {
            return word1.length();
        }

        int[][] arr = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < arr[0].length; i++) { //col
            arr[0][i] = i;
        }

        for (int i = 0; i < arr.length; i++) { //row
            arr[i][0] = i;
        }


        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1]) + 1;
                }
            }
        }

        return arr[arr.length - 1][arr[0].length - 1];
    }
}
