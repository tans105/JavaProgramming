package competitiveProgramming.leetcode.topinterviewquestions;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatedCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int result = 0;

        char[] chars = s.toCharArray();
        Set<Character> hash = new HashSet<>();

        while (i < chars.length && j < chars.length) {
            if (!hash.contains(chars[j])) { // its already there, skim through the index
                hash.add(chars[j++]);
                ;
                result = Math.max(result, j - i);
            } else {
                hash.remove(chars[i++]);
            }
        }

        return result;
    }
}
