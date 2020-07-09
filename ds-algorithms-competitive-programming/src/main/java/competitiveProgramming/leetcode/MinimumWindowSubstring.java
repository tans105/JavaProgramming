package competitiveProgramming.leetcode;

import java.util.HashMap;
import java.util.Map;

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
        String S = "this is a test string", T = "tist";
        System.out.println(minWindow2(S, T));
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

    public static String minWindow2(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] ans = {-1, 0, 0};
        Map<Character, Integer> dict = new HashMap<>();
        Map<Character, Integer> windowDict = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int count = dict.getOrDefault(t.charAt(i), 0);
            dict.put(t.charAt(i), count + 1);
        }

        int l = 0, r = 0;
        int desired = dict.size();
        int formed = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowDict.getOrDefault(c, 0);
            windowDict.put(c, count + 1);

            //increased the formed character only when the count matches
            if (dict.containsKey(c) && dict.get(c).equals(windowDict.get(c))) {
                formed++;
            }

            //contract the window
            while (l <= r && formed == desired) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowDict.put(c, windowDict.get(c) - 1);
                if (dict.containsKey(c) && windowDict.get(c) < dict.get(c)) formed--;
                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }

}
