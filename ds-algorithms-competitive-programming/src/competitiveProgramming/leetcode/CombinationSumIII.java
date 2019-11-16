package competitiveProgramming.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
216. Combination Sum III

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(2, 18));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(result, temp, k, n, 0);
        return result;
    }


    private static void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int n, int start) {
        if (temp.size() == k) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += temp.get(i);
            }

            if (sum == n) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = start; i < n + 1; i++) {
            Integer integer = i + 1;
            if (temp.contains(integer)) continue;
            temp.add(integer);
            backtrack(result, temp, k, n, i);
            temp.remove(temp.size() - 1);
        }
    }
}
