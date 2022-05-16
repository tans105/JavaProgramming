package competitiveProgramming.leetcode.phase1;

import java.util.*;

/*
692. Top K Frequent Words

https://leetcode.com/problems/top-k-frequent-words/

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.

Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 */
public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words;

        words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words, 2));

        words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(words, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> stringToCountMap = new HashMap<>();
        Map<Integer, List<String>> countToStringMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            int count = stringToCountMap.getOrDefault(word, 0);
            stringToCountMap.put(word, count + 1);
        }

        List<Integer> distinctCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : stringToCountMap.entrySet()) {
            List<String> wordList;
            if (!countToStringMap.containsKey(entry.getValue())) {
                wordList = new ArrayList<>();
                wordList.add(entry.getKey());
                countToStringMap.put(entry.getValue(), wordList);
                distinctCounts.add(entry.getValue());
            } else {
                wordList = countToStringMap.get(entry.getValue());
                wordList.add(entry.getKey());
                countToStringMap.put(entry.getValue(), wordList);
            }
        }

        distinctCounts.sort(Collections.reverseOrder());

        int index = 0;

        outerloop:
        while (true) {
            List<String> stringSet = countToStringMap.get(distinctCounts.get(index));
            Collections.sort(stringSet);
            for (String s : stringSet) {
                result.add(s);
                if (result.size() == k) break outerloop;
            }


            index++;
        }

        return result;
    }
}
