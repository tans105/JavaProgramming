package competitiveProgramming.leetcode;

import com.sun.source.tree.Tree;
import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.*;

/*
https://leetcode.com/problems/binary-tree-postorder-traversal/

145. Binary Tree Postorder Traversal

Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Input:


          20
        /    \
      8       22
    /   \      \
  5      3      25
        / \
      10    14

Output: [5, 10, 14, 3, 8, 25, 22, 20]

Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class IterativePostOrderTraversal {
    public static void main(String[] args) {
        System.out.println(postorderTraversal(TreeUtils.getTemplateTree()));
        System.out.println(postorderTraversal2(TreeUtils.getTemplateTree()));
    }

    // Solution 1 (Using 2 Stacks)
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> traverse = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);

            if(current.left != null) {
                stack1.push(current.left);
            }

            if(current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) traverse.add(stack2.pop().val);

        return traverse;
    }

    //Solution 2 - My approach (Using 1 stack)
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traverse = new ArrayList<>();
        Set<Integer> seenNodes = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();

            if (current.left == null && current.right == null) {
                stack.pop();
                traverse.add(current.val);
                seenNodes.add(current.val);
                continue;
            }

            if (current.left != null && !seenNodes.contains(current.left.val)) {
                current = current.left;
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                continue;
            }

            if (current.right != null && !seenNodes.contains(current.right.val)) {
                current = current.right;
                stack.add(current);
                continue;
            }

            traverse.add(current.val);
            seenNodes.add(current.val);
            stack.pop();
        }


        return traverse;
    }
}
