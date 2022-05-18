package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.september.week2;

/*
Maximum Product Subarray

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{2, 0, -1}));
        System.out.println(maxProduct(new int[]{2, 3, 0, -1}));
        System.out.println(maxProduct(new int[]{2, 1, 0, -1, -3}));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxPositiveProduct = 1;
        int minNegativeProduct = 1;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current > 0) {
                maxPositiveProduct = maxPositiveProduct * current;
                max = Math.max(maxPositiveProduct, max);
            } else if (current < 0) {
                maxPositiveProduct = 1;
                if (minNegativeProduct < 0) {
                    max = Math.max(minNegativeProduct * current, max);
                    minNegativeProduct = 1;
                } else {
                    minNegativeProduct = minNegativeProduct * current;
                }
            } else { //current is 0
                minNegativeProduct = 1;
                maxPositiveProduct = 1;
            }
        }

        return max;
    }
}
