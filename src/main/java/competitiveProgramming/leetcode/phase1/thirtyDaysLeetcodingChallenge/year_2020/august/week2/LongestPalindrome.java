package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.august.week2;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/

Longest Palindrome

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaabbb"));
        System.out.println(longestPalindrome("aaa"));
        System.out.println(longestPalindrome("abbba"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("aaabbb"));
        System.out.println(longestPalindrome("aabb"));
    }

    public static int longestPalindrome(String s) {
        if (s == null) return 0;

        int[] arr = new int[60];
        int evens = 0;
        int odds = 0;
        int oddMax = 0;
        boolean hasOdds = false;

        for (char c : s.toCharArray()) {
            arr[c - 'A']++;
        }

        for (int value : arr) {
            if (value % 2 == 0) {
                evens += value;
            } else {
                oddMax = Math.max(oddMax, value);
                odds += value - 1;
                hasOdds = true;
            }
        }

        return (hasOdds) ? evens + odds + 1 : evens;
    }
}
