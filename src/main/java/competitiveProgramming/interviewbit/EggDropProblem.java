package competitiveProgramming.interviewbit;

import utils.ArrayUtils;

/*
Egg Drop Problem!
Asked in:  Liv.ai
Problem Description

You are given A eggs, and you have access to a building with B floors from 1 to B.

Each egg is identical in function, and if an egg breaks, you cannot drop it again.

You know that there exists a floor C with 0 <= C <= B such that any egg dropped at a floor higher than C will break, and any egg dropped at or below floor C will not break.

Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= B).

Your goal is to know with certainty what the value of C is.

What is the minimum number of moves that you need to know with certainty what C is, regardless of the initial value of C



Problem Constraints
1 <= A <= 100
1 <= B <= 104


Input Format
First Argument is an integer A denoting number of eggs.

Second Argument is an integer B denoting number of floors.



Output Format
Return an integer denoting the Minimum number of moves.



Example Input
Input 1:

 A = 1
 B = 2
Input 2:

 A = 2
 B = 10


Example Output
Output 1:

 2
Output 2:

 4


Example Explanation
Explanation 1:

 Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
 Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
 If it didn't break, then we know with certainty F = 2.
 Hence, we needed 2 moves in the worst case to know what F is with certainty.
 */
public class EggDropProblem {
    public static void main(String[] args) {
        System.out.println(solve(2, 10));
        System.out.println(solve(1, 2));
    }

    public static int solve(int eggs, int floors) {
        int[][] dp = new int[eggs][floors + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < eggs; i++) { //eggs
            for (int j = 1; j < dp[0].length; j++) { //floors
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    //if it breaks(go down and reduce one egg) vs if it not breaks(go up)
                    int attempts = 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]);
                    if(attempts < dp[i][j]) {
                        dp[i][j] = attempts;
                    }
                }

            }
        }

        return dp[eggs - 1][floors];
    }
}
