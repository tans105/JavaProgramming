package competitiveProgramming.leetcode.phase1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 */

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 2, null, 3, null, 3});
        System.out.println(isSymmetric(node));
    }

    public static boolean isSymmetric(TreeNode root) {
        TreeNode t1 = root;
        TreeNode t2 = root;

        boolean isSame = isSymmetricHelper(t1, t2);
        return isSame;
    }

    private static boolean isSymmetricHelper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val == t2.val) {
            return isSymmetricHelper(t1.left, t2.right) && isSymmetricHelper(t1.right, t2.left);
        } else {
            return false;
        }
    }
}
