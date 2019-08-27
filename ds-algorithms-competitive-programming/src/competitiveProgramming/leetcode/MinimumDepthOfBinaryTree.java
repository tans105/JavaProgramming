package competitiveProgramming.leetcode;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(minDepth(node));
    }

    public static int minDepth(TreeNode root) {
        minDepthHelper(root, 0);
        return MIN;
    }

    static int MIN = Integer.MAX_VALUE;

    private static void minDepthHelper(TreeNode root, int count) {
        if (root == null) {
            if (count < MIN) MIN = count;
        } else {
            minDepthHelper(root.left, count + 1);
            minDepthHelper(root.right, count + 1);
        }
    }
}
