package dynamicprogramming;

import Utils.ArrayUtils;

/**
 * Construct a 2D DP array
     *                      X           M           J           Y           A           U           Z
     *       T[0,0] 0	T[0,1] 0	T[0,2] 0	T[0,3] 0	T[0,4] 0	T[0,5] 0	T[0,6] 0	T[0,7] 0
     *  M    T[1,0] 0	T[1,1] 0	T[1,2] 0	T[1,3] 0	T[1,4] 0	T[1,5] 0	T[1,6] 1	T[1,7] 1
     *  Z    T[2,0] 0	T[2,1] 1	T[2,2] 1	T[2,3] 1	T[2,4] 1	T[2,5] 1	T[2,6] 1	T[2,7] 1
     *  J    T[3,0] 0	T[3,1] 1	T[3,2] 1	T[3,3] 2	T[3,4] 2	T[3,5] 2	T[3,6] 2	T[3,7] 2
     *  A    T[4,0] 0	T[4,1] 1	T[4,2] 1	T[4,3] 2	T[4,4] 2	T[4,5] 2	T[4,6] 2	T[4,7] 2
     *  W    T[5,0] 0	T[5,1] 1	T[5,2] 1	T[5,3] 2	T[5,4] 3	T[5,5] 3	T[5,6] 3	T[5,7] 3
     *  X    T[6,0] 0	T[6,1] 1	T[6,2] 1	T[6,3] 2	T[6,4] 3	T[6,5] 3	T[6,6] 3	T[6,7] 4
     *  U    T[7,0] 0	T[7,1] 1	T[7,2] 2	T[7,3] 2	T[7,4] 3	T[7,5] 3	T[7,6] 3	T[7,7] 4
 *
 *  If X.charAt(i-1) == Y.charAt(j-1) => increment diagonal value i.e. arr[i][j] = arr[i-1][j-1] + 1
 *  else Max ( arr[i-1][j], arr[j-1][i]
 */
class LongestCommonSubsequence {
    public static String LCS(String X, String Y, int m, int n, int[][] T) {
        if (m == 0 || n == 0) {
            return new String();
        }

        // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return LCS(X, Y, m - 1, n - 1, T) + X.charAt(m - 1); //or Y.charAt(n - 1)
        }
        if (T[m - 1][n] > T[m][n - 1]) {
            return LCS(X, Y, m - 1, n, T);
        } else {
            return LCS(X, Y, m, n - 1, T);
        }
    }

    public static void LCSLength(String X, String Y, int m, int n, int[][] T) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    T[i][j] = T[i - 1][j - 1] + 1;
                } else {
                    T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String X = "XMJYAUZ", Y = "MZJAWXU";
        int m = X.length(), n = Y.length();
        int[][] T = new int[m + 1][n + 1];
        LCSLength(X, Y, m, n, T);
        ArrayUtils.print2DArray(T);
        System.out.print(LCS(X, Y, m, n, T));
    }
}