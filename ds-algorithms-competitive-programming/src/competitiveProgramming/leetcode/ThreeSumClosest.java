package competitiveProgramming.leetcode;

import Utils.LoggingUtil;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    /*
        Given array nums = [-1, 2, 1, -4], and target = 1.
        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    */
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MIN_VALUE;
        int diff;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    diff = target - (nums[i] + nums[j] + nums[k]);
                    if (Math.abs(diff) < Math.abs(minDiff)) {
                        minDiff = diff;
                        closestSum = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return closestSum;
    }
}
