package competitiveProgramming.geekforgeeks.mustdoquestions.stackqueue;
/*
https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
https://leetcode.com/problems/rotting-oranges/

Minimum time required to rot all oranges
Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0: Empty cell

1: Cells have fresh oranges

2: Cells have rotten oranges
So we have to determine what is the minimum time required so that all the oranges become rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). If it is impossible to rot every orange then simply return -1.
 */

import utils.ArrayUtils;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeToRotAllOranges {
    public static void main(String[] args) {
        int[][] grid = ArrayUtils.parse2DArray("[[2,1,1],[1,1,0],[0,1,1]]");
        System.out.println(orangesRotting(grid));

        grid = ArrayUtils.parse2DArray("[[2,1,0,2,1],[1,0,1,2,1],[1,0,0,2,1]]");
        System.out.println(orangesRotting(grid));

        grid = ArrayUtils.parse2DArray("[[2,1,0,2,1],[0,0,1,2,1],[1,0,0,2,1]]");
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        Coordinate[][] coordinates = new Coordinate[grid.length][grid[0].length];
        Queue<Coordinate> stack = new LinkedList<>();
        fillCoordinates(coordinates, grid, stack);
        int days = 0;
        int X = coordinates.length;
        int Y = coordinates[0].length;

        while (!stack.isEmpty()) {
            Coordinate coordinate = stack.poll();
            if (coordinate == null) {
                if (stack.size() == 0) {
                    break;
                } else {
                    stack.offer(null);
                    days++;
                }
            } else {
                int i = coordinate.x;
                int j = coordinate.y;

                if (coordinate.value == 2) {
                    if (i - 1 >= 0 && coordinates[i - 1][j].value == 1) {
                        coordinates[i - 1][j].value = 2;
                        stack.offer(coordinates[i - 1][j]);
                    }
                    if (i + 1 < X && coordinates[i + 1][j].value == 1) {
                        coordinates[i + 1][j].value = 2;
                        stack.offer(coordinates[i + 1][j]);
                    }
                    if (j - 1 >= 0 && coordinates[i][j - 1].value == 1) {
                        coordinates[i][j - 1].value = 2;
                        stack.offer(coordinates[i][j - 1]);
                    }
                    if (j + 1 < Y && coordinates[i][j + 1].value == 1) {
                        coordinates[i][j + 1].value = 2;
                        stack.offer(coordinates[i][j + 1]);
                    }
                }
            }
        }

        return (validate(coordinates)) ? days : -1;
    }

    private static boolean validate(Coordinate[][] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                if (coordinates[i][j].value == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void fillCoordinates(Coordinate[][] coordinates, int[][] grid, Queue<Coordinate> stack) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                coordinates[i][j] = new Coordinate(i, j, grid[i][j]);
                if (coordinates[i][j].value == 2) {
                    stack.offer(coordinates[i][j]);
                }
            }
        }
        stack.offer(null);
    }

    static class Coordinate {
        int x;
        int y;
        int value;

        Coordinate(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        Coordinate() {

        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    ", value=" + value +
                    '}';
        }
    }
}

