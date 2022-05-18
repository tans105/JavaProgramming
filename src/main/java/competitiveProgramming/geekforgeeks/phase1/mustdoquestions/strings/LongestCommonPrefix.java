package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.strings;

/*
Longest Common Prefix in an Array

https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array/0

Given a array of N strings, find the longest common prefix among all strings present in the array.

Input:
The first line of the input contains an integer T which denotes the number of test cases to follow. Each test case contains an integer N. Next line has space separated N strings.

Output:
Print the longest common prefix as a string in the given array. If no such prefix exists print "-1"(without quotes).

Constraints:
1 <= T <= 103
1 <= N <= 103
1 <= |S| <= 103

Example:
Input:
2
4
geeksforgeeks geeks geek geezer
3
apple ape april

Output:
gee
ap

Explanation:
Testcase 1: Longest common prefix in all the given string is gee.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aca", "cba"}));
    }

    public static String longestCommonPrefix(String[] candidates) {
        if (candidates == null || candidates.length == 0) return "";

        StringBuilder longestPrefix = new StringBuilder();

        for (int j = 0; j < candidates[0].length(); j++) {
            char ref = candidates[0].charAt(j);
            int count = 1;
            for (int i = 1; i < candidates.length; i++) {
                if (j >= candidates[i].length()) break;

                if (candidates[i].charAt(j) != ref) break;
                else count++;
            }
            if (count == candidates.length) longestPrefix.append(ref);
            else break;

        }


        return longestPrefix.toString();
    }
}
