package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week3;

import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        Map<Character, Integer> dictionary = new HashMap<>();

        for (Character c : p.toCharArray()) {
            int count = dictionary.getOrDefault(c, 0);
            dictionary.put(c, count + 1);
        }

        int k = p.length();
        Map<Character, Integer> targetDictionary = new HashMap<>();
        int desired = dictionary.size();
        int found = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < k) {
                int count = targetDictionary.getOrDefault(s.charAt(i), 0);
                targetDictionary.put(s.charAt(i), count + 1);
                if (dictionary.containsKey(s.charAt(i)) && dictionary.get(s.charAt(i)) == targetDictionary.get(s.charAt(i)))
                    found++;
            } else {
                Character toBeDeleted = s.charAt(i - k);
                Character toBeInserted = s.charAt(i);

                if (found == desired) {
                    indexes.add(i - k);
                }

                if (dictionary.containsKey(toBeDeleted) && targetDictionary.get(toBeDeleted) <= dictionary.get(toBeDeleted)) {
                    found--;
                }

                int count = targetDictionary.get(toBeDeleted);
                if (count == 1) {
                    targetDictionary.remove(toBeDeleted);
                } else {
                    targetDictionary.put(toBeDeleted, count - 1);
                }

                count = targetDictionary.getOrDefault(toBeInserted, 0);
                targetDictionary.put(toBeInserted, count + 1);

                if (dictionary.containsKey(toBeInserted) && dictionary.get(toBeInserted) == targetDictionary.get(toBeInserted))
                    found++;
            }
        }

        if(found == desired) indexes.add(s.length() - k);

        return indexes;
    }
}
