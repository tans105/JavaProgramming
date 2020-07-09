package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.april.week1;

import java.util.HashSet;

/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3283/

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1};
        System.out.println(singleNumber(arr));

        arr = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int eleSum = 0;
        for (int num : nums) {
            set.add(num);
            sum += num;
        }

        for (Integer integer : set) {
            eleSum += 2 * integer;
        }

        return eleSum - sum;
    }
}
