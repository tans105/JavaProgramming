package competitiveProgramming.random;


import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a dictionary of the words(strings) which contains different words & you are given an input string e.g. “abd”. You need to find the largest word available in the supplied dictionary which can be made using the letters of input string. The returned word can contain only the same no of occurrences of the letters as given in the input string i.e. if a letter is given once then in the output it should be existed only once. Examples:
Dictionary {“to”, “banana”, “toe”, “dogs”, “ababcd”, “elephant”} and input string is “eot”. Output should be “toe”
Dictionary is same as specified in example a but the input string is “ogtdes” and the output is “dogs” and “toes”
 */
public class LargestWordFromDictionary {

    public static void main(String[] args) {
        System.out.println(getLargestWord(new String[]{"to", "banana", "toe", "dogs", "ababcd", "elephant"}, "ogtdes"));
    }

    public static String getLargestWord(String[] dictionary, String word) {
        String longestWord = "";

        int[] wordCount = getWordCount(word);


        for (int i = 0; i < dictionary.length; i++) {
            char[] arr = dictionary[i].toCharArray();
            boolean isValid = true;
            for (int j = 0; j < arr.length; j++) {
                if (wordCount[arr[j] - 'a'] == 0) isValid = false;
            }
            if (isValid) {
                if (arr.length > longestWord.length()) {
                    longestWord = dictionary[i];
                }
            }
        }
        return longestWord;
    }

    private static int[] getWordCount(String word) {
        int[] wordCount = new int[26];
        char[] arr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            wordCount[arr[i] - 'a'] = 1;
        }
        return wordCount;
    }
}
