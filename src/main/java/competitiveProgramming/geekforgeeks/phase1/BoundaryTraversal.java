package competitiveProgramming.geekforgeeks.phase1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

Boundary Traversal of binary tree
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root. For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”
 */
public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{20, 8, 22, 4, 12, null, 25, null, null, 10, 14, null, null});
        TreeUtils.inorderTraversal(node);
        boundaryTraversal(node);
    }

    private static void boundaryTraversal(TreeNode node) {
        List<Integer> traversedLeaves = new ArrayList<>();
        System.out.println();
        printLeftChild(node, traversedLeaves);
        printLeaves(node, traversedLeaves);
        printRightChild(node, traversedLeaves);
    }

    private static void printRightChild(TreeNode node, List<Integer> traversedLeaves) {
        if (node == null) {
            return;
        }

        if (!traversedLeaves.contains(node.val)) {
            System.out.print(node.val + "\t");
            traversedLeaves.add(node.val);
        }

        printRightChild(node.right, traversedLeaves);
    }

    private static void printLeaves(TreeNode node, List<Integer> traversedLeaves) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null && !traversedLeaves.contains(node.val)) {
            System.out.print(node.val + "\t");
            traversedLeaves.add(node.val);
        }

        printLeaves(node.left, traversedLeaves);
        printLeaves(node.right, traversedLeaves);
    }

    private static void printLeftChild(TreeNode node, List<Integer> traversedLeaves) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + "\t");
        traversedLeaves.add(node.val);
        printLeftChild(node.left, traversedLeaves);
    }
}
