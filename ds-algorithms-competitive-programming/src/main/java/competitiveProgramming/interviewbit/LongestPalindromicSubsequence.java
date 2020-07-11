package competitiveProgramming.interviewbit;

import java.util.Arrays;

/*
https://www.interviewbit.com/problems/longest-palindromic-subsequence/

Longest Palindromic Subsequence

Problem Description

Given a string A, find the common palindromic sequence ( A sequence which does not need to be contiguous and is a pallindrome), which is common in itself.

You need to return the length of longest palindromic subsequence in A.

NOTE:

Your code will be run on multiple test cases (<=10). Try to come up with an optimised solution.


Problem Constraints
1 <= |A| <= 1005



Input Format
First and only argument is an string A.



Output Format
Return a integer denoting the length of longest palindromic subsequence in A.



Example Input
Input 1:

 A = "bebeeed"


Example Output
Output 1:

 4


Example Explanation
Explanation 1:

 The longest common pallindromic subsequence is "eeee", which has a length of 4
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(solve("bebeeed"));
    }

    public static int solve(String str) {
        if (str == null || str.length() == 0) return 0;
        int[][] memo = new int[str.length()][str.length()];

        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return recur(str, 0, str.length() - 1, memo);
    }

    private static int recur(String str, int i, int j, int[][] memo) {
        if (i == j) return 1; // single character will always be palindrome
        if (i > j) return 0;

        if (memo[i][j] != -1) { //memoization to reduce repeated computations
            return memo[i][j];
        }

        if (str.charAt(i) == str.charAt(j)) {
            //if character matches at ith and jth position, longest is 2(for ith and jth position) + substring(i+1,j-1)
            memo[i][j] = 2 + recur(str, i + 1, j - 1, memo);
        } else {
            //if character does not matches at ith and jth position, longest is Max of (substring(i,j-1),substring(i+1,j))
            memo[i][j] = Math.max(recur(str, i + 1, j, memo), recur(str, i, j - 1, memo));
        }

        return memo[i][j];
    }
}
