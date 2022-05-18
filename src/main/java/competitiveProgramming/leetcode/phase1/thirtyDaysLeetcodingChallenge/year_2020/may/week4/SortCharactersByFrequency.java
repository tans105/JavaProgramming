package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week4;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/

Sort Characters By Frequency
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
//        System.out.println(frequencySort("Aabb"));
//        System.out.println(frequencySort("cccaaa"));
//        System.out.println(frequencySort("tree"));
//        System.out.println(frequencySort("a"));
//        System.out.println(frequencySort(""));
//        System.out.println(frequencySort(null));
        System.out.println(frequencySort("loveleetcode"));
    }

    public static String frequencySort(String s) {
        if(s == null || s.length() == 0) return s;

        char[] arr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : arr) {
            list.add(c);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        Collections.sort(list);
        SortComparator<Character> comp = new SortComparator<>(map);
        list.sort(comp);

        System.out.println(list);
        StringBuilder builder = new StringBuilder();

        for(Character c: list) {
            builder.append(c);
        }
        return builder.toString();
    }


    static class SortComparator<Character> implements Comparator<Character> {
        Map<Character, Integer> freqMap;

        public SortComparator(Map<Character, Integer> freqMap) {
            this.freqMap = freqMap;
        }

        @Override
        public int compare(Character c1, Character c2) {
            return freqMap.get(c2).compareTo(freqMap.get(c1));
        }
    }
}
