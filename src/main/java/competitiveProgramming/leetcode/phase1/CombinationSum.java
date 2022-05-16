package competitiveProgramming.leetcode.phase1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
//https://leetcode.com/problems/combination-sum-ii/

/*Tags: Arrays, Backtracking */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{1, 2, 3}, 6));
        System.out.println(combinationSum2(new int[]{1, 2, 3}, 6));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        backtrack(candidates, temp, result, sum, 0, target);
        return result;
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int sum = 0;
        backtrackWithoutDuplicates(candidates, temp, result, sum, 0, target);
        return result;
    }


    private static void backtrack(int[] candidates, List<Integer> temp, List<List<Integer>> result, int sum, int start, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backtrack(candidates, temp, result, sum + candidates[i], i, target);
            temp.remove(temp.size() - 1);
        }
    }

    private static void backtrackWithoutDuplicates(int[] candidates, List<Integer> temp, List<List<Integer>> result, int sum, int start, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            temp.add(temp.size(), candidates[i]);
            backtrackWithoutDuplicates(candidates, temp, result, sum + candidates[i], i + 1, target);
            temp.remove(temp.size() - 1);
        }
    }

}
