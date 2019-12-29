package competitiveProgramming.geekforgeeks;

import utils.TreeUtils;
import utils.pojo.TreeNode;
/*
https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”
 */


public class BoundaryTraversalOfTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{20, 8, 22, 4, 12, null, 25, null, null, 10, 14, null, null});
        boundaryTraversal(node);
    }

    private static void boundaryTraversal(TreeNode node) {
        printLeftBoundary(node);
        printLeafNodes(node);
        printRightBoundary(node);
    }

    private static void printLeftBoundary(TreeNode node) {
        if (node == null) return;

        if (node.left != null) {
            System.out.print(node.val + "\t");
            printLeftBoundary(node.left);
        } else if (node.right != null) {
            System.out.print(node.val + "\t");
            printLeftBoundary(node.right);
        }
    }

    private static void printRightBoundary(TreeNode node) {
        if (node == null) return;

        if (node.right != null) {
            printRightBoundary(node.right);
            System.out.print(node.val + "\t");
        } else if (node.left != null) {
            printRightBoundary(node.left);
            System.out.print(node.val + "\t");
        }
    }

    private static void printLeafNodes(TreeNode node) {
        if (node == null) {
            return;
        }

        printLeafNodes(node.left);

        if (node.left == null && node.right == null) {
            System.out.print(node.val + "\t");
        }

        printLeafNodes(node.right);
    }
}
