package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week3;

/*
Permutation in String

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.



Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False



Note:

    The input strings only contain lower case letters.
    The length of both given strings is in range [1, 10,000].


 */
public class PermutationInAString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); //true
        System.out.println(checkInclusion("ab", "eidbsaooo")); //false
        System.out.println(checkInclusion("ab", "eidboaoo")); //false
        System.out.println(checkInclusion("ab", "ba")); //true
        System.out.println(checkInclusion("ab", "bca")); //false
        System.out.println(checkInclusion("", "bca")); //true
        System.out.println(checkInclusion("bca", "")); //false
        System.out.println(checkInclusion("", "")); //true
        System.out.println(checkInclusion("abc", "bbbca")); //true
        System.out.println(checkInclusion("abcdxabcde", "abcdeabcdx")); //true
        System.out.println(checkInclusion("rvwrk", "gwrvrkxe")); //true
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] sourceArrCount = new int[26];
        int[] reference = new int[26];
        char[] dest = s2.toCharArray();
        int desired = 0;

        for (char c : s1.toCharArray()) {
            if (reference[c - 'a'] == 0) desired++;
            reference[c - 'a']++;
        }

        int formed = 0;
        int k = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            char toBeInserted = dest[i];
            int toBeInsertedIndex = toBeInserted - 'a';
            char toBeRemoved;
            int toBeDeletedIndex;
            if (i < k) {
                sourceArrCount[toBeInsertedIndex]++;
                if (sourceArrCount[toBeInsertedIndex] == reference[toBeInsertedIndex]) formed++;
            } else {
                if (formed == desired) return true;
                toBeRemoved = dest[i - k];
                toBeDeletedIndex = toBeRemoved - 'a';

                if (sourceArrCount[toBeDeletedIndex] > 0) sourceArrCount[toBeDeletedIndex]--;
                if (sourceArrCount[toBeDeletedIndex] < reference[toBeDeletedIndex]) formed--;
                sourceArrCount[toBeInsertedIndex]++;
                if (sourceArrCount[toBeInsertedIndex] == reference[toBeInsertedIndex]) formed++;
            }
        }

        return formed == desired;
    }
}
