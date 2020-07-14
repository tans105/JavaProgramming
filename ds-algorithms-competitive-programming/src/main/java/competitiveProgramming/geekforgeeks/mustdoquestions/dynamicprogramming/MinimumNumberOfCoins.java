package competitiveProgramming.geekforgeeks.mustdoquestions.dynamicprogramming; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins/0

Minimum number of Coins

Given a value N, total sum you have. You have to make change for Rs. N, and there is infinite supply of each of the denominations in Indian currency, i.e., you have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000} valued coins/notes, Find the minimum number of coins and/or notes needed to make the change for Rs N.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case consist of an Integer value N denoting the amount to get change for.

Output:
Print all the denominations needed to make the change in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106

Example:
Input:
1
43

Output:
20 20 2 1

Explanation:
Testcase 1: Sum of Rs 43 can be changed with minimum of 4 coins/ notes 20, 20, 2, 1.
 */
public class MinimumNumberOfCoins {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 7;
        System.out.println(findNumberOfCoins2(coins, amount));

        coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        amount = 43;
        System.out.println(findNumberOfCoins2(coins, amount));

        coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        amount = 43;
        System.out.println(findNumberOfCoins3(coins, amount));

        coins = new int[]{1, 2, 5, 10};
        amount = 11;
        System.out.println(findNumberOfCoins3(coins, amount));

    }


    //Solution 1 --> Using Dynamic Programming ( will only give the number of coins )
    private static int findNumberOfCoins2(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < dp[0].length; i++) {
            if (i >= coins[0] && i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (coins[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int remaining = j - coins[i];
                    dp[i][j] = 1 + dp[i][remaining];
                }
            }
        }

        return dp[coins.length - 1][amount];
    }
    //

    //Solution 2 ---> Using Backtracking ( Can give number of coins and denomination )
    static int min = Integer.MAX_VALUE;
    static List<Integer> minList = new ArrayList<>();

    private static List<Integer> findNumberOfCoins(int[] coins, int amount) {
        List<Integer> temp = new ArrayList<>();
        findNumberOfCoins(coins, amount, temp, 0);
        return minList;
    }

    private static void findNumberOfCoins(int[] coins, int amount, List<Integer> temp, int value) {
        if (value == amount) {
            min = Math.min(min, temp.size());
            minList = new ArrayList<>(temp);
            return;
        }

        if (value > amount) {
            return;
        }

        for (int coin : coins) {
            if (coin > amount) break;
            temp.add(coin);
            findNumberOfCoins(coins, amount, temp, value + coin);
            temp.remove(temp.size() - 1);
        }
    }
    //

    //Solution 3 --> Using Binary Search
    public static List<Integer> findNumberOfCoins3(int[] coins, int amount) {
        List<Integer> denomination = new ArrayList<>();
        int low = 0;
        int high = coins.length - 1;

        while (amount > 0) { //Keep updating the amount and eliminate all the denomination greater than the current amount
            int mid = searchNearest(coins, low, high, amount);
            if(mid == -1) return new ArrayList<>();
            denomination.add(coins[mid]);
            amount = amount - coins[mid];
            high = mid;
        }

        return denomination;
    }

    private static int searchNearest(int[] coins, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (coins[mid] == target) return mid;

            if (target < coins[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low - 1;
    }
    //

}
