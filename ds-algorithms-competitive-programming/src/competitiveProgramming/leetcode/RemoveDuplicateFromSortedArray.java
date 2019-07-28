package competitiveProgramming.leetcode;

import utils.ArrayUtils;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        ArrayUtils.printArray(nums);
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int currentIndex = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != prev) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
            prev = nums[i];
        }
        return currentIndex;
    }
}
