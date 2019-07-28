package competitiveProgramming.leetcode;

import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations/
//https://leetcode.com/problems/permutations-ii/
public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
//        System.out.println(permute(nums));
//        System.out.println(permute2(nums));
        System.out.println(permuteDuplicates(nums));
    }

    private static List<List<Integer>> permuteDuplicates(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrackDuplicates(finalList, tempList, nums, used);
        return finalList;
    }

    private static void backtrackDuplicates(List<List<Integer>> finalList, List<Integer> tempList, int[] nums, boolean[] used) {
        LoggingUtil.logNewLine(tempList, Arrays.toString(used));
        if (tempList.size() == nums.length) {
            finalList.add(new ArrayList<>(tempList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                System.out.println(Arrays.toString(used));
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            backtrackDuplicates(finalList, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    private static void backtrack(List<List<Integer>> finalList, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            finalList.add(new ArrayList<>(tempList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(finalList, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }


    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(finalList, tempList, nums);
        return finalList;
    }


    public static List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length == 0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i < num.length; ++i) {
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> l : ans) {
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j, num[i]);
                    new_ans.add(new_l);
                }
            }
            ans = new_ans;
        }
        return ans;
    }


    public static List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> third = new ArrayList<>();
        if (nums == null || nums.length == 0) return third;
        temp.add(nums[0]);
        finalList.add(temp);
        third.addAll(finalList);
        for (int i = 1; i < nums.length; i++) {
            third = new ArrayList<>();
            List<List<Integer>> finalListCopy = new ArrayList<>(finalList);
            for (int j = 0; j < finalList.size(); j++) {
                finalListCopy = createPermutation(nums[i], finalList.get(j), finalList);
                temp.add(nums[i]);
                third.addAll(finalListCopy);
            }

            finalList = finalListCopy;
        }
        return third;
    }

    private static List<List<Integer>> createPermutation(int num, List<Integer> temp, List<List<Integer>> finalList) {
        List<List<Integer>> finalListCopy = new ArrayList<>();
        for (int i = 0; i <= temp.size(); i++) {
            List<Integer> temp1 = new ArrayList<>(temp);
            temp1.add(i, num);
            finalListCopy.add(temp1);
        }
        finalList = finalListCopy;
        return finalList;
    }
}
