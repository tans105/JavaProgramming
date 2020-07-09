package competitiveProgramming.leetcode;

/*
153. Find Minimum in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 */
public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2, 1}));
    }

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int min = Integer.MAX_VALUE;
        int index = findPivot(nums, 0, nums.length - 1);

        if (index == -1) {
            return nums[0];
        }

        if (index + 1 <= nums.length - 1) {
            min = Math.min(min, Math.min(nums[index], nums[index + 1]));
        }

        if (index - 1 >= 0) {
            min = Math.min(min, Math.min(nums[index - 1], nums[index]));
        }
        return min;
    }

    private static int findPivot(int[] nums, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (mid + 2 <= nums.length && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        if (mid >= 1 && nums[mid] < nums[mid - 1]) {
            return mid;
        }

        if (nums[mid] > nums[high]) {
            return findPivot(nums, mid + 1, high);
        } else {
            return findPivot(nums, low, mid - 1);
        }
    }
}
