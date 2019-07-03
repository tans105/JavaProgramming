package competitiveProgramming.leetcode;

import Utils.ArrayUtils;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
        System.out.println(minPathSumDP(grid));
    }

    public static int minPathSum(int[][] grid) {
        int minCost;
        minCost = minPathSumRec(grid, 0, 0, grid.length, grid[0].length);
        return minCost;
    }

    private static int minPathSumRec(int[][] grid, int x, int y, int xLength, int yLength) {
        if (x >= xLength || y >= yLength) {
            return Integer.MAX_VALUE;
        } else if (x == xLength - 1 && y == yLength - 1) {
            return grid[x][y];
        } else {
            return grid[x][y] + min(minPathSumRec(grid, x + 1, y, xLength, yLength), minPathSumRec(grid, x, y + 1, xLength, yLength), Integer.MAX_VALUE);
        }
    }

    static int min(int x, int y, int z) {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

    static int minPathSumDP(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        if (grid.length == 0) {
            return 0;
        }
        int xLength = grid.length;
        int yLength = grid[0].length;
        int[][] arr = new int[xLength][yLength];
        arr[0][0] = grid[0][0];
        //vertical
        for (int i = 1; i < xLength; i++) {
            arr[i][0] = arr[i - 1][0] + grid[i][0];
        }

        //horizontal
        for (int i = 1; i < yLength; i++) {
            arr[0][i] = arr[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < xLength; i++) { //x
            for (int j = 1; j < yLength; j++) { //y
                arr[i][j] = grid[i][j] + Math.min(arr[i - 1][j], arr[i][j - 1]);
            }
        }

        return arr[xLength - 1][yLength - 1];
    }
}
