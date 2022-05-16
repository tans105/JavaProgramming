package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.september.week3;

/*
Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5

 */
public class LengthOfLargestWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello World a"));
        System.out.println(lengthOfLastWord(null));
        System.out.println(lengthOfLastWord(""));
        System.out.println(lengthOfLastWord(" "));
    }

    public static int lengthOfLastWord(String s) {
        if(s == null || s.trim().length() == 0) return 0;

        String[] tokens = s.split(" ");
        return tokens[tokens.length - 1].length();
    }
}
