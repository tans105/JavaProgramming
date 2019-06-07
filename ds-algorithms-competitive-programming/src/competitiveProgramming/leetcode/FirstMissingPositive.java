package competitiveProgramming.leetcode;

import Utils.ArrayUtils;

//https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 4, 5, -1, 3, 7};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i])
                swap(nums, i, nums[i]);
            else
                i++;
        }
        int k = 1;

        while (k < n && nums[k] == k)
            k++;

        if (n == 0 || k < n)
            return k;
        else
            return nums[0] == k ? k + 1 : k;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
