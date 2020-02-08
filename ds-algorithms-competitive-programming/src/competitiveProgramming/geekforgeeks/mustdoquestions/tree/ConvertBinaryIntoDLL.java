package competitiveProgramming.geekforgeeks.mustdoquestions.tree;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/

Convert a given Binary Tree to Doubly Linked List | Set 3
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (left most node in BT) must be head node of the DLL.

 */
public class ConvertBinaryIntoDLL {
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
