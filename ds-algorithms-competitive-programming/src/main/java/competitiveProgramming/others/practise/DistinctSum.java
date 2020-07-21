package competitiveProgramming.others.practise;

import java.util.*;

public class DistinctSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{1, 2, 3, 6, 7, 8, 9, 1}, 10));
        System.out.println(twoSum(new int[]{1, 3, 46, 1, 3, 9}, 47));
        System.out.println(twoSum(new int[]{1, 1, 1, 1}, 2));
    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> soFar = new HashSet<>();
        Set<String> hash = new HashSet<>();

        for (int num : nums) {
            int desired = target - num;

            if (soFar.contains(desired)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                temp.add(desired);
                String currentHash = (num > desired) ? String.valueOf(num) + String.valueOf(desired) : String.valueOf(desired) + String.valueOf(num);
                if (!hash.contains(currentHash)) {
                    hash.add(currentHash);
                    ans.add(temp);
                }
            } else {
                soFar.add(num);
            }
        }

        return ans;
    }
}
