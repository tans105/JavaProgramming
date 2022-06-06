package competitiveProgramming.leetcode.topinterviewquestions;

/*
https://leetcode.com/problems/longest-common-prefix/

14. Longest Common Prefix

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"flow", "flower", "flowere"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {return "";}

        StringBuilder builder = new StringBuilder("");
        int length = strs.length;
        String sample = strs[0];
        int i = 0;

        try {
            while (i < sample.length()) {
                int count = 0;
                for (String word : strs) {
                    if (word.charAt(i) == sample.charAt(i)) {
                        count++;
                    }
                    else {
                        break;
                    }
                }
                if (count == length) {
                    builder.append(sample.charAt(i));
                }
                else {
                    break;
                }
                i++;
            }
        }
        catch (Exception e) {
            System.out.println("Exception!");
            //Nothing
        }


        return builder.toString();
    }
}
