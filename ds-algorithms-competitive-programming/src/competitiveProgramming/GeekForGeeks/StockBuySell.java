package competitiveProgramming.GeekForGeeks;


//https://www.geeksforgeeks.org/stock-buy-sell/

/**
 * The cost of a stock on each day is given in an array,
 * find the max profit that you can make by buying and selling in those days. For example,
 * if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3.
 * Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 */
public class StockBuySell {
    public static void main(String[] args) {
        int[] stock = new int[]{100, 180, 260, 310, 40, 535, 695};
        System.out.println(getProfit(stock, stock.length));
    }

    private static int getProfit(int[] stock, int length) {
        int currentIndex = 1;
        int profit = 0;
        int purchasedStock = stock[0];
        int prev = stock[0];
        while (currentIndex != length) {

            if (stock[currentIndex] < prev && currentIndex != 1) { //local maxima
                profit += prev - purchasedStock;
                purchasedStock = stock[currentIndex];
            }

            prev = stock[currentIndex];
            currentIndex++;
        }

        if (prev > purchasedStock) { //local maxima
            profit += prev - purchasedStock;
        }

        return profit;
    }
}
