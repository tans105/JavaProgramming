package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.april.week4;

/*
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3308/

Bitwise AND of Numbers Range
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
 */
public class BitwiseAndOfNumber {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (n != m) {
            n = n >> 1;
            m = m >> 1;
            count++;
        }

        return n << count;
    }
}
