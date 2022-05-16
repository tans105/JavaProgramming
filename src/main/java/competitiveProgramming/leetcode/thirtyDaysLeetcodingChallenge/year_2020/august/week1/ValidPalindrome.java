package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.august.week1;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/

Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false



Constraints:

    s consists only of printable ASCII characters.


 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome("ab_a"));
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        s = s.toLowerCase();
        List<Integer> list = new ArrayList<>();
        s.chars().filter(c -> (c >= 65 && c <= 122) || (c >= 48 && c < 57)).forEach(list::add);
        System.out.println(list);
        return isPalindrome(list);
    }

    private static boolean isPalindrome(List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;

        while (i <= j) {
            if (!list.get(i).equals(list.get(j))) return false;
            i++;
            j--;
        }

        return true;
    }
}
