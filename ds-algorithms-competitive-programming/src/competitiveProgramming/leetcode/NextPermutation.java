package competitiveProgramming.leetcode;

import Utils.ArrayUtils;
import Utils.LoggingUtil;

import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 3, 3};
        nextPermutation(arr);
//        ArrayUtils.printArray((arr));
    }

    public static void nextPermutation(int[] nums) {
        int prev = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (prev == Integer.MAX_VALUE) {
                prev = nums[i];
                continue;
            } else {
                if (nums[i] < prev) {
                    swap(nums, i);
                    reverse(nums, i);
                    return;
                }
            }
            prev = nums[i];

        }
        Arrays.sort(nums);
    }

    private static void reverse(int[] nums, int fromIndex) {
        int i = fromIndex + 1;
        int j = nums.length - 1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index2];
        nums[index2] = nums[index1];
        nums[index1] = temp;
    }

    private static void swap(int[] nums, int decreasingElementIndex) {
//        System.out.println(decreasingElementIndex);
        int swapIndex = -1;
        int minDiff = Integer.MAX_VALUE;
        int currentDiff;
        for (int i = decreasingElementIndex + 1; i < nums.length; i++) {
            currentDiff = nums[decreasingElementIndex] - nums[i];
            if (currentDiff < 0 && Math.abs(currentDiff) <= Math.abs(minDiff)) {
                minDiff = currentDiff;
                swapIndex = i;
            }
        }
//        System.out.println(swapIndex);
        swap(nums, swapIndex, decreasingElementIndex);
//        ArrayUtils.printArray(nums);
    }
}
