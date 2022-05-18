package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.april.week1;
/*
Counting Elements

Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.
 */

import java.util.HashMap;
import java.util.Map;

public class CountingNumbers {
    public static void main(String[] args) {
        int[] arr;

        arr = new int[]{1, 1, 3, 3, 5, 5, 7, 7};
        System.out.println(countElements(arr));

        arr = new int[]{1, 3, 2, 3, 5, 0};
        System.out.println(countElements(arr));

        arr = new int[]{1, 1, 2, 2};
        System.out.println(countElements(arr));

        arr = new int[]{1, 1, 2};
        System.out.println(countElements(arr));
    }

    public static int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        int count = 0;

        for (int num : arr) {
            if (map.containsKey(num + 1)) {
                count++;
            }
        }

        return count;
    }
}
