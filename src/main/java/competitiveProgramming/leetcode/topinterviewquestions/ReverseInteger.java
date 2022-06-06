package competitiveProgramming.leetcode.topinterviewquestions;

/*
https://leetcode.com/problems/reverse-integer/

7. Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

-231 <= x <= 231 - 1
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(100));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
    }

    public static int reverse(int x) {
        boolean isNegative = x < 0;
        long number = x;
        number = isNegative ? number * -1 : number;
        long reversed = 0;
        int numberOfDigit = numberOfDigit(x);

        while (number != 0) {
            long digit = number % 10;
            number = number / 10;
            reversed += (int) (digit * Math.pow(10, --numberOfDigit));
        }


        return reversed > Integer.MAX_VALUE ? 0 : (int) (isNegative ? -1 * reversed : reversed);
    }

    public static int numberOfDigit(int x) {
        int count = 0;
        while (x != 0) {
            x = x / 10;
            count++;
        }

        return count;
    }
}
