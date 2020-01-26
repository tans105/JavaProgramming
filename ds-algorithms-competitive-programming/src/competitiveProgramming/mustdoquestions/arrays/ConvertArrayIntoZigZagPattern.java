package competitiveProgramming.mustdoquestions.arrays;

import utils.ArrayUtils;

import static competitiveProgramming.geekforgeeks.SortArrayOfOneAndZero.swap;

/*
https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/0
Convert array into Zig-Zag fashion

Given an array A (distinct elements) of size N. Rearrange the elements of array in zig-zag fashion. The converted array should be in form a < b > c < d > e < f. The relative order of elements is same in the output i.e you have to iterate on the original array only.

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. Each testcase contains two lines of input. The first line contains a single integer N denoting the size of array.
The second line contains N space-separated integers denoting the elements of the array.

Output:
For each testcase, print the array in Zig-Zag fashion.

Constraints:
1 <= T <= 100
1 <= N <= 100
0 <= Ai <= 10000

Example:
Input:
2
7
4 3 7 8 6 2 1
4
1 4 3 2
Output:
3 7 4 8 2 6 1
1 4 2 3
 */
public class ConvertArrayIntoZigZagPattern {
    public static void main(String[] args) {
        printZigZag(new int[]{1, 4, 3, 2});
    }

    private static void printZigZag(int[] arr) {
        boolean lessThan = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (lessThan) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            lessThan = !lessThan;
        }

        ArrayUtils.printArray(arr);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
