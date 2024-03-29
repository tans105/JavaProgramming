package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.september.week1;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3445/

Largest Time for Given Digits

Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.



Example 1:

Input: [1,2,3,4]
Output: "23:41"

Example 2:

Input: [5,5,5,5]
Output: ""

 */
public class LargestTimeForGivenNumbers {
    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    }

    public static String largestTimeFromDigits(int[] A) {
        List<String> permutations = permutations(A);
        String res = "";
        for (String p : permutations) {
            String HH = p.substring(0, 2);
            String MM = p.substring(2);
            if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(HH + ":" + MM) < 0)
                res = HH + ":" + MM;
        }

        return res;
    }

    private static List<String> permutations(int[] A) {
        StringBuilder s = new StringBuilder();
        for (int a : A)
            s.append(a);
        List<String> list = new ArrayList<>();
        permutations(s.toString(), "", list);
        return list;
    }

    private static void permutations(String s, String sofar, List<String> list) {
        if (s.isEmpty()) list.add(sofar);

        for (int i = 0; i < s.length(); i++) {
            permutations(s.substring(0, i) + s.substring(i + 1), sofar + s.charAt(i), list);
        }
    }
}
