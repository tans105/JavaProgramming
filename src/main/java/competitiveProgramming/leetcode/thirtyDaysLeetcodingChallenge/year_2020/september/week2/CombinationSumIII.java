package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.september.week2;

import java.util.ArrayList;
import java.util.List;

/*
Combination Sum III

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

    The solution set must not contain duplicate combinations.



Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]

Example 3:

Input: k = 4, n = 1
Output: []

Example 4:

Input: k = 3, n = 2
Output: []

Example 5:

Input: k = 9, n = 45
Output: [[1,2,3,4,5,6,7,8,9]]



Constraints:

    2 <= k <= 9
    1 <= n <= 60


 */
public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(4, 1));
        System.out.println(combinationSum3(3, 2));
        System.out.println(combinationSum3(9, 45));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};


        backtrack(result, temp, nums, n, 0, k, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int n, int currentSum, int k, int start) {
        if (currentSum == n && temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (currentSum > n) {
            return;
        }

        if (temp.size() > k) return;

        for (int i = start; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(result, temp, nums, n, currentSum + nums[i], k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
