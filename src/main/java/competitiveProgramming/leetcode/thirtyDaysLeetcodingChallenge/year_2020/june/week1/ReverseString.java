package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.june.week1;

import utils.ArrayUtils;

/*
https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3350/

Reverse String

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.



Example 1:

Input: ['h','e','l','l','o']
Output: ['o','l','l','e','h']

Example 2:

Input: ['H','a','n','n','a','h']
Output: ['h','a','n','n','a','H']


 */
public class ReverseString {
    public static void main(String[] args) {
        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(arr);
        ArrayUtils.printArray(arr);

        arr = new char[]{'H','a','n','n','a','h'};
        reverseString(arr);
        ArrayUtils.printArray(arr);

        arr = null;
        reverseString(arr);
        ArrayUtils.printArray(arr);

        arr = new char[]{};
        reverseString(arr);
        ArrayUtils.printArray(arr);
    }

    public static void reverseString(char[] s) {
        if(s == null || s.length == 0 ) return;

        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
