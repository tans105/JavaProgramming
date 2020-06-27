package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.june.week4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3373/

Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares sq = new PerfectSquares();
        System.out.println(sq.numSquares(12));
        System.out.println(sq.numSquares(13));
        System.out.println(sq.numSquares(283));
    }

    /*
    Solution 1  - Backtracking
     */
    int minSize = Integer.MAX_VALUE;

    public int numSquares(int n) {
        Set<Integer> perfectSquare = getPerfectSquares(n);
        backtrack(n, 0, 0, n, perfectSquare);
        return minSize;
    }

    private void backtrack(int n, int currentSum, int count, int start, Set<Integer> perfectSquares) {
        if (currentSum > n) return;

        if (currentSum == n) {
            minSize = Math.min(minSize, count);
            return;
        }

        for (int i = 1; i * i <= n; i++) {
            if (perfectSquares.contains(i)) {
                backtrack(n, currentSum + i, count + 1, i, perfectSquares);
            }
        }
    }

    private Set<Integer> getPerfectSquares(int n) {
        Set<Integer> ps = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            double sr = Math.sqrt(i);
            if ((sr - Math.floor(sr)) == 0) {
                ps.add(i);
            }
        }

        return ps;
    }


    /*
    Solution 2 - DP

        dp[0] = 0
        dp[1] = dp[0]+1 = 1
        dp[2] = dp[1]+1 = 2
        dp[3] = dp[2]+1 = 3
        dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
              = Min{ dp[3]+1, dp[0]+1 }
              = 1
        dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
              = Min{ dp[4]+1, dp[1]+1 }
              = 2
                                .
                                .
                                .
        dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
               = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
               = 2
                                .
                                .
                                .
        dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     */
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

}
