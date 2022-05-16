package competitiveProgramming.leetcode;

import java.util.*;

//https://leetcode.com/problems/permutations-ii/
public class PermutationWithDuplicate {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 3};
//        System.out.println(permuteUnique(arr));
        permutation1(arr, 3);
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        permute(ans, nums, 0);
        return ans;
    }

    private static void permute(List<List<Integer>> ans, int[] nums, int index) {
//        LoggingUtil.logNewLine("PERMUTE", index);
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i = index; i < nums.length; ++i) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                permute(ans, nums, index + 1);
                swap(nums, index, i);
            }
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }


    public static void permutation1(int[] a, int n) {
        if (n == 1) {
            System.out.println(Arrays.toString(a));
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (appeared.add(a[i])) {
                swap(a, i, n - 1);  // (remove the ith element)
                permutation1(a, n - 1);
                swap(a, i, n - 1);  // (restore for the next round)
            }
        }
    }

}
