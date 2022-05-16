package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.june.week4;

import java.util.Arrays;

/*
https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3371/

Find the Duplicate Number

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2

Example 2:

Input: [3,1,3,4,2]
Output: 3

Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.


 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate2(new int[]{1, 3, 3, 3, 4, 2}));
    }

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i]) {
                return nums[i];
            }
            prev = nums[i];
        }

        return -1;
    }

    public static int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
