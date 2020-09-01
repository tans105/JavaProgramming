package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.august.week5;

import utils.ArrayUtils;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3442/

Largest Component Size by Common Factor

Given a non-empty array of unique positive integers A, consider the following graph:

    There are A.length nodes, labelled A[0] to A[A.length - 1];
    There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.

Return the size of the largest connected component in the graph.
 */
public class LargestComponentSizeByCommonFactor {
    public static void main(String[] args) {
        System.out.println(largestComponentSize(new int[]{4, 6, 15, 35}));
        System.out.println(largestComponentSize(new int[]{20, 50, 9, 63}));
        System.out.println(largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
    }

    //not working
    public static int largestComponentSize(int[] A) {
        if (A == null || A.length == 0) return 0;

        Arrays.sort(A);
        int[] dp = new int[A.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < A.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int gcd = getGCD(A[i], A[j]);
                if (gcd != 1) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        ArrayUtils.printArray(dp);

        return 0;

    }

    private static int getGCD(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        if (a == b) return a;

        if (a > b) return getGCD(a - b, b);
        else return getGCD(a, b - a);


    }
}
