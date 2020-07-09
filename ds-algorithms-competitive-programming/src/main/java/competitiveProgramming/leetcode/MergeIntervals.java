package competitiveProgramming.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*
56. Merge Intervals
Medium

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int arr[][] = {
                {2, 3},
                {2, 2},
                {3, 3},
                {1, 3},
                {5, 7},
                {2, 2},
                {4, 6}
        };

        utils.ArrayUtils.print2DArray(merge(arr));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0] - t1[0];
            }
        });

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        int currentIndex = 1;
        while (currentIndex != intervals.length) {
            int[] current = stack.peek();
            int[] next = intervals[currentIndex];

            if (current[1] < next[0]) {
                stack.push(next);
            } else if (current[1] < next[1]) {
                current[1] = next[1];
                stack.pop();
                stack.push(current);
            }

            currentIndex++;
        }

        int[][] arr = new int[stack.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.get(i);
        }

        return arr;
    }
}

