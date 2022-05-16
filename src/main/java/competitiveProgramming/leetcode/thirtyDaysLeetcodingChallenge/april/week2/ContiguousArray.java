package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.april.week2;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/

Contiguous Array
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {
    public static void main(String[] args) {
        int[] arr;

        arr = new int[]{0, 1, 0};
        System.out.println(findMaxLength(arr));

        arr = new int[]{0, 1};
        System.out.println(findMaxLength(arr));

        arr = new int[]{0, 0, 1, 0, 0, 0, 1, 1};
        System.out.println(findMaxLength(arr));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        List<Integer> indexes = new ArrayList<>();
        int sum = 0;
        int maxCount = 0;

        indexes.add(0);
        countMap.put(0, indexes);

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] == 0)) sum--;
            else sum++;

            indexes = (countMap.containsKey(sum)) ? countMap.get(sum) : new ArrayList<>();
            indexes.add(i + 1);

            if (indexes.size() >= 2) maxCount = Math.max(maxCount, indexes.get(indexes.size() - 1) - indexes.get(0));
            countMap.put(sum, indexes);
        }

        return maxCount;
    }
}
