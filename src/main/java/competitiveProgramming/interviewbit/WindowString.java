package competitiveProgramming.interviewbit;

import utils.ArrayUtils;
import utils.LoggingUtil;

import java.util.HashMap;

/*
https://www.interviewbit.com/problems/window-string/#

Window String

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimu
 */
public class WindowString {
    public static void main(String[] args) {
        System.out.println(new WindowString().minWindow("A", "A"));
    }

    public String minWindow(String A, String B) {
        char[] arrB = B.toCharArray();
        char[] arrA = A.toCharArray();
        HashMap<Character, Integer> dictMap = new HashMap<>();

        for (int i = 0; i < B.length(); i++) {
            int count = dictMap.getOrDefault(arrB[i], 0);
            dictMap.put(arrB[i], count + 1);
        }

        int desired = dictMap.size(), formed = 0, l = 0, r = 0;
        int[] result = new int[]{-1, -1, -1};
        int currentLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> windowMap = new HashMap<>();

        while (r < arrA.length) {
            int count = windowMap.getOrDefault(arrA[r], 0);
            windowMap.put(arrA[r], count + 1);

            if (dictMap.containsKey(arrA[r]) && windowMap.get(arrA[r]).equals(dictMap.get(arrA[r]))) {
                formed++;
            }

            while (formed == desired && l <= r) {
                if (r - l + 1 < currentLen) {
                    result[0] = r - l + 1;
                    result[1] = l;
                    result[2] = r;
                }
                if (dictMap.containsKey(arrA[l]) && windowMap.get(arrA[l]).equals(dictMap.get(arrA[l]))) {
                    formed--;
                }

                windowMap.put(arrA[l], windowMap.get(arrA[l]) - 1);
                l++;
            }

            r++;
        }

        return (result[0] != -1) ? A.substring(result[1], result[2] + 1) : "";
    }
}
