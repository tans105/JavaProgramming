package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.week3;

import utils.ArrayUtils;
import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.Stack;

/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 */
public class ConstructBinarySearchTreeFromPreOrderTraversal {
    public static void main(String[] args) {
        int[] arr;

        arr = ArrayUtils.parseArray("[8,5,1,7,10,12]");
        TreeUtils.levelOrderTraversalWithQueue(bstFromPreorder(arr));
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int counter = 1;

        while (counter < preorder.length) {
            int current = preorder[counter];
            TreeNode currentNode = (!stack.isEmpty()) ? stack.peek() : null;

            if (currentNode != null && currentNode.val > current) { // if current value is less , make it a left child
                currentNode.left = new TreeNode(current);
                stack.push(currentNode.left);
            } else { // if current value is more, pop things till you find a greater node, make it a right child
                while (!stack.isEmpty() && stack.peek().val < current) {
                    currentNode = stack.pop();
                }

                currentNode.right = new TreeNode(current);
                stack.push(currentNode.right);
            }
            counter++;
        }
        return root;
    }
}
