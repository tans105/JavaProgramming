package competitiveProgramming.archive.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequenceLength {
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        Map<String, Integer> lookup = new HashMap<>();
        System.out.println(findLCS(X, Y, X.length(), Y.length(), lookup));
    }

    private static int findLCS(String x, String y, int lx, int ly, Map<String, Integer> lookup) {
        if (lx == 0 || ly == 0) {
            return 0;
        }
        String key = lx + ":" + ly;
        if (x.charAt(lx - 1) == y.charAt(ly - 1)) {
            lookup.put(key, 1 + findLCS(x, y, lx - 1, ly - 1, lookup));
        } else {
            lookup.put(key, Integer.max(findLCS(x, y, lx, ly - 1, lookup), findLCS(x, y, lx - 1, ly, lookup)));
        }

        return lookup.get(key);
    }
}
