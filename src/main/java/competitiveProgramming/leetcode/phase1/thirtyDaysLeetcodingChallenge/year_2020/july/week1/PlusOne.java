package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.july.week1;

import utils.ArrayUtils;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3382/

Plus One

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

 */
public class PlusOne {
    public static void main(String[] args) {
        ArrayUtils.printArray(plusOne(new int[]{1, 2, 3}));
        ArrayUtils.printArray(plusOne(new int[]{4, 3, 2, 1}));
        ArrayUtils.printArray(plusOne(new int[]{0}));
        ArrayUtils.printArray(plusOne(new int[]{9}));
        ArrayUtils.printArray(plusOne(new int[]{9, 9}));
    }

    public static int[] plusOne(int[] digits) {
        boolean carry = false;
        int idx = digits.length - 1;

        while (idx >= 0) {
            if (digits[idx] == 9) {
                digits[idx] = 0;
                carry = true;
            } else {
                digits[idx] = digits[idx] + 1;
                carry = false;
                break;
            }
            idx--;
        }


        if (carry) {
            int[] aux = new int[digits.length + 1];
            aux[0] = 1;
            System.arraycopy(digits, 0, aux, 1, digits.length - 1);
            return aux;
        }

        return digits;
    }
}
