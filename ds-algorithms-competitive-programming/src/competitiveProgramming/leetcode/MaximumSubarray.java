package competitiveProgramming.leetcode;

//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, -2, 0};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        boolean positivePresent = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positivePresent = true;
            }
        }

        if (positivePresent) {
            for (int i = 0; i < nums.length; i++) {
                maxEndingHere = maxEndingHere + nums[i];
                if (maxEndingHere < 0) {
                    maxEndingHere = 0;
                }
                if (maxEndingHere > maxSoFar) {
                    maxSoFar = maxEndingHere;
                }
            }
        } else {
            for (int anArr : nums)
                if (maxSoFar < anArr)
                    maxSoFar = anArr;
        }

        return maxSoFar;
    }
}
