package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.july.week1;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3377/

Arranging Coins

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.

Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.

 */
public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(0));
        System.out.println(arrangeCoins(1));

    }

    public static int arrangeCoins(int n) {
        long low = 0;
        long high = Integer.MAX_VALUE;
        long curr;

        while (low <= high) {
            long mid = (low + high) / 2;
            curr = mid * (mid + 1) / 2;

            if (curr == n) {
                return (int) mid;
            }

            if (curr > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) high;
    }
}
