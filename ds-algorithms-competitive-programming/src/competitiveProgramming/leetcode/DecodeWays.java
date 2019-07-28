package competitiveProgramming.leetcode;

import java.util.Arrays;

/**
 * 91. Decode Ways
 * Medium
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

/**
 * HINT: https://www.youtube.com/watch?v=qli-JCrSwuk
 */
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        int count = decodeWays(s, new String(s), 0, s.length() - 1, memo);
        return count;
    }

    private static int decodeWays(String s, String str, int k, int size, int[] memo) {
        if (k == size) {
            return 1;
        }
        if (k > size || s == null) {
            return 0;
        }
        s = str.substring(k);
        if (memo[k] != -1) {
            return memo[k];
        }
        int result = 1 + decodeWays(s, str, k + 1, size, memo);
        if (k >= 2 && isValid(s.charAt(0) + String.valueOf(s.charAt(1)))) {
            result += decodeWays(s, str, k + 2, size, memo);
        }
        memo[k] = result;
        return result;
    }

    private static boolean isValid(String s) {
        int val = Integer.parseInt(s);
        return val > 0 && val <= 26;
    }


    /**
     * Leetsolution
     *
     * @param s
     * @return
     */
    public static int decodeWays(String s) {
        int[] dp = new int[s.length() + 1]; // +1 for empty string
        dp[0] = 1; // empty string has 1 solution
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int lastDigit = s.charAt(i - 1) - '0';
            int prevDigit = s.charAt(i - 2) - '0';
            int sum = prevDigit * 10 + lastDigit;

            if (sum == 0 || lastDigit == 0 && prevDigit >= 3) { // two consecutive zeros or something like 30, 40
                return 0;
            } else if (lastDigit == 0) { // dp["123"] = dp["12320"]
                dp[i] = dp[i - 2];
            } else if (prevDigit != 0 && sum <= 26) { // dp["123"] = dp["1"] + dp["12"]
                dp[i] = dp[i - 1] + dp[i - 2];
            } else { // dp["1234"] = dp["123"]
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];

    }


}
