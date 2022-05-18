package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.june.week2;

import utils.ArrayUtils;

/*
https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/

Sort Colors

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:

    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
    Could you come up with a one-pass algorithm using only constant space?


 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums;

        nums = ArrayUtils.parseArray("[2,0,2,1,1,0]");
        sortColors(nums);
        ArrayUtils.printArray(nums);

        nums = ArrayUtils.parseArray("[2,1,2,1,1,2]");
        sortColors(nums);
        ArrayUtils.printArray(nums);

        nums = ArrayUtils.parseArray("[2,1,2]");
        sortColors(nums);
        ArrayUtils.printArray(nums);
    }

    public static void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int index = 0;

        while (index <= two) {
            if (nums[index] == 2) {
                swap(nums, index, two);
                two--;
            } else if (nums[index] == 0) {
                swap(nums, index, zero);
                zero++;
                index++;
            } else {
                index++;
            }
        }
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
