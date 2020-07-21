package competitiveProgramming.archive.algorithms.dynamicprogramming;

import utils.ArrayUtils;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String X = "ABAB";
        String Y = "BABA";

        int m = X.length();
        int n = Y.length();
        int[][] T = new int[m + 1][n + 1];
        LCSString(X.toCharArray(), Y.toCharArray(), m, n, T);
    }


    private static void LCSString(char[] c1, char[] c2, int m, int n, int[][] T) {
        int row = 0, col = 0, maxLen = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    T[i][j] = 0;
                } else if (c1[i - 1] == c2[j - 1]) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                    if (T[i][j] > maxLen) {
                        maxLen = T[i][j];
                        row = i;
                        col = j;
                    }
                } else {
                    T[i][j] = 0;
                }
            }
        }

        ArrayUtils.print2DArray(T);

        StringBuilder resultStr = new StringBuilder();
        while (T[row][col] != 0) {
            resultStr.append(c1[row - 1]);
            row--;
            col--;
        }

        System.out.println(resultStr);
    }
}
