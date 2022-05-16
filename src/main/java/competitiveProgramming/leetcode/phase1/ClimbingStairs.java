package competitiveProgramming.leetcode.phase1;

import java.util.ArrayList;
import java.util.List;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        climbStairsHelper(list, temp, n);
        System.out.println(list);
        return list.size();
    }

    private static void climbStairsHelper(List<List<Integer>> list, List<Integer> temp, int n) {
        int sum = 0;
        for (Integer i : temp) {
            sum += i;
        }

        if (sum == n) {
            list.add(new ArrayList<>(temp));
        }
        if (sum > n) {
            return;
        }

        for (int i = 1; i < 3; i++) {
            temp.add(i);
            climbStairsHelper(list, temp, n);
            temp.remove(temp.size() - 1);
        }
    }


    /**
     * Solution leet
     * @param i
     * @param n
     * @return
     */
    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}
