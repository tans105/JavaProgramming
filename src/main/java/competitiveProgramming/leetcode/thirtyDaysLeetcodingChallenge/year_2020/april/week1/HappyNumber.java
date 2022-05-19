package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.april.week1;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3284/

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(21));
    }

    public static boolean isHappy(int n) {
        List<Integer> track = new ArrayList<>();
        int num = n;
        boolean isHappy = false;

        while (!track.contains(num)) {
            track.add(num);
            int temp = num;
            num = 0;
            while (temp != 0) {
                num += Math.pow(temp % 10, 2);
                temp /= 10;
            }
            System.out.println(num);
            if (num == 1) {
                isHappy = true;
                break;
            }
        }
        return isHappy;
    }
}
