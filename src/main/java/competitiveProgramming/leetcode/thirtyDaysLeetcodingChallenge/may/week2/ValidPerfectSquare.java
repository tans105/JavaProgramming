package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week2;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/

Valid Perfect Square

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(10));
        System.out.println(isPerfectSquare(64));
        System.out.println(isPerfectSquare(123));
        System.out.println(isPerfectSquare(121));
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(0));
    }

    public static boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;

        while (low <= high) {
            int mid = (low + high) / 2;
            int sq = mid * mid;
            if (sq == num) return true;

            if (sq > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    /**
     * This is a math problem：
     * 1 = 1
     * 4 = 1 + 3
     * 9 = 1 + 3 + 5
     * 16 = 1 + 3 + 5 + 7
     * 25 = 1 + 3 + 5 + 7 + 9
     * 36 = 1 + 3 + 5 + 7 + 9 + 11
     * ....
     * so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn
     */


    public boolean isPerfectSquareSolution(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}

