package competitiveProgramming.leetcode.phase1;

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int lower = 0;
        int upper = s.length() - 1;

        while (lower < upper) {
            boolean isAlphaLower = Character.isDigit(s.charAt(lower)) || Character.isLetter(s.charAt(lower));
            boolean isAlphaUpper = Character.isDigit(s.charAt(upper)) || Character.isLetter(s.charAt(upper));

            if (!isAlphaLower) {
                lower++;
                continue;
            }

            if (!isAlphaUpper) {
                upper--;
                continue;
            }

            if (isAlphaLower && isAlphaUpper) {
                if (s.charAt(lower) == s.charAt(upper)) {
                    lower++;
                    upper--;
                } else {
                    return false;
                }
            }

        }

        return true;
    }
}
