package competitiveProgramming.leetcode;

import utils.ArrayUtils;
import utils.LoggingUtil;

/*
516. Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseqRecursieve("agbdba"));
        System.out.println(longestPalindromeSubseqDP("agbdba"));
        System.out.println(longestPalindromeSubseqMyApproach("agbdba"));
    }

    private static int longestPalindromeSubseqMyApproach(String str) {
        int len = str.length();
        int[][] arr = new int[len][len];

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
        }

        int k = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < k; j++) {
                int x = j;
                int y = j + i + 1;

                if (str.charAt(x) == str.charAt(y)) {
                    arr[x][y] = arr[x + 1][y - 1] + 2;
                } else {
                    arr[x][y] = Math.max(arr[x][y - 1], arr[x + 1][y]);
                }
            }
            k--;
        }

        return arr[0][arr.length - 1];
    }

    private static int longestPalindromeSubseqDP(String s) {
        char[] str = s.toCharArray();
        int arr[][] = new int[str.length][str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i][i] = 1;
        }

        for (int k = 2; k <= arr.length; k++) {
            for (int i = 0; i < arr.length - k + 1; i++) {
                int j = i + k - 1;
                if (str[i] == str[j] && k == 2)
                    arr[i][j] = 2;
                else if (str[i] == str[j])
                    arr[i][j] = arr[i + 1][j - 1] + 2;
                else
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i + 1][j]);
            }
        }

        return arr[0][arr.length - 1];
    }

    public static int longestPalindromeSubseqRecursieve(String s) {
        return calculateRecursive(s.toCharArray(), 0, s.length());
    }

    private static int calculateRecursive(char[] str, int index, int len) {
        if (len == 1) {
            return 1;
        }
        if (len == 0) {
            return 0;
        }
        if (str[index] == str[index + len - 1]) {
            return 2 + calculateRecursive(str, index + 1, len - 2);
        } else {
            return Math.max(calculateRecursive(str, index + 1, len - 1), calculateRecursive(str, index, len - 1));
        }
    }
}
