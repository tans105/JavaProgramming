package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.week4;

import java.util.Arrays;

/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3310/

Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        /*
        0  - unknown
        1  - good
        -1 - bad
         */
        Arrays.fill(memo, 0);
        return canJump(nums, 0, nums.length - 1, memo);
    }

    private static boolean canJump(int[] nums, int currentIndex, int target, int[] memo) {
        if (memo[currentIndex] != 0) {
            return memo[currentIndex] == 1;
        }

        if (currentIndex > target) {
            return false;
        }

        if (currentIndex == target) {
            return true;
        }

        for (int i = 1; i <= nums[currentIndex]; i++) {
            if (canJump(nums, currentIndex + i, target, memo)) {
                memo[i] = 1;
                return true;
            }
        }

        memo[currentIndex] = -1;
        return false;
    }
}
