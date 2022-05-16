package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.april.week4;

import java.util.HashMap;

/*
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/

Subarray Sum Equals K
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualK {
    public static void main(String[] args) {
        int[] arr;

        arr = new int[]{1, -1, 1, -1, 1, 1};
        System.out.println(subarraySum2(arr, 1));

    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }


    public static int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(map);
        return count;
    }
}
