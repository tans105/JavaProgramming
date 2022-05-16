package competitiveProgramming.leetcode.phase1;

/*
200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] arr = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(arr));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    markRecursive(grid, i, j, grid.length, grid[i].length);
                    count++;
                }
            }
        }
        return count;
    }

    private static void markRecursive(char[][] grid, int i, int j, int numRows, int numColumns) {
        if (i < 0 || j < 0 || i == numRows || j == numColumns || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        markRecursive(grid, i + 1, j, numRows, numColumns);
        markRecursive(grid, i - 1, j, numRows, numColumns);
        markRecursive(grid, i, j + 1, numRows, numColumns);
        markRecursive(grid, i, j - 1, numRows, numColumns);
    }
}
