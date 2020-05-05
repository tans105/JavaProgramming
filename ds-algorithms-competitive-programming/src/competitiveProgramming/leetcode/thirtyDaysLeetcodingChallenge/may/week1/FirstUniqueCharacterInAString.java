package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week1;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/

First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar(""));
        System.out.println(firstUniqChar(null));
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        if (s == null) return -1;

        boolean[] found = new boolean[26];
        List<Character> dictionary = new ArrayList<>();

        for (char c : s.toCharArray()) {
            int charIndex = c - 'a';
            if (!found[charIndex]) {
                if (!dictionary.contains(c)) {
                    dictionary.add(c);
                } else {
                    dictionary.remove((Character) c);
                    found[charIndex] = true;
                }
            }
        }

        return (dictionary.size() > 0) ? s.indexOf(dictionary.get(0)) : -1;
    }

}
