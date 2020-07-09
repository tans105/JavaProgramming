package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.april.week1;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3288/

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(str));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> mappings = new HashMap<>();
        List<String> list = null;


        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = String.valueOf(arr);

            if (mappings.containsKey(sortedStr)) {
                list = mappings.get(sortedStr);
                list.add(str);
                mappings.put(sortedStr, list);
            } else {
                list = new ArrayList<>();
                list.add(str);
                mappings.put(sortedStr, list);
            }
        }

        for(Map.Entry<String, List<String>> entry: mappings.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
