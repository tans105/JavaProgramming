package competitiveProgramming.geekforgeeks;

import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/

Anagram Substring Search (Or Search for all permutations)
Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] and its permutations (or anagrams) in txt[]. You may assume that n > m.
Expected time complexity is O(n)

Examples:

1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
   Output:   Found at Index 0
             Found at Index 5
             Found at Index 6
2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
   Output:   Found at Index 0
             Found at Index 1
             Found at Index 4
 */
public class AnagramSubstringSearch {
    public static void main(String[] args) {
        String str = "BACDGABCDA";
        String pat = "ABCD";

        System.out.println(getAnagramIndex(str.toCharArray(), pat.toCharArray()));
    }

    private static List<Integer> getAnagramIndex(char[] txt, char[] pat) {
        Map<Character, Integer> dict = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> indexes = new ArrayList<>();

        for (char c : pat) {
            int count = dict.getOrDefault(c, 0);
            dict.put(c, count + 1);
        }

        for (int i = 0; i < pat.length; i++) {
            int count = window.getOrDefault(txt[i], 0);
            window.put(txt[i], count + 1);
        }

        for (int i = 0; i < txt.length - pat.length + 1; i++) {
            boolean isValid = validateWindow(window, dict);

            if (isValid) {
                indexes.add(i);
            }

            if (i + pat.length < txt.length) {
                //remove previous
                if (window.get(txt[i]) > 1) {
                    window.put(txt[i], window.get(txt[i]) - 1);
                } else {
                    window.remove(txt[i]);
                }

                //adding next
                int count = window.getOrDefault(txt[i + pat.length], 0);
                window.put(txt[i + pat.length], count + 1);
            }
        }


        return indexes;
    }

    private static boolean validateWindow(Map<Character, Integer> window, Map<Character, Integer> dict) {
        int[] arr = new int[26];

        for (Map.Entry<Character, Integer> entry : window.entrySet()) {
            arr[entry.getKey() - 'A'] += entry.getValue();
        }

        for (Map.Entry<Character, Integer> entry : dict.entrySet()) {
            arr[entry.getKey() - 'A'] -= entry.getValue();
        }

        for (int value : arr) {
            if (value != 0) return false;
        }

        return true;
    }
}
