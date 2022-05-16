package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.may.week4;

import utils.ArrayUtils;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3340/

Uncrossed Lines

We write the integers of A and B (in the order they are given) on two separate horizontal lines.

Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:

A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.

Return the maximum number of connecting lines we can draw in this way.


Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
Example 2:

Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3
Example 3:

Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
Output: 2


Note:

1 <= A.length <= 500
1 <= B.length <= 500
1 <= A[i], B[i] <= 2000
 */
public class UncrossedLines {
    public static void main(String[] args) {
        int[] A;
        int[] B;

        A = ArrayUtils.parseArray("[1,9,2,5,1]");
        B = ArrayUtils.parseArray("[1,3,7,1,7,5]");
        System.out.println(maxUncrossedLines(A, B));

        A = ArrayUtils.parseArray("[2,5,1,2,5]");
        B = ArrayUtils.parseArray("[10,5,2,1,5,2]");
        System.out.println(maxUncrossedLines(A, B));

        A = ArrayUtils.parseArray("[1,4,2]");
        B = ArrayUtils.parseArray("[1,2,4]");
        System.out.println(maxUncrossedLines(A, B));
    }


    public static int maxUncrossedLines(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return 0;

        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
