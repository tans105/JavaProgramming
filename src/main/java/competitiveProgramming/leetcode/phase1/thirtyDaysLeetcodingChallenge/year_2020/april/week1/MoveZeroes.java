package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.april.week1;

import utils.ArrayUtils;

/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3286/

Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.parseArray("[0,1,0,3,12]");
        moveZeroes(arr);
        ArrayUtils.printArray(arr);
    }

    public static void moveZeroes(int[] nums) {
        int i = 0; //eligible index to be replaced
        int j = 0; // iterator

        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}
