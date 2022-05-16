package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;

import java.util.Arrays;

/*
https://leetcode.com/problems/jump-game-ii/

45. Jump Game II

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.
 */
public class JumpGameII {
    public static void main(String[] args) {
        System.out.println("--------------------------------");
        int[] arr = ArrayUtils.parseArray("[2,3,1,1,4]");
        System.out.println("Jumps: " + jump(arr));
        System.out.println("--------------------------------");

        arr = ArrayUtils.parseArray("[2,3,1,1,2,4,2,0,1,1]");
        System.out.println("Jumps: " + jump(arr));
        System.out.println("--------------------------------");
    }

    public static int jump(int[] nums) {
        Integer[] minJump = new Integer[nums.length];
        Integer[] bestPossiblePrevIndex = new Integer[nums.length];

        Arrays.fill(minJump, nums.length);
        Arrays.fill(bestPossiblePrevIndex, -1);
        minJump[0] = 0;
        bestPossiblePrevIndex[0] = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    minJump[i] = Math.min(minJump[j] + 1, minJump[i]);

                    if (bestPossiblePrevIndex[i] == -1) {
                        bestPossiblePrevIndex[i] = j;
                    }
                    if (minJump[j] + 1 < minJump[i]) {
                        bestPossiblePrevIndex[i] = j;
                    }
                }
            }
        }
        getBestPath(bestPossiblePrevIndex); //optional if you want to know path

        return minJump[nums.length - 1];
    }

    private static void getBestPath(Integer[] bestPossiblePrevIndex) {
        int index = bestPossiblePrevIndex.length - 1;
        System.out.print("Path->\t" + (bestPossiblePrevIndex.length - 1) + "\t");
        while (bestPossiblePrevIndex[index] != -1) {
            System.out.print(bestPossiblePrevIndex[index] + "\t");
            index = bestPossiblePrevIndex[index];
        }
        System.out.println();
    }
}
