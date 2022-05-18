package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.arrays;

import utils.ArrayUtils;

import java.util.Arrays;

/*
Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

Input: arr1[] = {10};
       arr2[] = {2, 3};
Output: arr1[] = {2}
        arr2[] = {3, 10}  

Input: arr1[] = {1, 5, 9, 10, 15, 20};
       arr2[] = {2, 3, 8, 13};
Output: arr1[] = {1, 2, 3, 5, 8, 9}
        arr2[] = {10, 13, 15, 20} 
Input:
First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.

Output:
For each test case, print (X + Y) space separated integer representing the merged array.

Constraints:
1 <= T <= 100
1 <= X, Y <= 5*104
0 <= arr1i, arr2i <= 109

Example:
Input:
2
4 5
1 3 5 7
0 2 6 8 9
2 3
10 12
5 18 20

Output:
0 1 2 3 5 6 7 8 9
5 10 12 18 20

Explanation:
Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.
 */
public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 5, 9, 10, 15, 20};
        int[] arr2 = new int[]{2, 3, 8, 13};
//        merge(arr1, arr2);
        merge2(arr1, arr2);
    }

    private static void merge(int[] arr1, int[] arr2) {

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] < arr1[i]) {
                    swap(arr1, arr2, i, j);
                }
            }
        }

        Arrays.sort(arr2);

        ArrayUtils.printArray(arr1);
        ArrayUtils.printArray(arr2);
    }

    private static void swap(int[] arr1, int[] arr2, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }


    static void merge2(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        for (int i = n - 1; i >= 0; i--) {
            int last = arr1[m - 1];
            for (int j = m - 2; j >= 0; j--) {
                arr1[j + 1] = arr1[j];
                if (arr1[j] < arr2[i]) {
                    swap(arr1, arr2, j + 1, i);
                    break;
                }
            }

            arr2[i] = last;
        }

        ArrayUtils.printArray(arr1);
        ArrayUtils.printArray(arr2);
    }
}
