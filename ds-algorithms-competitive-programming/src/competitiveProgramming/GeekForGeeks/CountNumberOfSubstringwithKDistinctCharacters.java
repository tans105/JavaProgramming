package competitiveProgramming.GeekForGeeks;

import Utils.ArrayUtils;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/count-number-of-substrings-with-exactly-k-distinct-characters/
 * <p>
 * Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that has exactly k distinct characters.
 * Examples:
 * <p>
 * Input: abc, k = 2
 * Output: 2
 * Possible substrings are {"ab", "bc"}
 * <p>
 * Input: aba, k = 2
 * Output: 3
 * Possible substrings are {"ab", "ba", "aba"}
 * <p>
 * Input: aa, k = 1
 * Output: 3
 * Possible substrings are {"a", "a", "aa"}
 */
public class CountNumberOfSubstringwithKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(getSubstringCount("aa", 1));
    }


    private static int getSubstringCount(String str, int k) {
        int count = 0;
        Set<Character> temp = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                temp = new HashSet<>();
                char[] arr = str.substring(i, j).toCharArray();
                for (Character c : arr) {
                    temp.add(c);
                }
                if (temp.size() == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
