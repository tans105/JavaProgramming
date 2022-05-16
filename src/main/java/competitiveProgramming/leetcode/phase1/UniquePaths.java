package competitiveProgramming.leetcode.phase1;

//https://leetcode.com/problems/unique-paths/

import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {
    public static int count = 0;

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
        System.out.println(uniquePaths2(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        getUniquePathHelper(0, 0, m, n);
        return count;
    }

    private static void getUniquePathHelper(int x, int y, int m, int n) {
        if (x == m - 1 && y == n - 1) {
            count++;
            return;
        }
        if (x == m || y == n) return;
        getUniquePathHelper(x + 1, y, m, n);
        getUniquePathHelper(x, y + 1, m, n);
    }

    /**
     * Leetcode solution
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = 1;
        }

        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[m - 1];
    }
}
