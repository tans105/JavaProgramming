package competitiveProgramming.leetcode;

import utils.LoggingUtil;

/*
209. Minimum Size Subarray Sum

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarray {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(3, new int[]{1, 1}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = 1;
        boolean minFound = false;
        int min = Integer.MAX_VALUE;

        if (nums[i] >= s) {
            return 1;
        }

        while (i != nums.length && j != nums.length) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }

            if (sum >= s) {
                minFound = true;
                int len = j - i + 1;
                if (len < min) min = len;
                i++;
            } else {
                j++;
            }
        }

        return minFound ? min : 0;
    }
}
