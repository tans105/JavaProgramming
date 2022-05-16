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

enum Index {
    UNKNOWN,
    GOOD,
    BAD
}

public class JumpGame {
    private static Index[] memo;

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
    private static boolean canJumpRecursive(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        return canJumpHelper(nums, 0);
    }

    private static boolean canJumpHelper(int[] nums, int position) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }

        int farthestPossible = Math.min(position + nums[position], nums.length - 1);
        for (int i = farthestPossible; i >= position + 1; i--) {
            if (canJumpHelper(nums, i)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }

    /**
     * Greedy approach
     *
     * @param nums
     * @return
     */
    private static boolean canJumpGreedy(int[] nums) {
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
