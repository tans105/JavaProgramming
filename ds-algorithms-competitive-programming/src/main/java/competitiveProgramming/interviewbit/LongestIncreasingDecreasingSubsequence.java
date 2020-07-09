package competitiveProgramming.interviewbit;

import java.util.Arrays;
import java.util.List;

/*
https://www.interviewbit.com/problems/length-of-longest-subsequence/

Length of Longest Subsequence
Asked in:  Microsoft

Problem Description

Given an 1D integer array A of length N, find the length of longest subsequence which is first increasing then decreasing.



Problem Constraints
0 <= N <= 3000

-107 <= A[i] <= 107



Input Format
The first and the only argument contains an integer array A.



Output Format
Return an integer representing the answer as described in the problem statement.



Example Input
Input 1:

 A = [1, 2, 1]
Input 2:

 A = [1, 11, 2, 10, 4, 5, 2, 1]


Example Output
Output 1:

 3
Output 2:

 6


Example Explanation
Explanation 1:

 [1, 2, 1] is the longest subsequence.
Explanation 2:

 [1 2 10 4 2 1] is the longest subsequence.
 */
public class LongestIncreasingDecreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(longestSubsequenceLength(Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1)));
        System.out.println(longestSubsequenceLength(Arrays.asList(1, 2, 1)));
        System.out.println(longestSubsequenceLength(Arrays.asList(1, 2, 3, 4, 5)));
    }

    public static int longestSubsequenceLength(final List<Integer> A) {
        if (A == null || A.size() == 0) return 0;

        int[] greaterThan = new int[A.size()];
        int[] lessThan = new int[A.size()];
        int longest = 1;

        Arrays.fill(greaterThan, 1);

        for (int i = 0; i < A.size(); i++) {
            int current = A.get(i);
            for (int j = 0; j < i; j++) {
                if (A.get(j) < current) {
                    greaterThan[i] = Math.max(greaterThan[i], greaterThan[j] + 1);
                }
            }
            longest = Math.max(longest, greaterThan[i]);
        }


        for (int i = 1; i < A.size(); i++) {
            int current = A.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (A.get(j) > current) {
                    lessThan[i] = Math.max(Math.max(greaterThan[j] + 1, lessThan[i]), lessThan[j] + 1);
                }
            }

            longest = Math.max(longest, lessThan[i]);
        }

        return longest;
    }
}
