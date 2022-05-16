package competitiveProgramming.leetcode.phase1;

/*
242. Valid Anagram

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 */

import utils.ArrayUtils;
import utils.LoggingUtil;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram2("a", "ab"));
    }

    /**
     * Cleaner Approach
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }

        return true;
    }


    /**
     * Old Solution
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        Map<Character, Integer> alphabetCountS = new HashMap<>();
        Map<Character, Integer> alphabetCountT = new HashMap<>();

        populate(s, alphabetCountS);
        populate(t, alphabetCountT);

        if (alphabetCountS.size() != alphabetCountT.size()) return false;

        for (Map.Entry<Character, Integer> entry : alphabetCountS.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (!alphabetCountT.containsKey(key) || alphabetCountT.get(key) != value) {
                return false;
            }
        }


        return true;
    }

    private static void populate(String s, Map<Character, Integer> anagramCount) {
        for (Character c : s.toCharArray()) {
            int count = anagramCount.getOrDefault(c, 0);
            anagramCount.put(c, count + 1);
        }
    }
}
