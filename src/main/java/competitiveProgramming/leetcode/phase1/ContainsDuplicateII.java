package competitiveProgramming.leetcode.phase1;

/*
219. Contains Duplicate II

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */

import java.util.*;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;


        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> l;
            if (indexMap.containsKey(nums[i])) {
                l = indexMap.get(nums[i]);
                l.add(i);
            } else {
                l = new ArrayList<>();
                l.add(i);

            }
            indexMap.put(nums[i], l);
        }

        for (Map.Entry itr : indexMap.entrySet()) {
            List<Integer> l = (List<Integer>) itr.getValue();
            if (l.size() >= 2) {
                int diff;
                for (int i = 0; i < l.size() - 1; i++) {
                    diff = l.get(i + 1) - l.get(i);
                    if (diff <= k) return true;
                }
            }
        }

        return false;
    }
}
