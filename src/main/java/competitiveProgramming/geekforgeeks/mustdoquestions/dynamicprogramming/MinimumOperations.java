package competitiveProgramming.geekforgeeks.mustdoquestions.dynamicprogramming;

import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/find-optimum-operation/0

You are given a number N. You have to find the number of operations required to reach N from 0. You have 2 operations available:

Double the number
Add one to the number
Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N.

Output:
For each test case, in a new line, print the minimum number of operations required to reach N from 0.

Constraints:
1<=T<=100
1<=N<=104

Example:
Input:
2
8
7
Input:
4
5

Explanation:
Testcase1:
Input  : N = 8
Output : 4
0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8
Testcase2:
Input  : N = 7
Output : 5
0 + 1 = 1, 1 + 1 = 2, 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7
 */
public class MinimumOperations {
    public static void main(String[] args) {
        System.out.println(minimumOperations(8));
        System.out.println(minimumOperations(7));
    }

    private static int minimumOperations(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        Arrays.fill(dp, num + 1);
        int day = 1;

        for (int i = 0; i < num; i++) {
            if (i + 1 < dp.length) {
                dp[i + 1] = Math.min(Math.min(day, dp[i] + 1), dp[i + 1]);
            }
            if (2 * i < dp.length) {
                dp[2 * i] = Math.min(Math.min(day, dp[i] + 1), dp[2 * i]);
            }

            day++;
        }

        return dp[num];
    }
}
