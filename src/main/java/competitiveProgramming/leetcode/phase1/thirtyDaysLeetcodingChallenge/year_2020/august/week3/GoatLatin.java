package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.august.week3;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3429/

Goat Latin

A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

    If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
    For example, the word 'apple' becomes 'applema'.

    If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
    For example, the word "goat" becomes "oatgma".

    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.

Return the final sentence representing the conversion from S to Goat Latin.



Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


 */
public class GoatLatin {
    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public static String toGoatLatin(String S) {
        if (S == null || S.length() == 0) return S;

        StringBuilder builder = new StringBuilder();
        String[] words = S.split(" ");

        for (int i = 1; i <= words.length; i++) {
            StringBuilder temp = new StringBuilder();
            String current = words[i - 1];
            if (isVowel(current.charAt(0))) { //vowel
                temp.append(current);
            } else { //consonant
                temp.append(current.substring(1));
                temp.append(current.charAt(0));
            }

            temp.append("ma");
            for (int j = 0; j < i; j++) {
                temp.append("a");
            }

            builder.append(temp.toString());
            builder.append(" ");
        }

        return builder.toString().trim();
    }


    public static boolean isVowel(char c) {
        return c == 'a' || c == 'A'
                || c == 'e' || c == 'E'
                || c == 'i' || c == 'I'
                || c == 'o' || c == 'O'
                || c == 'u' || c == 'U';
    }
}
