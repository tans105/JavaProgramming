package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.june.week2;
/*
https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3354/

Power of Two

Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Explanation: 20 = 1

Example 2:

Input: 16
Output: true
Explanation: 24 = 16

Example 3:

Input: 218
Output: false


 */
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-16));
    }

    public static boolean isPowerOfTwo(int n) {
        if(n < 0) return false;
        int count = 0;

        while (n != 0) {
            if (n % 2 != 0) count++;
            n = n >> 1;
        }

        return count == 1;
    }
}
