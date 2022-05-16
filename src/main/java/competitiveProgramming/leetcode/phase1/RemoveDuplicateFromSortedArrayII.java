package competitiveProgramming.leetcode.phase1;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * 80. Remove Duplicates from Sorted Array II
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * <p>
 * Confused why the returned value is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class RemoveDuplicateFromSortedArrayII {
    public static void main(String[] args) {
        int nums[] = {0, 0, 1, 1, 1, 1, 2, 3, 3};
//        System.out.println(removeDuplicates(nums.clone()));
        System.out.println(removeDuplicates2(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int tempCount = 0; //should not count duplicate more than 2
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && tempCount <= 2) {
                tempCount++;
            }
            if (nums[i] == nums[i - 1] && tempCount == 2) {
                prev = nums[i];
                nums[i] = Integer.MAX_VALUE;
            }

            if (nums[i - 1] == Integer.MAX_VALUE && nums[i] == prev) {
                nums[i] = Integer.MAX_VALUE;
            } else if (nums[i] != nums[i - 1]) {
                tempCount = 0;
            }
        }
        Arrays.sort(nums);
        return getSizeOfArray(nums);
    }

    public static int getSizeOfArray(int[] arr) {
        int len = 0;
        for (int i : arr) {
            if (i == Integer.MAX_VALUE) {
                break;
            } else {
                len++;
            }
        }
        return len;
    }


    /**
     * Leet solution
     *
     * @param nums
     * @return
     */
    static int removeDuplicates2(int[] nums) {
        //define at most k times of duplicate numbers
        final int k = 2;

        //check if it is an empty array
        if (nums.length == 0) return 0;

        //start pointer of new array
        int m = 1;

        // count the time of duplicate numbers occurence
        int count = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                if (count < k) {
                    nums[m] = nums[i];
                    m++;
                }
                count++;
            } else {
                count = 1;
                nums[m] = nums[i];
                m++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return m;
    }
}
