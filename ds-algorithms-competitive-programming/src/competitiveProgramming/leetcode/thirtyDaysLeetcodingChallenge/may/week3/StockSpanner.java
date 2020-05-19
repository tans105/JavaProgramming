package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week3;

import utils.LoggingUtil;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/

Online Stock Span

Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].



Example 1:

Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
Output: [null,1,1,1,2,1,4,6]
Explanation:
First, S = StockSpanner() is initialized.  Then:
S.next(100) is called and returns 1,
S.next(80) is called and returns 1,
S.next(60) is called and returns 1,
S.next(70) is called and returns 2,
S.next(60) is called and returns 1,
S.next(75) is called and returns 4,
S.next(85) is called and returns 6.

Note that (for example) S.next(75) returned 4, because the last 4 prices
(including today's price of 75) were less than or equal to today's price.



Note:

    Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
    There will be at most 10000 calls to StockSpanner.next per test case.
    There will be at most 150000 calls to StockSpanner.next across all test cases.
    The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.


 */
public class StockSpanner {
    private Node head;

    public StockSpanner() {
        head = null;
    }

    public int next(int price) {
        insertToHead(price);
        int days = 1;
        Node n = head;
        while (n != null && n.next != null && n.next.value <= price) {
            days++;
            n = n.next;
        }

        return days;
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.value + "\t");
            n = n.next;
        }
        System.out.println();
    }

    private void insertToHead(int val) {
        Node n = new Node(val);

        if (head == null) { //empty list
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    /**
     * Runner Method
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] operations;
        Integer[] values;

        operations = new String[]{"StockSpanner", "next", "next", "next", "next", "next", "next", "next"};
        values = new Integer[]{null, 100, 80, 60, 70, 60, 75, 85};
        apply(operations, values);

        operations = new String[]{"StockSpanner", "next", "next", "next", "next", "next"};
        values = new Integer[]{null, 29, 91, 62, 76, 51};
        apply(operations, values);

        operations = new String[]{"StockSpanner", "next", "next", "next", "next", "next",    "next", "next", "next", "next", "next"};
        values = new Integer[]{null, 28, 14, 28, 35, 46, 53, 66, 80, 87, 88};
        apply(operations, values);
    }

    /**
     * Utility method to run bulk operations
     *
     * @param operations - List of stack operations to be performed
     * @param values     - Params needed for operations (if applicable)
     */
    private static void apply(String[] operations, Integer[] values) {
        StockSpanner stockSpanner = new StockSpanner();
        Object[] response = new Object[operations.length];
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "StockSpanner": {
                    response[i] = null;
                    continue;
                }
                case "next": {
                    response[i] = stockSpanner.next(values[i]);
                    break;
                }
            }
        }
        LoggingUtil.logNewLine(response);
    }
}
