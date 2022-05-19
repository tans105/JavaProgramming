package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.april.week2;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3293/

Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(diameterOfBinaryTree(node));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int dia = lHeight + rHeight;

        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);

        return Math.max(dia, Math.max(lDiameter, rDiameter));
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
