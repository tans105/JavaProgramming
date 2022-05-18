package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.october.week1;

import java.util.*;

/*
 K-diff Pairs in an Array

Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

0 <= i, j < nums.length
i != j
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.



Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:

Input: nums = [1,2,3,4,5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:

Input: nums = [1,3,1,5,4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Example 4:

Input: nums = [1,2,4,4,3,3,0,9,2,3], k = 3
Output: 2
Example 5:

Input: nums = [-1,-2,-3], k = 1
Output: 2


Constraints:

1 <= nums.length <= 104
-107 <= nums[i] <= 107
0 <= k <= 107
 */
public class KDiffPairInArray {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 0));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 1}, 0));
    }

    public static int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int num : nums) {
            set.add(num);
            int c = map.getOrDefault(num, 0);
            map.put(num, c + 1);
        }

        if (k == 0) {
            for (Integer num : set) {
                if (map.get(num) > 1) count++;
            }
        } else {
            for (Integer num : set) {
                if (set.contains(num - k)) count++;
            }
        }

        return count;
    }
}
