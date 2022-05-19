package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.august.week2;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.*;

/*
Path Sum III
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
public class PathSumIII {
    public static void main(String[] args) {
        PathSumIII sum = new PathSumIII();
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        System.out.println(sum.pathSum(node, 8));
    }

    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        Set<Integer> sums = new HashSet<>();
        explore(root, sums, sum, 0);
        return count;
    }

    private void explore(TreeNode node, Set<Integer> sums, int target, int currentSum) {
        if (node == null) return;

        currentSum += node.val;

        if (sums.contains(currentSum - target)) {
            count++;
        }

        sums.add(currentSum);

        explore(node.left, sums, target, currentSum);
        explore(node.right, sums, target, currentSum);
    }

    private static int countSumK(List<Integer> path, Set<Integer> sums, int target) {
        int count = 0;
        int sum = 0;

        for (Integer num : path) {
            sum += num;
            if (sums.contains(sum - target)) {
                count++;
            }
            sums.add(sum);
        }

        return count;
    }
}
