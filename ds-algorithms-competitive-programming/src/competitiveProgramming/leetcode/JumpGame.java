package competitiveProgramming.leetcode;

//https://leetcode.com/problems/jump-game
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        return canJumpHelper(nums, 0);
    }

    public static boolean canJumpHelper(int[] nums, int position) {
        if (position == nums.length - 1) {
            return true;
        }

        int farthestPossible = Math.min(position + nums[position], nums.length - 1);
        for (int i = position + 1; i <= farthestPossible; i++) {
            if (canJumpHelper(nums, i)) {
                return true;
            }
        }

        return false;
    }
}
