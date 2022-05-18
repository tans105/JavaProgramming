package competitiveProgramming.geekforgeeks.phase2.arrays;

import java.util.ArrayList;

/*
https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1

Subarray with given sum
Easy
Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.

In case of multiple subarrays, return the subarray which comes first on moving from left to right.

Example 1:

Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements
from 2nd position to 4th position
is 12.


Example 2:

Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements
from 1st position to 5th position
is 15.
 */


public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3, 7, 5}, 5, 12));
        System.out.println(subarraySum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 15));
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> list = new ArrayList<>();

        if (arr == null) return list;

        int i = 0, j = 0;
        int sum = arr[i];

        while (i < arr.length) {
            if (sum == s) {
                list.add(i + 1);
                list.add(j + 1);
                return list;
            } else if (sum < s) {
                if (j == arr.length - 1) {
                    list.add(-1);
                } else {
                    j++;
                    sum += arr[j];
                }
            } else {
                sum -= arr[i];
                i++;
            }
        }

        return list;
    }
}
