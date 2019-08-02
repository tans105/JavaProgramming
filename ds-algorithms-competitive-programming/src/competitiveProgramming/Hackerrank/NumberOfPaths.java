package competitiveProgramming.hackerrank;

import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfPaths {
    public static void main(String[] args) {

        List a = Arrays.asList(1, 1, 1, 1);
        List b = Arrays.asList(0, 1, 1, 1);
        List c = Arrays.asList(1, 1, 1, 1);
        List tot = new ArrayList();
        tot.add(a);
        tot.add(b);
        tot.add(c);
        System.out.println(numberOfPaths(tot));
        numberOfPathsHelpder(tot, 0, 0);
        System.out.println(count);
    }

    static int count = 0;

    public static int numberOfPaths(List<List<Integer>> a) {
//        return numberOfPathsHelpder(a, 0, 0) - 1;
        int rows = a.size();
        int cols = a.get(0).size();
        int[][] dp = new int[rows][cols];

        dp[0][0] = a.get(0).get(0);

        for (int i = 1; i < rows; i++)
            if (dp[i - 1][0] == 1 && a.get(i).get(0) == 1)
                dp[i][0] = 1;

        for (int i = 1; i < cols; i++)
            if (dp[0][i - 1] == 1 && a.get(0).get(i) == 1)
                dp[0][i] = 1;

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++)
                if (a.get(i).get(j) == 1)
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]);

        return dp[rows - 1][cols - 1];

    }


    private static void numberOfPathsHelpder(List<List<Integer>> a, int x, int y) {
        if (x < 0 || y < 0 || x >= a.size() || y >= a.get(0).size()) {
            return;
        }
        if (a.get(x).get(y) == 0) return;

        if (x == (a.size() - 1) && y == a.get(x).size() - 1) count++;

        numberOfPathsHelpder(a, x + 1, y);
        numberOfPathsHelpder(a, x, y + 1);


    }
}
