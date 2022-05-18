package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week1;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/

Ransom Note
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b")); // false
        System.out.println(canConstruct("aa", "ab")); // false
        System.out.println(canConstruct("aa", "aab")); // true
        System.out.println(canConstruct(null, "aab")); // false
        System.out.println(canConstruct(null, null)); // false
        System.out.println(canConstruct("", "")); // true
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null && magazine == null) return true;
        if (ransomNote == null || magazine == null) return false;

        int[] ransomMap = new int[26];

        for (char c : ransomNote.toCharArray()) ransomMap[c - 'a']++;
        for (char c : magazine.toCharArray()) if (ransomMap[c - 'a'] > 0) ransomMap[c - 'a']--;
        for (int val : ransomMap) if (val > 0) return false;

        return true;
    }
}
