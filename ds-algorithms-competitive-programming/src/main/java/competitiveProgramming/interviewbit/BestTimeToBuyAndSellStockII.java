package competitiveProgramming.interviewbit;

import java.util.Arrays;
import java.util.List;

/*
https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/

Best Time to Buy and Sell Stocks II
Asked in:
Amazon, Facebook
Say you have an array, A, for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit.

You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Input Format:

The first and the only argument is an array of integer, A.
Output Format:

Return an integer, representing the maximum possible profit.
Constraints:

1 <= len(A) <= 1e5
1 <= A[i] <= 1e7
Example :

Input 1:
    A = [1, 2, 3]

Output 1:
    2

Explanation 1:
    => Buy a stock on day 0.
    => Sell the stock on day 1. (Profit +1)
    => Buy a stock on day 1.
    => Sell the stock on day 2. (Profit +1)

    Overall profit = 2

Input 2:
    A = [5, 2, 10]

Output 2:
    8

Explanation 2:
    => Buy a stock on day 1.
    => Sell the stock on on day 2. (Profit +8)

    Overall profit = 8
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(Arrays.asList(5, 2, 10)));
        System.out.println(maxProfit(Arrays.asList(1, 2, 3)));
        System.out.println(maxProfit(Arrays.asList(23, 13, 25, 29, 33, 19, 34, 45, 65, 67)));
    }

    public static int maxProfit(final List<Integer> A) {
        if (A == null || A.size() <= 1) return 0;

        int minima = A.get(0);
        int prev = A.get(0);
        int profit = 0;
        int current;
        boolean carry = false;

        for (int i = 1; i < A.size(); i++) {
            current = A.get(i);

            if (current > prev) {
                prev = A.get(i);
                carry = true;
            } else {
                profit += prev - minima;
                minima = A.get(i);
                prev = A.get(i);
            }
        }

        if (carry) {
            profit += prev - minima;
        }

        return profit;
    }
}
