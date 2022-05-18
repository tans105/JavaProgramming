package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.arrays;

import java.util.ArrayList;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/inversion-of-array/0/

Given an array of positive integers. The task is to find inversion count of array.

Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, the size of array. The second line of each test case contains N elements.

Output:
Print the inversion count of array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
1 ≤ C ≤ 1018

Example:
Input:
1
5
2 4 1 3 5

Output:
3

Explanation:
Testcase 1: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 */
public class InversionOfArray {
    public static void main(String[] args) {
        getInversion(new int[]{2, 4, 1, 3, 5});
    }

    private static void getInversion(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        mergeSort(arr, 0, arr.length - 1);

        System.out.println(count);
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static int count = 0;

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (int i = 0; i <= mid; i++) {
            l1.add(arr[i]);
        }

        for (int i = mid + 1; i <= high; i++) {
            l2.add(arr[i]);
        }

        int c1 = 0;
        int c2 = 0;
        int index = 0;

        while (c1 != l1.size() && c2 != l2.size()) {
            if (l1.get(c1) <= l2.get(c2)) {
                arr[index] = l1.get(c1);
                c1++;
                index++;
            } else {
                arr[index] = l2.get(c2);
                count += (mid + 1) - (low + index);
                c2++;
                index++;

            }
        }


        while (c1 != l1.size()) {
            arr[index] = l1.get(c1);
            c1++;
            index++;
        }

        while (c2 != l2.size()) {
            arr[index] = l2.get(c2);
            c2++;
            index++;
        }

    }

}
