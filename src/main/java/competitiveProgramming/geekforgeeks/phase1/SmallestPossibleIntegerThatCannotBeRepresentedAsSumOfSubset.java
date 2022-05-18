package competitiveProgramming.geekforgeeks.phase1;

import utils.LoggingUtil;

/*
https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/

Find the smallest positive integer value that cannot be represented as sum of any subset of a given array
Given a sorted array (sorted in non-decreasing order) of positive numbers, find the smallest positive integer value that cannot be represented as sum of elements of any subset of given set.
Expected time complexity is O(n).

Examples:

Input:  arr[] = {1, 3, 6, 10, 11, 15};
Output: 2

Input:  arr[] = {1, 1, 1, 1};
Output: 5

Input:  arr[] = {1, 1, 3, 4};
Output: 10

Input:  arr[] = {1, 2, 5, 10, 20, 40};
Output: 4

Input:  arr[] = {1, 2, 3, 4, 5, 6};
Output: 22
 */
public class SmallestPossibleIntegerThatCannotBeRepresentedAsSumOfSubset {
    public static void main(String[] args) {
        System.out.println(getSmallestPossibleNumber(new int[]{1, 2, 3, 4, 5, 6}));
    }

    private static int getSmallestPossibleNumber(int[] arr) {
        int currentSum = 0;
        int prevSum = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum - (i + 1) > prevSum) {
                res = prevSum + 1;
                break;
            }
            prevSum = currentSum;
        }
        return (res != -1) ? res : currentSum + 1;
    }
}
