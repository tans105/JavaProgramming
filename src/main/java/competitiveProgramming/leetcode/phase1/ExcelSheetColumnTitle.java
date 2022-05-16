package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;

import java.util.HashMap;

/*
168. Excel Sheet Column Title

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int n) {
        if (n == 0) return "A";

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        StringBuilder builder = new StringBuilder();

        while (n > 0) {
            builder.append(alphabet[(n - 1) % 26]);
            n = (n - 1) / 26;
        }
        return builder.reverse().toString();
    }
}
