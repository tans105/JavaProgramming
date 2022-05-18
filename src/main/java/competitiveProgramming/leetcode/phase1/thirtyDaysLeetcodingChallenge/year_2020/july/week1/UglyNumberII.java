package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.july.week1;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3380/

Ugly Number II

Solution
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.
 */

public class UglyNumberII {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int twoFactor, threeFactor, fiveFactor, twoIndex = 0, threeIndex = 0, fiveIndex = 0;

        int[] ugly = new int[n];
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            twoFactor = 2 * ugly[twoIndex];
            threeFactor = 3 * ugly[threeIndex];
            fiveFactor = 5 * ugly[fiveIndex];

            int min = Math.min(twoFactor, Math.min(threeFactor, fiveFactor));

            if (min == twoFactor) twoIndex++;
            if (min == threeFactor) threeIndex++;
            if (min == fiveFactor) fiveIndex++;

            ugly[i] = min;
        }

        return ugly[n - 1];
    }

}
