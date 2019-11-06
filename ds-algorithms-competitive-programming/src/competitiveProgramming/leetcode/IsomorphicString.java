package competitiveProgramming.leetcode;
/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        for (int i = 0; i < sCharArray.length; i++) {
            char sChar = sCharArray[i];
            char tChar = tCharArray[i];

            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tCharArray[i]) {
                    return false;
                }
            } else {
                sMap.put(sChar, tCharArray[i]);
            }

            if (tMap.containsKey(tChar)) {
                if (tMap.get(tChar) != sCharArray[i]) {
                    return false;
                }
            } else {
                tMap.put(tChar, sCharArray[i]);
            }
        }

        return true;
    }
}
