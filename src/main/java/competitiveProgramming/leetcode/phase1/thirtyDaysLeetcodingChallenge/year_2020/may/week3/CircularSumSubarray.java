package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week3;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/

Maximum Sum Circular Subarray

Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)



Example 1:

Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3

Example 2:

Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10

Example 3:

Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4

Example 4:

Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3

Example 5:

Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1



Note:

    -30000 <= A[i] <= 30000
    1 <= A.length <= 30000


 */

public class CircularSumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2})); // 3
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5})); // 10
        System.out.println(maxSubarraySumCircular(new int[]{3, -1, 2, -1})); // 4
        System.out.println(maxSubarraySumCircular(new int[]{3, -2, 2, -3})); // 3
        System.out.println(maxSubarraySumCircular(new int[]{-2, -3, -1})); // -1

    }

    public static int maxSubarraySumCircular(int[] A) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int total = 0;
        int minSoFar = 0;
        int minEndingHere = 0;
        boolean isNegative = true;
        int largest = Integer.MIN_VALUE;

        for (int value : A) {
            total += value;
            maxEndingHere = maxEndingHere + value;
            minEndingHere = minEndingHere + value;

            maxEndingHere = Math.max(maxEndingHere, 0);
            minEndingHere = Math.min(minEndingHere, value);

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            minSoFar = Math.min(minSoFar, minEndingHere);

            largest = Math.max(value, largest);
            if(value > 0) {
                isNegative = false;
            }
        }

        return !isNegative ? Math.max(maxSoFar, total - minSoFar) : largest;
    }
}
