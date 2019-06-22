package competitiveProgramming.leetcode;

//https://leetcode.com/problems/jump-game


/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJumpRecursive(nums));
        System.out.println(canJumpGreedy(nums));
    }

    /**
     * Recursive approach
     *
     * @param nums
     * @return
     */
    public static boolean canJumpRecursive(int[] nums) {
        return canJumpHelper(nums, 0);
    }

    public static boolean canJumpHelper(int[] nums, int position) {
        if (position == nums.length - 1) {
            return true;
        }

        int farthestPossible = Math.min(position + nums[position], nums.length - 1);
        for (int i = farthestPossible; i >= position + 1; i--) {
            if (canJumpHelper(nums, i)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Greedy approach
     *
     * @param nums
     * @return
     */
    public static boolean canJumpGreedy(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }

        return max >= nums.length - 1;
    }
}
