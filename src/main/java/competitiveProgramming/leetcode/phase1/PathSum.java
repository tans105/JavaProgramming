package competitiveProgramming.leetcode.phase1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
112. Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{5, 4, 8, 11, 13, 4, 7, 2, 1});
        System.out.println(hasPathSum(node, 23));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        return pathSumHelper(root, 0, sum);
    }

    public static boolean pathSumHelper(TreeNode root, int sumSoFar, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (sumSoFar + root.val == sum) {
                return true;
            }
        }

        return pathSumHelper(root.left, sumSoFar + root.val, sum) || pathSumHelper(root.right, sumSoFar + root.val, sum);
    }
}
