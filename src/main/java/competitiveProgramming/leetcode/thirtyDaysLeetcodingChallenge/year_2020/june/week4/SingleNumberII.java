package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.june.week4;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/

Single Number II

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3

Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99


 */
public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
        System.out.println(singleNumber(new int[]{43, 16, 45, 89, 45, -2147483648, 45, 2147483646, -2147483647, -2147483648, 43, 2147483647, -2147483646, -2147483648, 89, -2147483646, 89, -2147483646, -2147483647, 2147483646, -2147483647, 16, 16, 2147483646, 43}));
    }

    public static int singleNumber(int[] nums) {
        long sum = 0;
        long threeSum = 0;
        Set<Long> hash = new HashSet<>();

        for (int num : nums) {
            if (hash.add((long) num)) {
                threeSum += 3 * (long) num;
            }
            sum += num;
        }

        return (int) ((threeSum - sum) / 2);
    }
}
