package competitiveProgramming.leetcode;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
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
            return grid[x][y] + min(minPathSumRec(grid, x + 1, y, xLength, yLength), minPathSumRec(grid, x, y + 1, xLength, yLength), minPathSumRec(grid, x + 1, y + 1, xLength, yLength));
        }
    }

    static int min(int x, int y, int z) {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }
}
