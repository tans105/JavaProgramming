package competitiveProgramming.leetcode;

import Utils.LoggingUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
//        System.out.println(permute(nums));
        System.out.println(permute2(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(finalList, tempList, nums);
        return finalList;
    }

    private static void backtrack(List<List<Integer>> finalList, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            finalList.add(new ArrayList<>(tempList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            backtrack(finalList, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length ==0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i< num.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
            for (int j = 0; j<=i; j++){
                for (List<Integer> l : ans){
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j,num[i]);
                    new_ans.add(new_l);
                }
            }
            ans = new_ans;
        }
        return ans;
    }
}
