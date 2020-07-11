package competitiveProgramming.geekforgeeks;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/iterative-preorder-traversal/

Iterative Preorder Traversal

Given a Binary Tree, write an iterative function to print Preorder traversal of the given binary tree.

Refer this for recursive preorder traversal of Binary Tree. To convert an inherently recursive procedures to iterative, we need an explicit stack. Following is a simple stack based iterative process to print Preorder traversal.
1) Create an empty stack nodeStack and push root node to stack.
2) Do following while nodeStack is not empty.
….a) Pop an item from stack and print it.
….b) Push right child of popped item to stack
….c) Push left child of popped item to stack

Right child is pushed before left child to make sure that left subtree is processed first.
 */
public class IterativePreorderTraversal {
    public static void main(String[] args) {
        /*
                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14
         */
        TreeNode node = TreeUtils.getTemplateTree();
        preorder(node);
    }

    private static void preorder(TreeNode node) {
        if (node == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);


        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println(current);

            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }
}
