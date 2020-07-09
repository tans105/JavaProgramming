package competitiveProgramming.geekforgeeks.mustdoquestions.arrays;

/*
The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.

Input:
First line contains number of test cases T. First line of each test case contains an integer value N denoting the number of days, followed by an array of stock prices of N days.

Output:
For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".

Constraints:
1 <= T <= 100
2 <= N <= 103
0 <= Ai <= 104

Example
Input:
2
7
100 180 260 310 40 535 695
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
(1 4) (5 9)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.

 */
public class StockBuyAndSell {
    public static void main(String[] args) {
        buyAndSellStock(new int[]{23, 13, 25, 29, 33, 19, 34, 45, 65, 67});
    }

    private static void buyAndSellStock(int[] arr) {
        int currentIndex = 1;
        int prev = arr[0];
        int start = arr[0];
        int startIndex = 0;
        boolean increasing = false;
        int profit = 0;

        while (currentIndex != arr.length) {

            if (arr[currentIndex] > prev && !increasing) {
                increasing = true;
                start = prev;
                startIndex = currentIndex - 1;
            }

            if (arr[currentIndex] < prev) {
                if (increasing) {
                    profit += prev - start;
                    System.out.print("(" + startIndex + " " + (currentIndex - 1) + ")\t");
                }
                increasing = false;
            }

            prev = arr[currentIndex];
            currentIndex++;
        }

        if (increasing) {
            profit += arr[arr.length - 1] - start;
            System.out.println("(" + startIndex + " " + (arr.length - 1) + ")");
        }

        System.out.println(profit);
    }
}
