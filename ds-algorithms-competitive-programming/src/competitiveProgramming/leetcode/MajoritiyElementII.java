package competitiveProgramming.leetcode;

import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.List;

/*
229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */
public class MajoritiyElementII {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        int candidate1 = nums[0], candidate2 = nums[0], count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1)
                count1++;
            else if (nums[i] == candidate2)
                count2++;
        }
        if (count1 > nums.length / 3)
            result.add(candidate1);
        if (count2 > nums.length / 3)
            result.add(candidate2);
        return result;
    }
}
