package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.april.week3;

import utils.ArrayUtils;

/*
Search in Rotated Sorted Array
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3304/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.parseArray("[4,5,6,7,8,9,0,1,2]");
        System.out.println(search(arr, 2)); //8

        arr = ArrayUtils.parseArray("[1]");
        System.out.println(search(arr, 1)); //0

        arr = ArrayUtils.parseArray("[3,5,1]");
        System.out.println(search(arr, 3)); //0
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        if (pivot == -1) return binarySearch(nums, 0, nums.length - 1, target);
        if (nums[pivot] == target) return pivot;
        System.out.println(pivot);

        if (nums[0] <= target) {
            return binarySearch(nums, 0, pivot - 1, target);
        } else {
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        }
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, high, target);
        }
    }


    private static int findPivot(int[] nums, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
            return mid;
        } else {
            if (nums[mid] < nums[low]) { //left half
                return findPivot(nums, low, mid - 1);
            } else { //right half
                return findPivot(nums, mid + 1, high);
            }
        }


    }
}
