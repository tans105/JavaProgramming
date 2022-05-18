package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.july.week4;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3399/

Single Number III

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        ArrayUtils.printArray(singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
    }

    public static int[] singleNumber(int[] nums) {
        int[] result = new int[2];

        if (nums == null) return result;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result[i] = entry.getKey();
                i++;
            }
        }

        return result;
    }
}
