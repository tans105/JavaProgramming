package competitiveProgramming.leetcode;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class FirstAndLastPositionOfSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 8, 8, 8, 8, 8};
//        ArrayUtils.printArray(searchRange(arr, 8));
    }

    private static int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return new int[]{-1, -1};
        } else {
//            System.out.println(index);
            return computeRangeOfOccurances(nums, index, target);
        }
    }

    private static int[] computeRangeOfOccurances(int[] nums, int index, Integer target) {
        Integer lowIndex = index, highIndex = index;
        boolean lower = true, higher = true;
        while (lower || higher) {
            if (lowIndex > 0 && nums[lowIndex - 1] == target) {
                lowIndex--;
            } else {
                lower = false;
            }

            if (highIndex < nums.length - 1 && nums[highIndex + 1] == target) {
                highIndex++;
            } else {
                higher = false;
            }

        }

        return new int[]{lowIndex, highIndex};
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, high, target);
        }
    }
}
