package competitiveProgramming.leetcode;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */


/**
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(combine(4, 2));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsetsDriver(list, temp, nums, 0);
        return list;
    }

    private static void subsetsDriver(List<List<Integer>> list, List<Integer> temp, int[] nums, int count) {
        list.add(new ArrayList<>(temp));

        for (int i = count; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetsDriver(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private static List<List<Integer>> combine(int n, int k) {
        int[] nums = createArray(n);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combineDriver(list, temp, nums, 0, k);
        return list;
    }

    private static void combineDriver(List<List<Integer>> list, List<Integer> temp, int[] nums, int count, int k) {
        if (temp.size() == k) {
            list.add(new ArrayList<>(temp));
        }

        for (int i = count; i < nums.length; i++) {
            temp.add(nums[i]);
            combineDriver(list, temp, nums, i + 1, k);
            temp.remove(temp.size() - 1);
        }
    }

    private static int[] createArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
