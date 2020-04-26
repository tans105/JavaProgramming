package competitiveProgramming.leetcode;

import java.util.*;

/*
https://leetcode.com/problems/4sum/

18. 4Sum
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class FourSum {
    public static void main(String[] args) {
        int[] arr;
        int target;

//        arr = new int[]{1, 0, -1, 0, -2, 2};
//        target = 0;
//        System.out.println(fourSum(arr, target));
//
//        arr = new int[]{0, 0, 0};
//        target = 0;
//        System.out.println(fourSum(arr, target));
//
//        arr = new int[]{-3, -1, 0, 2, 4, 5};
//        target = 0;
//        System.out.println(fourSum(arr, target));
//
//        arr = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
//        target = 0;
//        System.out.println(fourSum(arr, target));

//        arr = new int[]{-3, -1, 0, 2, 4, 5};
//        target = 0;
//        System.out.println(fourSum(arr, target));

        arr = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        target = 0;
        System.out.println(fourSum(arr, target));

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fourSum = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return fourSum;
        }

        List<Pair> pairWiseSum = generateTwoSumFromArray(nums);
        Collections.sort(pairWiseSum);

        int i = 0;
        int j = pairWiseSum.size() - 1;

        while (i < j) {
            Pair low = pairWiseSum.get(i);
            Pair high = pairWiseSum.get(j);

            int sum = low.value + high.value;
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                if (low.j != high.i && low.j != high.j && low.i != high.j && low.i != high.i) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[low.i]);
                    temp.add(nums[low.j]);
                    temp.add(nums[high.i]);
                    temp.add(nums[high.j]);
                    if (isPresent(fourSum, temp)) fourSum.add(temp);
                }
            }
        }

        return fourSum;
    }

    private static boolean isPresent(List<List<Integer>> fourSum, List<Integer> temp) {
        for (List<Integer> sum : fourSum) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (sum.contains(temp.get(i))) {
                    count++;
                }
                if (count == 4) return false;
            }
        }
        return true;
    }

    private static List<Pair> generateTwoSumFromArray(int[] arr) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                list.add(new Pair(i, j, arr[i] + arr[j]));
            }
        }
        return list;
    }

    static class Pair implements Comparable<Object> {
        public int i;
        public int j;
        public int value;

        Pair(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            Pair p = (Pair) o;
            return this.value > p.value ? 1 : -1;
        }

        public String toString() {
            return "[" + i + "][" + j + "]-" + value;
        }
    }
}
