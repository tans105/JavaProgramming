package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.june.week1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
Invert Binary Tree
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeUtils.levelOrderTraversalWithQueue(invertTree(node));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode invRoot = new TreeNode(root.val);
        invertTree(root, invRoot);
        return invRoot;
    }

    private static void invertTree(TreeNode orig, TreeNode inv) {
        if (orig == null) return;

        if (orig.left != null) {
            inv.right = new TreeNode(orig.left.val);
            invertTree(orig.left, inv.right);
        }


        if (orig.right != null) {
            inv.left = new TreeNode(orig.right.val);
            invertTree(orig.right, inv.left);
        }

    }
}
