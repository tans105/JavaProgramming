package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.july.week4;

/*
Find Minimum in Rotated Sorted Array II

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1

Example 2:

Input: [2,2,2,0,1]
Output: 0

Note:

    This is a follow up problem to Find Minimum in Rotated Sorted Array.
    Would allow duplicates affect the run-time complexity? How and why?
 */
public class MinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 3, 5}));
        System.out.println(findMin(new int[]{4, 4, 1, 1, 2, 2, 3, 3}));
        System.out.println(findMin(new int[]{5, 4, 5, 5, 5, 5}));
        System.out.println(findMin(new int[]{2, 2, 2, 0, 1}));
        System.out.println(findMin(new int[]{3, 3, 1}));
        System.out.println(findMin(new int[]{10, 10, 1, 10, 10}));
        System.out.println(findMin(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 1, 3}));
    }


    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int pivot = findPivot(nums);
        if (pivot == -1) return nums[0];
        return pivot;
    }

    private static int findPivot(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[high] > nums[mid]) {
                high = mid;
            } else if (nums[high] < nums[mid]) {
                low = mid + 1;
            } else {
                high--;
            }
        }

        return nums[low];
    }
}
