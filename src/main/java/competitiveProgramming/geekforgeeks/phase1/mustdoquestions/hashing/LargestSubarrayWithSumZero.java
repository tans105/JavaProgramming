package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.hashing;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/*
https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

Largest subarray with 0 sum

Given an array having both positive an negative integers. The task is to complete the function maxLen() which returns the length of maximum subarray with 0 sum. The function takes two arguments an array A and n where n is the size of the array A.

Input:
The first line of input contains an element T denoting the number of test cases. Then T test cases follow. Each test case consist of 2 lines. The first line of each test case contains a number denoting the size of the array A. Then in the next line are space separated values of the array A.

Output:
For each test case output will be the length of the largest subarray which has sum 0.

User Task:
Sinec this is a functional problem you don't have to worry about input, you just have to complete the function maxLen().

Constraints:
1 <= T <= 100
1 <= N <= 104
-1000 <= A[i] <= 1000, for each valid i

Example:
Input
1
8
15 -2 2 -8 1 7 10 23

Output
5
 */
public class LargestSubarrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.parseArray("[15, -2, 2, -8, 1, 7, 10, 23]");
        System.out.println(lengthOfLargestSubarray(arr));
    }

    private static int lengthOfLargestSubarray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int length = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                length = Math.max(i - map.get(sum), length);
            } else {
                map.put(sum, i);
            }
        }

        return length;
    }
}
