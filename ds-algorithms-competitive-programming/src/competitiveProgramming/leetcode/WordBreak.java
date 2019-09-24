package competitiveProgramming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
139. Word Break

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
public class WordBreak {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("car","ca","rs");
        String s = "cars";
        System.out.println(wordBreak2(s, list));
    }

    public static boolean wordBreak2(String s, List<String> dict) {

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                String str = s.substring(j, i);
                if(f[j] && dict.contains(str)){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0 || s == null) return false;
        int counter = 0;
        int rejectCounter = 0;
        List<Integer> rejectedIndex = new ArrayList<>();
        while (s.length() != 0) {
            if (counter == wordDict.size()) counter = 0;
            String strippedS = stripString(s, wordDict.get(counter));
            counter++;
            if (strippedS.equals(s)) {
                if (!rejectedIndex.contains(counter)) {
                    rejectCounter++;
                    rejectedIndex.add(counter);
                }
                if (rejectCounter == wordDict.size()) return false;
            }
            s = strippedS;
        }

        return true;
    }

    private static String stripString(String source, String value) {
        if (!source.contains(value)) return source;

        int index = source.indexOf(value);
        int length = value.length();

        if (index + length > source.length() - 1) {
            return source.substring(0, index);
        } else {
            return source.substring(0, index) + source.substring(index + length);
        }
    }
}
