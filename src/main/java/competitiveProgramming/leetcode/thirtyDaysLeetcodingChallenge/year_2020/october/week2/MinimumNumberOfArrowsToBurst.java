package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.october.week2;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3490/

Minimum Number of Arrows to Burst Balloons

There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. The start is always smaller than the end.

An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely.

Given an array points where points[i] = [xstart, xend], return the minimum number of arrows that must be shot to burst all balloons.



Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).

Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4

Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2

Example 4:

Input: points = [[1,2]]
Output: 1

Example 5:

Input: points = [[2,3],[2,3]]
Output: 1



Constraints:

    0 <= points.length <= 104
    points.length == 2
    -231 <= xstart < xend <= 231 - 1

 */
public class MinimumNumberOfArrowsToBurst {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(ArrayUtils.parse2DArray("[[10,16],[2,8],[1,6],[7,12]]")));
        System.out.println(findMinArrowShots(ArrayUtils.parse2DArray("[[1,2],[3,4],[5,6],[7,8]]")));
        System.out.println(findMinArrowShots(ArrayUtils.parse2DArray("[[1,2],[2,3],[3,4],[4,5]]")));
        System.out.println(findMinArrowShots(ArrayUtils.parse2DArray("[[1,2]")));
        System.out.println(findMinArrowShots(ArrayUtils.parse2DArray("[[2,3],[2,3]]")));
    }

    public static int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;

        Stack<int[]> stack = new Stack<>();
        int count = 1;
        int i = 1;

        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        stack.push(points[0]);

        while (i < points.length) {
            int[] prev = stack.peek();
            int[] current = points[i];

            if(prev[1] >= current[0]) { //intersection => continue
                stack.push(new int[]{current[0], prev[1]});
            } else {
                stack.push(current);
                count++;
            }
            i++;
        }

        return count;
    }
}
