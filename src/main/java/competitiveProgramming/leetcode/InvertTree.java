package competitiveProgramming.leetcode;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
226. Invert Binary Tree

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
 */
public class InvertTree {
    public static void main(String[] args) {
        InvertTree inv = new InvertTree();
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        TreeUtils.inorderTraversal(inv.invertTree(node));
    }

    public TreeNode invertTree(TreeNode root) {
        return invertTreeHelper(root);
    }

    private TreeNode invertTreeHelper(TreeNode root) {
        if (root == null) return null;

        TreeNode node = new TreeNode(root.val);
        node.left = invertTreeHelper(root.right);
        node.right = invertTreeHelper(root.left);

        return node;
    }


}
