package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.june.week2;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/

Largest Divisible Subset
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        LargestDivisibleSubset subset = new LargestDivisibleSubset();
        System.out.println(subset.largestDivisibleSubset2(new int[]{1, 2, 4, 8}));
        System.out.println(subset.largestDivisibleSubset2(new int[]{1, 2, 3}));
        System.out.println(subset.largestDivisibleSubset2(new int[]{3, 4, 16, 8}));
    }

    /*
    Using DP
     */
    public List<Integer> largestDivisibleSubset2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            List<Integer> largest = new ArrayList<>(); //largest subset for the current
            List<Integer> current = map.get(i);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0) {
                    if(map.get(j).size() > largest.size()) {
                        largest = map.get(j);
                    }
                }
            }

            current.add(nums[i]);
            current.addAll(largest);
            if(res.size() < current.size()) res = current;
        }

        return res;
    }


    /*
    Using Graph based approach
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, List<Integer>> dMap = getDivisibilityMap(nums);
        Set<Integer> largestSubset = new HashSet<>();

        for (int current : nums) {
            Set<Integer> currentSubset = new HashSet<>();
            currentSubsetMax = new HashSet<>();
            currentSubset.add(current);
            checkRecursive(current, dMap, currentSubset);
            if (currentSubsetMax.size() > largestSubset.size()) {
                largestSubset = new HashSet<>(currentSubsetMax);
            }
        }

        return new ArrayList<>(largestSubset);
    }

    Set<Integer> currentSubsetMax;

    private void checkRecursive(int current, HashMap<Integer, List<Integer>> dMap, Set<Integer> currentSubset) {
        if (currentSubset.size() > currentSubsetMax.size()) {
            currentSubsetMax = new HashSet<>(currentSubset);
        }

        if (dMap.containsKey(current)) {
            List<Integer> children = dMap.get(current);

            for (Integer child : children) {
                currentSubset.add(child);
                checkRecursive(child, dMap, currentSubset);
                currentSubset.remove((int) child);
            }
        }
    }

    private HashMap<Integer, List<Integer>> getDivisibilityMap(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list;
            if (map.containsKey(nums[i])) list = map.get(nums[i]);
            else list = new ArrayList<>();

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0) {
                    list.add(nums[j]);
                    map.put(nums[i], list);

                }
            }
        }

        return map;
    }
}
