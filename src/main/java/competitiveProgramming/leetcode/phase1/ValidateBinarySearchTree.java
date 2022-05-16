package competitiveProgramming.leetcode.phase1;

import utils.LoggingUtil;
import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.Stack;

/*
98. Validate Binary Search Tree
Medium

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{-2147483648};
        TreeNode root = TreeUtils.generateBinaryTreeFromArray(arr);
        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        Integer prev = null;

        while (n != null) {
            if (prev != null && prev <= n.val) {
                return false;
            }
            stack.push(n);
            prev = n.val;
            n = n.left;
        }
        prev = null;
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (prev != null && prev >= current.val) {
                return false;
            }
            if (current.right == null) {
                prev = current.val;
//                System.out.println(current); //uncomment this get inorder traversal
            } else {
                prev = current.val;
//                System.out.println(current); //uncomment this get inorder traversal
                current = current.right;
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }

        return true;
    }
}
