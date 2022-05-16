package competitiveProgramming.interview.GroupOn;

/*
Find the number of ways the sum can be divided Eg.
Given Total = 8 & K = 2
Possible outcome can be
1 1 1 1 1 1 1 1
1 1 1 1 1 1 2
1 1 1 1 2 2
1 1 2 2 2
2 2 2 2

There can be 5 outcomes
 */

public class PossibleOutcomes {

    public static void main(String[] args) {
        System.out.println(ways(8, 2));
    }

    public static int ways(int total, int k) {
        int[] candidates = new int[k];
        for (int i = 0; i < k; i++) {
            candidates[i] = i + 1;
        }

        return waysHelper(total, candidates);
    }


    public static int waysHelper(int amount, int[] candidates) {
        double[][] dp = new double[candidates.length + 1][amount + 1];

        for (int i = 0; i <= candidates.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= candidates.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int remaining = j - candidates[i - 1];
                dp[i][j] = dp[i - 1][j];
                if (remaining >= 0) dp[i][j] += dp[i][remaining] % 1000000007;
            }
        }

        return (int) (dp[candidates.length][amount] % 1000000007);
    }
}
