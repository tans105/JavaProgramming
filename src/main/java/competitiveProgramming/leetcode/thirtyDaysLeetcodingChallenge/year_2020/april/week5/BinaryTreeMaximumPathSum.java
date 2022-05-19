package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.april.week5;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
Binary Tree Maximum Path Sum
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum sum = new BinaryTreeMaximumPathSum();
        TreeNode node;

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3});
        System.out.println(sum.maxPathSum(node));

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{-10, 9, 20, null, null, 15, 7});
        System.out.println(sum.maxPathSum(node));

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{-3});
        System.out.println(sum.maxPathSum(node));

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{2, -1});
        System.out.println(sum.maxPathSum(node));

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, -2, 3});
        System.out.println(sum.maxPathSum(node));

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, -2, -3, 1, 3, -2, null, -1});
        System.out.println(sum.maxPathSum(node));
    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        backtrack(root);
        return max;
    }

    int max = Integer.MIN_VALUE;

    private int backtrack(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = backtrack(root.left);
        int right = backtrack(root.right);
        max = Math.max(max, Math.max(right, left));       //pick left branch or right branch
        max = Math.max(max, root.val);                   //pick root
        max = Math.max(max, root.val + Math.max(0, left) + Math.max(0, right)); // pick root + MAX(0,left) + MAX(0,right)
        return root.val + Math.max(0, Math.max(left, right));
    }

}
