package competitiveProgramming.leetcode.phase1;

import java.util.*;

//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> parent = new ArrayList<>();
        HashMap<Integer, Integer> sl = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sl.put(nums[i], i);
        }
        System.out.println(sl);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = 0 - nums[i] - nums[j];
                if (sl.containsKey(target) && sl.get(target) > j) {
                    j = sl.get(nums[j]);
                    parent.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
            i = sl.get(nums[i]);
        }
        return parent;

    }

}
