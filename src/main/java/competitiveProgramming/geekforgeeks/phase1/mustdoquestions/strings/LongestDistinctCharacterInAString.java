package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.strings;

import java.util.HashSet;
import java.util.Set;

/*
Given a string S, find length of the longest substring with all distinct characters.  For example, for input "abca", the output is 3 as "abc" is the longest substring with all distinct characters.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is String str.

Output:
Print length of smallest substring with maximum number of distinct characters.
Note: The output substring should have all distinct characters.

Constraints:
1 ≤ T ≤ 100
1 ≤ size of str ≤ 10000

Example:
Input:
2
abababcdefababcdab
geeksforgeeks

Output:
6
7
 */
public class LongestDistinctCharacterInAString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("geeksforgeeks"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        char[] arr = s.toCharArray();
        Set<Character> dict = new HashSet<>();

        while (i < arr.length) {
            while (j < arr.length && !dict.contains(arr[j])) {
                dict.add(arr[j]);
                j++;
            }

            max = Math.max(dict.size(), max);

            while (i < j && j < arr.length) {
                if (arr[i] != arr[j]) {
                    dict.remove(arr[i]);
                    i++;
                } else {
                    dict.remove(arr[i]);
                    i++;
                    break;
                }
            }

            if (j == arr.length) break;
        }

        return max;
    }
}
