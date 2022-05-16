package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.april.week3;

/*
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/

Number of Islands

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
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    doRecursive(grid, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    private static void doRecursive(char[][] grid, int row, int col, int rows, int cols) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        doRecursive(grid, row + 1, col, rows, cols);
        doRecursive(grid, row - 1, col, rows, cols);
        doRecursive(grid, row, col + 1, rows, cols);
        doRecursive(grid, row, col - 1, rows, cols);
    }
}
