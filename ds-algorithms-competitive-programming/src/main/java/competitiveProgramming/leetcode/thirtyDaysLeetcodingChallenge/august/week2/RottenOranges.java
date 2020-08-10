package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.august.week2;

import utils.ArrayUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3418/

Rotting Oranges

In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.



Note:

    1 <= grid.length <= 10
    1 <= grid[0].length <= 10
    grid[i][j] is only 0, 1, or 2.


 */
public class RottenOranges {
    public static void main(String[] args) {
        String str = "[[2,1,1],[1,1,0],[0,1,1]]";
        System.out.println(solve(ArrayUtils.getNestedListFromString(str)));

        str = "[[2,1,1],[0,1,1],[1,0,1]]";
        System.out.println(solve(ArrayUtils.getNestedListFromString(str)));
    }

    public static int solve(List<List<Integer>> list) {
        Queue<Coordinate> queue = new LinkedList<>();
        int days = 0;
        int rows = list.size();
        int columns = list.get(0).size();
        boolean canRot = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (list.get(i).get(j) == 2) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        queue.offer(null);

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            if (coordinate == null) {
                if (queue.size() == 0) {
                    break;
                } else {
                    days++;
                    queue.offer(null);
                    continue;
                }
            }

            int x = coordinate.x;
            int y = coordinate.y;

            if (x - 1 >= 0 && list.get(x - 1).get(y) == 1) {
                list.get(x - 1).set(y, 2);
                queue.offer(new Coordinate(x - 1, y));
                //rot it
                //add to queue
            }
            if (y - 1 >= 0 && list.get(x).get(y - 1) == 1) {
                //rot it
                //add to queue
                list.get(x).set(y - 1, 2);
                queue.offer(new Coordinate(x, y - 1));
            }
            if (x + 1 < rows && list.get(x + 1).get(y) == 1) {
                //rot it
                //add to queue
                list.get(x + 1).set(y, 2);
                queue.offer(new Coordinate(x + 1, y));
            }
            if (y + 1 < columns && list.get(x).get(y + 1) == 1) {
                //rot it
                //add to queue
                list.get(x).set(y + 1, 2);
                queue.offer(new Coordinate(x, y + 1));
            }
        }

        for (List<Integer> integers : list) {
            for (int j = 0; j < columns; j++) {
                if (integers.get(j) == 1) return -1;
            }
        }

        return days;
    }


    private static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}


