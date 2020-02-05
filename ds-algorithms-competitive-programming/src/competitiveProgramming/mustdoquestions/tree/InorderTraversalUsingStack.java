package competitiveProgramming.mustdoquestions.tree;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/

             1
          /   \
        2      3
      /  \
    4     5

 */
public class InorderTraversalUsingStack {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{10, 12, 15, 25, 30, 36, null});
        inorderTraversalWithoutRecursion(node);
    }

    private static void inorderTraversalWithoutRecursion(TreeNode n) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Node current = null;
        Node prev = null;
        Node head = null;


        while (n != null) {
            stack.push(n);
            n = n.left;
        }
        while (!stack.isEmpty()) {
            n = stack.pop();
            System.out.println(n.val);

            current = new Node(n.val);

            if (prev != null) {
                current.left = prev;
                prev.right = current;
            } else {
                head = current;
            }

            prev = current;


            if (n.right != null) {
                n = n.right;
                while (n != null) {
                    stack.push(n);
                    n = n.left;
                }
            }
        }

        System.out.println(head);
    }


    static class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", val=" + val +
                    '}';
        }
    }


    static void traverse(Node n) {
        while (n != null) {
            System.out.println(n);
            n = n.right;
        }
    }
}
