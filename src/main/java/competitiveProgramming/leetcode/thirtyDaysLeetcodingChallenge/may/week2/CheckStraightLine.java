package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week2;

import utils.ArrayUtils;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3323/

Check If It Is a Straight Line
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

Example 1:

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
 */
public class CheckStraightLine {
    public static void main(String[] args) {
        int[][] coordinates;

        coordinates = ArrayUtils.parse2DArray("[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]");
        System.out.println(checkStraightLine(coordinates));

        coordinates = ArrayUtils.parse2DArray("[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]");
        System.out.println(checkStraightLine(coordinates));

        coordinates = ArrayUtils.parse2DArray("[[-3,-2],[-1,-2],[2,-2],[-2,-2],[0,-2]]");
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2) return false;

        double slope;
        double prevSlope = 0;

        for (int i = 1; i < coordinates.length; i++) {
            double y = coordinates[i][1] - coordinates[i - 1][1];
            double x = coordinates[i][0] - coordinates[i - 1][0];
            slope = y / x;
            if (i != 1 && slope != prevSlope) return false;
            prevSlope = slope;
        }

        return true;
    }
}
