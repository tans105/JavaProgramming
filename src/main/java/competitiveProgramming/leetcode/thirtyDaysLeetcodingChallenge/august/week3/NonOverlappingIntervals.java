package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.august.week3;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*
Non-overlapping Intervals
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.



Example 1:

Input: [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:

Input: [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:

Input: [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.


Note:

You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(ArrayUtils.parse2DArray("[[1,2],[2,3],[3,4],[1,3]]")));
        System.out.println(eraseOverlapIntervals(ArrayUtils.parse2DArray("[[1,2],[1,2],[1,2]]")));
        System.out.println(eraseOverlapIntervals(ArrayUtils.parse2DArray("[[1,2],[2,3]]")));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Stack<int[]> stack = new Stack<>();

        Arrays.sort(intervals, (t1, t2) -> {
            if (t1[1] == t2[1]) {
                return t1[0] - t2[0];
            }
            return t1[1] - t2[1];
        });

        stack.push(intervals[0]);
        int index = 1;
        int count = 0;

        while (index < intervals.length) {
            int[] current = intervals[index];
            int[] prev = stack.peek();


            if (current[0] >= prev[1]) { //disjoint
                stack.push(current);
            } else {
                count++;
            }

            index++;
        }

        return count;
    }
}
