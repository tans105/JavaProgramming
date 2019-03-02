package dynamicprogramming;

public class LeastCommonSubsequence {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        System.out.println(findLCS(X, Y, X.length(), Y.length()));
    }

    private static int findLCS(String x, String y, int lx, int ly) {
        if (lx == 0 || ly == 0) {
            return 0;
        }

        if (x.charAt(lx - 1) == y.charAt(ly - 1)) {
            return 1 + findLCS(x, y, lx - 1, ly - 1);
        } else {
            return Integer.max(findLCS(x, y, lx, ly - 1), findLCS(x, y, lx - 1, ly));
        }
    }
}
