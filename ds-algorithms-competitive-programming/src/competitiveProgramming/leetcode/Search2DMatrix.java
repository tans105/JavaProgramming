package competitiveProgramming.leetcode;

import Utils.ArrayUtils;
import Utils.LoggingUtil;

import java.util.Arrays;

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
                {55, 56, 57, 58}
        };
        System.out.println(searchMatrix(matrix, 62));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
            int rowNum = findClosestColumn((getColumnsArray(matrix)), target);
            return binarySearch(matrix[rowNum], target, 0, matrix[rowNum].length - 1);
        } else {
            return false;
        }
    }

    private static int[] getColumnsArray(int[][] matrix) {
        int[] arr = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            arr[i] = matrix[i][0];
        }

        return arr;
    }

    private static boolean binarySearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return false;
        }
        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return true;
        }

        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, high);
        } else {
            return binarySearch(arr, target, low, mid - 1);
        }
    }

    private static int findClosestColumn(int[] a, int value) {

        if (value < a[0]) {
            return 0;
        }
        if (value > a[a.length - 1]) {
            return a.length - 1;
        }

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (hi + lo) / 2;

            if (value < a[mid]) {
                hi = mid - 1;
            } else if (value > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return (value < a[lo]) ? lo - 1 : lo;
    }
}
