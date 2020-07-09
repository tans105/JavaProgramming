package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.july.week2;

import java.util.*;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3384/

3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]


 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<>();
        if (nums == null || nums.length < 3) return threeSum;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int desiredSum = nums[i] * -1;
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    int currentSum = nums[low] + nums[high];
                    if (currentSum == desiredSum) {
                        threeSum.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                    }

                    if (currentSum < desiredSum) low++;
                    else high--;
                }
            }
        }

        return threeSum;
    }
}
