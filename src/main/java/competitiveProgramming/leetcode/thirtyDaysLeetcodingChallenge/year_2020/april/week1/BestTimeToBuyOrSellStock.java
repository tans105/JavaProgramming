package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.april.week1;


import utils.ArrayUtils;

/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3287/

Best Time to Buy and Sell Stock II

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyOrSellStock {
    public static void main(String[] args) {
        int[] arr;

        arr = ArrayUtils.parseArray("[7,1,5,3,6,4]");
        System.out.println(maxProfit(arr));

        arr = ArrayUtils.parseArray("[1,2,3,4,5]");
        System.out.println(maxProfit(arr));

        arr = ArrayUtils.parseArray("[7,6,4,3,1]");
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int low = 0;
        int high = 0;

        boolean isIncreasing = false;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1] && !isIncreasing) {
                isIncreasing = true;
                low = i - 1;
                high = i;
            }

            if (prices[i] > prices[i - 1] && isIncreasing) {
                high = i;
            }

            if (prices[i] < prices[i - 1]) {
                profit += prices[high] - prices[low];
                low = i; //reset
                high = i;
                isIncreasing = false;
            }
        }

        if (isIncreasing) {
            profit += prices[high] - prices[low];
        }

        return profit;
    }
}
