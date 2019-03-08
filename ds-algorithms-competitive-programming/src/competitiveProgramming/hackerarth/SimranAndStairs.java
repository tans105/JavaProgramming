package competitiveProgramming.hackerarth;

//https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/simran-and-stairs/

public class SimranAndStairs {

    // A recursive function used by countWays
    private static int countWaysUtil(int n, int m) {
        if (n <= 1)
            return n;
        int res = 0;
        for (int i = 1; i <= m && i <= n; i++)
            res += countWaysUtil(n - i, m);
        return res;
    }

    // Returns number of ways to reach s'th stair
    private static int countWays(int s, int m) {
        return countWaysUtil(s + 1, m);
    }


    /* Driver program to test above function */
    public static void main(String args[]) {
        int s = 4, m = 2;
        System.out.println("Number of ways = " + countWays(s, m));
    }
}
