package competitiveProgramming.leetcode;

/*
172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.
 */

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(1001));
    }

    public static int trailingZeroes(int n) {
        int zeroes = 0;
        int power = 1;
        boolean inProgress = true;
        while (inProgress) {
            int temp = (int) (n / (Math.pow(5, power)));
            if (temp == 0) inProgress = false;
            zeroes += temp;
            power++;
        }
        return zeroes;
    }
}
