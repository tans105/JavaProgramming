package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week5;

import utils.ArrayUtils;

import java.util.*;

/*
K Closest Points to Origin
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)


Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
 */
public class KClosestPointToOrigin {
    public static void main(String[] args) {
        ArrayUtils.print2DArray(kClosest(ArrayUtils.parse2DArray("[[1,1],[1,3],[-2,2],[3,4],[5,2]]"), 2));
    }

    public static int[][] kClosest(int[][] points, int K) {
        List<int[]> coordinates = Arrays.asList(points);
        coordinates.sort((p1, p2) -> {
            int x1 = p1[0];
            int y1 = p1[1];
            int x2 = p2[0];
            int y2 = p2[1];
            return (x1 * x1 + y1 * y1) - (x2 * x2 + y2 * y2);
        });

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = coordinates.get(i);
        }

        return result;
    }
}
