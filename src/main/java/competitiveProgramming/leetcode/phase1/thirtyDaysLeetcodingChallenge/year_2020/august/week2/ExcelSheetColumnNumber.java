package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.august.week2;

import java.util.HashMap;

/*
171. Excel Sheet Column Number

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        HashMap<String, Integer> map = new HashMap<>();
        int power = 1;
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            map.put(String.valueOf(ch), power);
            power++;
        }

        power = 0;
        int sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            sum += map.get(String.valueOf(chars[i])) * Math.pow(26, power);
            power++;
        }
        return sum;
    }
}
