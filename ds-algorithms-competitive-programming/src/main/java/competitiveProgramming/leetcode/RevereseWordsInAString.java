package competitiveProgramming.leetcode;

import utils.StringUtils;

/*
151. Reverse Words in a String

Given an input string, reverse the string word by word.

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class RevereseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords(" "));
    }

    public static String reverseWords(String s) {
        if(StringUtils.isNullOrEmpty(s.trim())) return s;

        String[] arr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!StringUtils.isNullOrEmpty(arr[i])) {
                builder.append(arr[i].trim());
                builder.append(" ");
            }
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString().trim();
    }


}
