package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.august.week1;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3414/

Find All Duplicates in an Array

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

 */
public class FindDuplicatesInArray {
    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDuplicates(new int[]{}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        int[] map = new int[nums.length + 1];

        for (int num : nums) {
            if (map[num] != 0) duplicates.add(num);
            map[num]++;
        }

        return duplicates;
    }
}
