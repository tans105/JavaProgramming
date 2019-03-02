package dynamicprogramming;

class LongestCommonSubsequence2 {
    public static String LCS(String X, String Y, int m, int n, int[][] T) {
        if (m == 0 || n == 0) {
            return new String();
        }

        // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return LCS(X, Y, m - 1, n - 1, T) + X.charAt(m - 1);
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
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[i].length; j++) {
                System.out.print("T[" + i + "," + j + "] " + T[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print(LCS(X, Y, m, n, T));
    }
}