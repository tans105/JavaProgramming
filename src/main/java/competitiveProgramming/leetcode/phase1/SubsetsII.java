package competitiveProgramming.leetcode.phase1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * Medium
 * <p>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubsetsII {
    public static void main(String[] args) {
        System.out.println(subsets2(new int[]{1, 2, 2}));
    }

    private static List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsetsDriver(list, temp, nums, 0);
        return list;
    }

    private static void subsetsDriver(List<List<Integer>> list, List<Integer> temp, int[] nums, int count) {
        list.add(new ArrayList<>(temp));

        for (int i = count; i < nums.length; i++) {
            if (i > count && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            subsetsDriver(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
