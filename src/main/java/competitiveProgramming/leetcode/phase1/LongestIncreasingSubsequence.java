package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;

import java.util.Arrays;

/*
300. Longest Increasing Subsequence
Medium

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 2, 3}));
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int[] llis = new int[nums.length];
        Arrays.fill(llis, 1);
        int max = 1;

        int i = 0, j = 0;
        while (i != nums.length) {
            while (j < i) {
                if (nums[j] < nums[i]) {
                    llis[i] = Math.max(llis[j] + 1, llis[i]);
                    max = Math.max(llis[i], max);
                }
                j++;
            }
            i++;
            j = 0;
        }

        return max;
    }
}
