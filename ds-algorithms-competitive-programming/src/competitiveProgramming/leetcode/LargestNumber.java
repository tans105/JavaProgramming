package competitiveProgramming.leetcode;

/*
179. Largest Number Medium

Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
 */

import java.util.*;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{0, 0}));
    }

    public static String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, new NumberComparator());
        StringBuilder builder = new StringBuilder();

        for (Integer i : list) {
            builder.append(i);
        }
        return (Double.parseDouble(builder.toString()) != 0) ? builder.toString() : "0";
    }
}

class NumberComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {


        if (((Double.parseDouble(o2.toString() + o1) > Double.parseDouble(o1.toString() + o2)))) {
            return 1;
        } else {
            return -1;
        }

    }
}
