package competitiveProgramming.leetcode.topinterviewquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {return result;}

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            int desiredSum = -1 * nums[i];

            if (i == 0 || nums[i] != nums[i - 1]) {
                while (low < high) {
                    if (nums[low] + nums[high] == desiredSum) { // sum matches add the result and iterate till duplicate goes out
                        List<Integer> triplet = Arrays.asList(nums[low], nums[high], nums[i]);
                        result.add(triplet);
                        while (low < high && nums[low] == nums[low + 1]) {low++;}
                        while (low < high && nums[high] == nums[high - 1]) {high--;}
                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] < desiredSum) { // sum is less than desired, increase low
                        while (low < high && nums[low] == nums[low + 1]) {low++;}
                        low++;
                    }
                    else { // sum is less than desired, decrease high
                        while (low < high && nums[high] == nums[high - 1]) {high--;}
                        high--;
                    }
                }
            }
        }

        return result;
    }

}
