package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.june.week1;

import java.util.ArrayList;
import java.util.List;

/*
Coin Change 2
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1


Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer

*/
public class CoinChange2 {
    public static void main(String[] args) {
        CoinChange2 coin = new CoinChange2();
        System.out.println(coin.change(5, new int[]{1, 2, 5}));
        System.out.println(coin.change(3, new int[]{2}));
        System.out.println(coin.change(10, new int[]{10}));
    }


    public int change(int amount, int[] coins) {
        int[][] knapsack = new int[coins.length + 1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            knapsack[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int remaining = j - coins[i - 1];
                knapsack[i][j] = knapsack[i - 1][j];
                if (remaining >= 0) knapsack[i][j] += knapsack[i][remaining];
            }
        }

        return knapsack[coins.length][amount];
    }


    //-----------------------------------------------------------------------------------------------------------
    //Below approach uses backtracking to get possible options.
    int total = 0;

    public int changeBacktracking(int amount, int[] coins) {
        total = 0;
        List<Integer> temp = new ArrayList<>();
        changeHelper(temp, coins, 0, amount, 0);
        return total;
    }

    private void changeHelper(List<Integer> temp, int[] coins, int startIndex, int amount, int currentSum) {
        if (currentSum == amount) {
            total++;
        }

        if (currentSum > amount) {
            return;
        }

        for (int i = startIndex; i < coins.length; i++) {
            temp.add(coins[i]);
            changeHelper(temp, coins, i, amount, currentSum + coins[i]);
            temp.remove(temp.size() - 1);
        }
    }
    //-----------------------------------------------------------------------------------------------------------
}
