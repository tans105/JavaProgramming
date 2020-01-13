package competitiveProgramming.leetcode;

import utils.ArrayUtils;

import java.util.*;

/*
260. Single Number III

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
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (!set.add(i)) {
                set.remove(i);
            }
        }

        return set.stream().mapToInt(Number::intValue).toArray();
    }
}
