package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.september.week1;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/

Contains Duplicate III

Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.



Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
 */
public class ContainsDuplicateIII {
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 2, 5, 6, 7, 2, 4}, 4, 0));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;

        Point[] points = new Point[nums.length];

        for (int i = 0; i < nums.length; i++) {
            Point p = new Point(nums[i], i);
            points[i] = p;
        }

        Arrays.sort(points);

        int i = 0;
        int j = points.length - 1;

        while (i < j) {
            Point p1 = points[i];
            Point p2 = points[j];

            if (Math.abs(p1.value - p2.value) <= t && Math.abs(p1.index - p2.index) <= k) {
                return true;
            }

            if (Math.abs(p1.value - p2.value) > t) {
                j--;
            } else {
                i++;
            }

        }

        return false;
    }

    static private class Point implements Comparable<Point> {
        int value;
        int index;

        Point(int value, int index) {
            this.value = value;
            this.index = index;
        }


        @Override
        public int compareTo(Point o) {
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }
}
