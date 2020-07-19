package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.july.week3;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/

Add Binary
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        if (a == null && b == null) return null;
        if (a == null) return b;
        if (b == null) return a;

        if (a.length() < b.length()) return addBinary(b, a);

        StringBuilder ans = new StringBuilder();
        int carry = 0, sum, fromA, fromB, aIndex = a.length() - 1, bIndex = b.length() - 1;

        while (aIndex >= 0) {
            fromA = Integer.parseInt(String.valueOf(a.charAt(aIndex)));

            if (bIndex < 0) fromB = 0;
            else fromB = Integer.parseInt(String.valueOf(b.charAt(bIndex)));

            sum = fromA ^ fromB ^ carry;
            carry = (fromA + fromB + carry > 1) ? 1 : 0;

            ans.append(sum);

            aIndex--;
            bIndex--;
        }

        return (carry == 1) ? ans.append(1).reverse().toString() : ans.reverse().toString();
    }
}