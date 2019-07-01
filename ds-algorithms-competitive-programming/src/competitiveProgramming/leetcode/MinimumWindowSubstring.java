package competitiveProgramming.leetcode;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * This will not include duplicates
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String S = "a", T = "a";
        System.out.println(minWindow(S, T));
    }

    private static String minWindow(String s, String t) {
        int i = 0, j = 0;
        int minLength = Integer.MAX_VALUE;
        String smallestSubstring = null;
        while (i != s.length()) {
            if (j < s.length() && checkSubstring(s.substring(i, j), t)) {
                int currLen = j - i;
                if (currLen < minLength) {
                    smallestSubstring = s.substring(i, j);
                }
                i++;
            } else if (j == s.length()) {
                if (checkSubstring(s.substring(i), t)) {
                    smallestSubstring = s.substring(i);
                }
                i++;
            } else {
                j++;
            }
        }
        return smallestSubstring;
    }

    private static boolean checkSubstring(String s, String t) {
        char[] arr = t.toCharArray();
        for (char anArr : arr) {
            if (s.indexOf(anArr) < 0) {
                return false;
            }
        }
        return true;
    }
}
