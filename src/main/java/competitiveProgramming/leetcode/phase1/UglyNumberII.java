package competitiveProgramming.leetcode.phase1;

/*
264. Ugly Number II

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
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        int min = 1;
        int[] ugly = new int[n];
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            min = Math.min(factor5, Math.min(factor2, factor3));
            ugly[i] = min;

            if (factor2 == min) //getting the next ugly number from 2
                factor2 = 2 * ugly[++index2];
            if (factor3 == min) //getting the next ugly number from 3
                factor3 = 3 * ugly[++index3];
            if (factor5 == min) //getting the next ugly number from 5
                factor5 = 5 * ugly[++index5];

        }

        return ugly[n - 1];
    }
}

