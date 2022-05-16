package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.august.week1;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3412/

Power of Four

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true

Example 2:

Input: 5
Output: false

Follow up: Could you solve it without loops/recursion?
 */
public class PowerOf4 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(17));
        System.out.println(isPowerOfFour(64));
        System.out.println(isPowerOfFour(256));
        System.out.println(isPowerOfFour(512));
    }

    public static boolean isPowerOfFour(int num) {
        if(num == 1) return true;
        if (num % 10 == 4 || num % 10 == 6) { //this eliminates power of 2 which are are not power of 4
            return (num & (2 * num - 1)) == num;
        } else {
            return false;
        }
    }
}
