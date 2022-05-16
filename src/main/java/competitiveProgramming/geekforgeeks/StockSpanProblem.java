package competitiveProgramming.geekforgeeks;

import utils.ArrayUtils;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/the-stock-span-problem/

The Stock Span Problem

The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */
public class StockSpanProblem {
    public static void main(String[] args) {
        ArrayUtils.printArray(spanStock(new int[]{100, 80, 60, 70, 60, 75, 85}));
    }

    private static int[] spanStock(int[] stocks) {
        Stack<Integer> stack = new Stack<>();
        int[] days = new int[stocks.length];
        days[0] = 1;
        stack.push(0);

        for (int i = 1; i < stocks.length; i++) {
            while (!stack.isEmpty() && stocks[i] >= stocks[stack.peek()]) {
                stack.pop();
            }

            days[i] = (stack.isEmpty()) ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return days;
    }
}
