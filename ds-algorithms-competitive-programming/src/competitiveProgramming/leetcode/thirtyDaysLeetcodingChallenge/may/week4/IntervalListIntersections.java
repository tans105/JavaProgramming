package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week4;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/

Interval List Intersections

Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

Example 1:

Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.


Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class IntervalListIntersections {
    public static void main(String[] args) {
        int[][] A;
        int[][] B;

        A = ArrayUtils.parse2DArray("[[0,2],[5,10],[13,23],[24,25]]");
        B = ArrayUtils.parse2DArray("[[1,5],[8,12],[15,24],[25,26]]");
        ArrayUtils.print2DArray(intervalIntersection(A, B));

        A = ArrayUtils.parse2DArray("[[5,10]]");
        B = ArrayUtils.parse2DArray("[[3,10]]");
        ArrayUtils.print2DArray(intervalIntersection(A, B));

        A = ArrayUtils.parse2DArray("[[10,12],[18,19]]");
        B = ArrayUtils.parse2DArray("[[1,6],[8,11],[13,17],[19,20]]");
        ArrayUtils.print2DArray(intervalIntersection(A, B));
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> intersections = new ArrayList<>();
        int countA = 0;
        int countB = 0;

        while (countA != A.length && countB != B.length) {
            int[] fromA = A[countA];
            int[] fromB = B[countB];
            int[] set = new int[2];

            /**
             * Cases:
             * 1. Gulp
             * 2. Ideal Gulp
             * 3. No Intersection
             * 4. Edge Intersection
             * 5. Partial Intersection
             */

            if (fromA[0] == fromB[0] && fromA[1] == fromB[1]) { // Case 2 - Ideal Gulp
                set[0] = fromB[0];
                set[1] = fromB[1];
                countB++;
                countA++;
                intersections.add(set);
            } else if (fromA[0] >= fromB[0] && fromA[1] <= fromB[1]) { // Case 1 -  Gulp
                set[0] = fromA[0];
                set[1] = fromA[1];
                countA++;
                intersections.add(set);
            } else if (fromA[0] <= fromB[0] && fromA[1] >= fromB[1]) { // Case 1 - Gulp
                set[0] = fromB[0];
                set[1] = fromB[1];
                countB++;
                intersections.add(set);
            } else if (fromA[0] > fromB[1]) { // Case 3 - No intersection
                countB++;
            } else if (fromA[1] < fromB[0]) { // Case 3 - No intersection
                countA++;
            } else if (fromA[1] == fromB[0]) { // Case 4 - Edge Intersection
                set[0] = fromA[1];
                set[1] = fromA[1];
                countA++;
                intersections.add(set);
            } else if (fromA[0] == fromB[1]) { // Case 4 - Edge Intersection
                set[0] = fromA[0];
                set[1] = fromA[0];
                countB++;
                intersections.add(set);
            } else if (fromA[0] < fromB[0]) { // Case 5 Partial Intersection
                set[0] = fromB[0];
                set[1] = fromA[1];
                countA++;
                intersections.add(set);
            } else { // Case 5 Partial Intersection
                set[0] = fromA[0];
                set[1] = fromB[1];
                countB++;
                intersections.add(set);
            }
        }

        return intersections.toArray(new int[intersections.size()][]);
    }
}
