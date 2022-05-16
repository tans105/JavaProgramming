package competitiveProgramming.leetcode;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4});
        System.out.println(isBalanced(node));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = TreeUtils.getHeight(root.left);
        int rightHeight = TreeUtils.getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

}
