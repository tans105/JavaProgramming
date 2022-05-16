package competitiveProgramming.geekforgeeks;

import utils.LoggingUtil;

/*
https://www.geeksforgeeks.org/find-the-missing-number-in-a-sorted-array/

Find the Missing Number in a sorted array

Given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.

Examples:

Input : arr[] = [1, 2, 3, 4, 6, 7, 8]
Output : 5

Input : arr[] = [1, 2, 3, 4, 5, 6, 8, 9]
Output : 7

 */
public class MissingNumberInSortedArray {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1, 2, 3, 4, 6, 7, 8}));
        System.out.println(missingNumber(new int[]{1, 2, 3, 4, 5, 6, 8, 9}));
    }

    private static int missingNumber(int[] nums) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] == mid + 1)
                low = mid + 1;
            else
                high = mid - 1;
        }

        if (low + 1 < nums.length && nums[low] + 1 != nums[low + 1]) return nums[low] + 1;
        else return nums[low] - 1;
    }
}
