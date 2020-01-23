package competitiveProgramming.mustdoquestions.arrays;

import utils.ArrayUtils;

/*
https://practice.geeksforgeeks.org/problems/reverse-array-in-groups/0

Reverse array in groups

Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines of input. The first line of each test case consists of an integer N(size of array) and an integer K separated by a space. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each test case, print the modified array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N, K ≤ 107
1 ≤ A[i] ≤ 1018

Example:
Input
2
5 3
1 2 3 4 5
6 2
10 20 30 40 50 60

Output
3 2 1 5 4
20 10 40 30 60 50

Explanation:
Testcase 1: Reversing groups in size 3, first group consists of elements 1, 2, 3. Reversing this group, we have elements in order as 3, 2, 1.
 */

public class ReverseArrayInGroups {
    public static void main(String[] args) {
        ArrayUtils.printArray(reverseArray(new int[]{10, 20, 30, 40, 50, 60}, 2));
    }

    private static int[] reverseArray(int[] arr, int k) {
        for (int i = 0; i < arr.length; i += k) {
            reverse(arr, i, Math.min(i + k - 1, arr.length - 1));
        }

        return arr;
    }

    private static void reverse(int[] arr, int startIndex, int endIndex) {

        while (startIndex < endIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
