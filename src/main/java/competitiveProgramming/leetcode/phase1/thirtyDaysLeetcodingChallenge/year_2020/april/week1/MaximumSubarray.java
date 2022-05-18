package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.april.week1;

/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3285/

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

import utils.ArrayUtils;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.parseArray("[-2,1,-3,4,-1,2,1,-5,4]");
        System.out.println(maxSubArray(arr));

        arr = ArrayUtils.parseArray("[-2,-1,-4]");
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = 0;
        int maxTillNow = Integer.MIN_VALUE;
        boolean isNegative = true;
        int maximum = Integer.MIN_VALUE;

        for (int num : nums) {
            maxSoFar += num;

            if (num > 0) isNegative = false;
            maximum = Math.max(num, maximum);

            if (maxSoFar < 0) {
                maxSoFar = 0;
            }

            if (maxSoFar > maxTillNow) {
                maxTillNow = maxSoFar;
            }

        }
        return (isNegative) ? maximum : maxTillNow;
    }
}
