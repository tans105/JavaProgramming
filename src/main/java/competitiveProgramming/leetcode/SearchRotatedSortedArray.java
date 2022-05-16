package competitiveProgramming.leetcode;

/*https://leetcode.com/problems/search-in-rotated-sorted-array
 * Tags: Arrays, Binary Search
 *
 */
public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        System.out.println(search(nums, 1));
    }

    private static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int pivot = getPivot(nums, 0, nums.length - 1);
        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (nums[pivot] == target)
            return pivot;
        if (nums[0] <= target)
            return binarySearch(nums, 0, pivot - 1, target);
        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        if (high < low)
            return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return binarySearch(arr, low, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, high, target);
        }
    }

    private static int getPivot(int[] arr, int low, int high) {
        if (high < low)
            return -1;
        if (high == low)
            return -1;

        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return getPivot(arr, low, mid - 1);
        return getPivot(arr, mid + 1, high);
    }
}
