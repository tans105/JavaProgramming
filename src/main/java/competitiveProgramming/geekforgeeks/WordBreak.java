package competitiveProgramming.geekforgeeks;

import java.util.Arrays;
import java.util.List;

/*
https://www.geeksforgeeks.org/word-break-problem-dp-32/

Word Break Problem | DP-32
Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.
This is a famous Google interview question, also being asked by many other companies now a days.

Consider the following dictionary
{ i, like, sam, sung, samsung, mobile, ice,
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung"
or "i like sam sung".
 */
public class WordBreak {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("cats", "dog", "sand", "and", "cat");
        String s = "catsanddog";
        System.out.println(wordBreak(s, list));
        System.out.println(wordBreak2(s, list));
    }

    public static boolean wordBreak(String s, List<String> dict) {
        return wordBreak(s, dict, "");
    }

    private static boolean wordBreak(String s, List<String> dict, String out) {
        if (s.length() == 0) {
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);

            if (dict.contains(prefix)) {
                return wordBreak(s.substring(i), dict, out + prefix);
            }
        }

        return false;
    }

    public static boolean wordBreak2(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;


        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String prefix = s.substring(j, i);
                // if everything satisfies till [0-j] & [j-i] is present in the dictional => i can be created with dictionary
                if (dp[j] && dict.contains(prefix)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
