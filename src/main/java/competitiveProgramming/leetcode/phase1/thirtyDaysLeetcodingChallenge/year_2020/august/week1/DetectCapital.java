package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.august.week1;

/*
Detect Capital
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.


Example 1:

Input: "USA"
Output: True


Example 2:

Input: "FlaG"
Output: False


Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse("abc"));
        System.out.println(detectCapitalUse("Abc"));
        System.out.println(detectCapitalUse(""));
        System.out.println(detectCapitalUse(null));
    }

    public static boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0) return true;

        boolean firstCapitalOnly = false;
        boolean allCapital = true;
        boolean allSmall = true;

        for (int i = 0; i < word.length(); i++) {
            int letter = word.charAt(i);

            if (letter >= 65 && letter <= 90) { //capital letter
                if (i == 0) firstCapitalOnly = true;
                else firstCapitalOnly = false;

                allSmall = false;
            } else { //small letter
                allCapital = false;
            }
        }

        return firstCapitalOnly || allCapital || allSmall;
    }
}
