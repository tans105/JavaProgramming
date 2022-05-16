package competitiveProgramming.leetcode.phase1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
658. Find K Closest Elements

Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104

UPDATE (2017/9/19):
The arr parameter had been changed to an array of integers (instead of a list of integers). Please reload the code definition to get the latest changes.

Accepted
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        System.out.println(findClosestElements(new int[]{10, 20, 30, 40, 50}, 4, 28));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int index = getNearestIndex(arr, x);
        int i = (index >= 0) ? index : -1;
        int j = (index + 1 <= arr.length - 1) ? index + 1 : arr.length;
        int leftDiff;
        int rightDiff;

        while (list.size() != k) {
            leftDiff = Integer.MAX_VALUE;
            rightDiff = Integer.MAX_VALUE;

            if (i >= 0) {
                leftDiff = Math.abs(arr[i] - x);
            }

            if (j <= arr.length - 1) {
                rightDiff = Math.abs(arr[j] - x);
            }

            if (leftDiff < rightDiff) {
                list.add(arr[i]);
                i--;
            } else {
                list.add(arr[j]);
                j++;
            }
        }

        return list;
    }

    private static int getNearestIndex(int[] arr, int val) {
        int low = 0;
        int high = arr.length;
        int nearestIndex = 0;
        int nearestDiff = Integer.MAX_VALUE;


        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] == val) {
                nearestIndex = mid;
                break;
            }

            int diff = Math.abs(val - arr[mid]);
            if (diff < nearestDiff) {
                nearestIndex = mid;
                nearestDiff = diff;
            }

            if (val > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return nearestIndex;
    }
}
