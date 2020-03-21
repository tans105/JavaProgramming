package competitiveProgramming.geekforgeeks;

import java.util.HashSet;
import java.util.Set;

/*
https://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-given-string/

Find all distinct palindromic sub-strings of a given string
Given a string of lowercase ASCII characters, find all distinct continuous palindromic sub-strings of it.
Examples:

Input: str = "abaaa"
Output:  Below are 5 palindrome sub-strings
a
aa
aaa
aba
b


Input: str = "geek"
Output:  Below are 4 palindrome sub-strings
e
ee
g
k
 */
public class UniquePalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(uniquePalindromicSubstring("abaaa")); //test case 1
        System.out.println(uniquePalindromicSubstring("geek")); //test case 2
        System.out.println(uniquePalindromicSubstring("aabaaa")); //test case 3
    }

    private static Set<String> uniquePalindromicSubstring(String str) {
        Set<String> result = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            expandAroundCenter(str, result, i, i);
            expandAroundCenter(str, result, i, i + 1);
        }

        return result;
    }

    private static void expandAroundCenter(String str, Set<String> result, int i, int j) {
        if (i == j) {
            result.add(String.valueOf(str.charAt(i)));
        }

        while (i >= 0 && j <= str.length() - 1) {
            if (str.charAt(i) == str.charAt(j)) {
                result.add(str.substring(i, j + 1));
            } else {
                break;
            }
            i--;
            j++;
        }
    }
}
