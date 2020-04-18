package competitiveProgramming.interviewbit;

import java.util.*;

/*
Rotten Oranges
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.
The value 1 representing a fresh orange.
The value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.

Note:

Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.


Input Format

The first argument given is the integer matrix A.
Output Format

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.
Constraints

1 <= N, M <= 1000
0 <= A[i] <= 2
For Example

Input 1:
    A = [   [2, 1, 1]
            [1, 1, 0]
            [0, 1, 1]   ]
Output 1:
    4

Input 2:
    A = [   [2, 1, 1]
            [0, 1, 1]
            [1, 0, 1]   ]
Output 2:
    -1
 */
public class RottenOranges {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list;

        list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(2, 1, 1)));
        list.add(new ArrayList<>(Arrays.asList(1, 1, 0)));
        list.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        System.out.println(solve(list));


        list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(2, 1, 1)));
        list.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        list.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        System.out.println(solve(list));
    }

    public static int solve(ArrayList<ArrayList<Integer>> list) {
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

        for (ArrayList<Integer> integers : list) {
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


