package competitiveProgramming.geekforgeeks.phase1;

import java.util.HashSet;
import java.util.Set;

/*
https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/

Find whether an array is subset of another array | Added Method 3
Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not. Both the arrays are not in sorted order. It may be assumed that elements in both array are distinct.
Examples:

Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
Output: arr2[] is a subset of arr1[]



Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4}
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {10, 5, 2, 23, 19}, arr2[] = {19, 5, 3}
Output: arr2[] is not a subset of arr1[]
 */
public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{11, 1, 13, 21, 3, 7};
        int[] arr2 = new int[]{11, 3, 7, 1, 22};

        System.out.println(isSubset(arr1, arr2));
    }

    private static boolean isSubset(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int val : arr1) {
            set.add(val);
        }

        for (int val : arr2) {
            if (set.add(val)) return false;
        }
        return true;
    }
}
