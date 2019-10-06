package competitiveProgramming.leetcode;

/*
152. Maximum Product Subarray

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

import utils.ArrayUtils;
import utils.LoggingUtil;

import java.util.Arrays;

public class MaxProductSubarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    private static int maxProduct(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int n = arr.length;
        // max positive product ending at the current position
        int max_ending_here = 1;

        // min negative product ending at the current position
        int min_ending_here = 1;

        // Initialize overall max product
        int max_so_far = 1;
        int flag = 0;

        /* Traverse through the array. Following
        values are maintained after the ith iteration:
        max_ending_here is always 1 or some positive product
                        ending with arr[i]
        min_ending_here is always 1 or some negative product
                        ending with arr[i] */
        for (int value : arr) {
            /* If this element is positive, update max_ending_here.
                Update min_ending_here only if min_ending_here is
                negative */
            if (value > 0) {
                max_ending_here = max_ending_here * value;
                min_ending_here = Math.min(min_ending_here * value, 1);
                flag = 1;
            }

            /* If this element is 0, then the maximum product cannot
            end here, make both max_ending_here and min_ending
            _here 0
            Assumption: Output is alway greater than or equal to 1. */
            else if (value == 0) {
                max_ending_here = 1;
                min_ending_here = 1;
            }

            /* If element is negative. This is tricky
            max_ending_here can either be 1 or positive.
            min_ending_here can either be 1 or negative.
            next min_ending_here will always be prev.
            max_ending_here * arr[i]
            next max_ending_here will be 1 if prev
            min_ending_here is 1, otherwise
            next max_ending_here will be
                        prev min_ending_here * arr[i] */
            else {
                int temp = max_ending_here;
                max_ending_here = Math.max(min_ending_here * value, 1);
                min_ending_here = temp * value;
            }

            // update max_so_far, if needed
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }

        LoggingUtil.logNewLine(max_so_far, max_ending_here, min_ending_here, flag);
        if (flag == 0 && max_so_far == 1 && min_ending_here >= 0) {
            return 0;
        }
        if (flag == 0 && max_so_far == 1) {
            return max_so_far;
        }

        return max_so_far;
    }
}
