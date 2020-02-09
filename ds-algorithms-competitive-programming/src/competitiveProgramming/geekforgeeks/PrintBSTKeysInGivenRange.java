package competitiveProgramming.geekforgeeks;

/*
https://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/

Print BST keys in the given range

Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Print all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Print all the keys in increasing order.
For example, if k1 = 10 and k2 = 22, then your function should print 12, 20 and 22.
 */

import utils.TreeUtils;
import utils.pojo.TreeNode;

public class PrintBSTKeysInGivenRange {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{20, 8, 22, 4, 12, null, null});
        printNodesInRange(node, 10, 22);
    }

    private static void printNodesInRange(TreeNode node, int min, int max) {
        if (node == null) {
            return;
        }

        if (node.val >= min && node.val <= max) {
            System.out.println(node);
            printNodesInRange(node.left, min, max);
            printNodesInRange(node.right, min, max);
        } else if (node.val < min) {
            printNodesInRange(node.right, min, max);
        } else {
            printNodesInRange(node.left, min, max);
        }
    }
}
