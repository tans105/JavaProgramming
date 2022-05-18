package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.october.week1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

public class InsertIntoBST {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{4, 2, 7, 1, 3});
        node = insertIntoBST(node, 5);
        TreeUtils.preorderTraversal(node);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        traverse(root, val);
        return root;
    }

    public static void traverse(TreeNode root, int val) {
        if (root == null) return;

        if (root.left == null && root.right == null) {//leaf
            if (val < root.val) root.left = new TreeNode(val);
            else root.right = new TreeNode(val);
            return;
        }

        if(val > root.val && root.right == null) {
            root.right = new TreeNode(val);
            return;
        }

        if(val < root.val && root.left == null) {
            root.left = new TreeNode(val);
            return;
        }

        if (val > root.val) {
            traverse(root.right, val);
        } else {
            traverse(root.left, val);
        }
    }
}
