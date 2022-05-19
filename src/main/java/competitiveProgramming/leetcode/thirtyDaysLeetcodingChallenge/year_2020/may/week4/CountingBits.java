package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.may.week4;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/

Counting Bits

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]

Example 2:

Input: 5
Output: [0,1,1,2,1,2]

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 */
public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int currentOffset = 1;
        int nextOffset = 2;

        for (int j = 1; j < dp.length; j++) {
            if (j >= nextOffset) {
                currentOffset = nextOffset;
                nextOffset = nextOffset * 2;
            }

            dp[j] = dp[j - currentOffset] + 1;
        }

        return dp;
    }
}
