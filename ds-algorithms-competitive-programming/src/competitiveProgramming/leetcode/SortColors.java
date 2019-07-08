package competitiveProgramming.leetcode;

import Utils.ArrayUtils;

/**
 * https://leetcode.com/problems/sort-colors/
 * 75. Sort Colors
 * <p>
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {
    public static void main(String[] args) {
        sortColors(new int[]{1, 0, 0, 2, 1});
        sortColors2(new int[]{1, 0, 0, 2, 1});
    }

    private static void sortColors(int[] nums) {
        int zeroIndex = 0, twoIndex = nums.length - 1, counter = 0;

        while (counter != nums.length && counter < twoIndex) {
            if (nums[counter] == 0) {
                swap(nums, counter, zeroIndex);
                counter++;
                zeroIndex++;
            } else if (nums[counter] == 2) {
                swap(nums, twoIndex, counter);
                if (nums[counter] == 0) {
                    swap(nums, zeroIndex, counter);
                    counter++;
                }
                twoIndex--;
            } else {
                counter++;
            }
        }

        ArrayUtils.printArray(nums);
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    /**
     * LeetSolution
     *
     * @param nums
     */
    private static void sortColors2(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
        ArrayUtils.printArray(nums);
    }
}

