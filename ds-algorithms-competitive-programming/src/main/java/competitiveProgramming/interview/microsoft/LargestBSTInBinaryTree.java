package competitiveProgramming.interview.Microsoft;

/*
Exp: https://www.geeksforgeeks.org/microsoft-interview-experience-3-yrs-experienced/

https://www.geeksforgeeks.org/largest-bst-binary-tree-set-2/

Largest BST in a Binary Tree | Set 2
Last Updated: 27-06-2019
Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size of the whole tree.
Examples:

Input:
      5
    /  \
   2    4
 /  \
1    3

Output: 3
The following subtree is the
maximum size BST subtree
   2
 /  \
1    3


Input:
       50
     /    \
  30       60
 /  \     /  \
5   20   45    70
              /  \
            65    80
Output: 5
The following subtree is the
maximum size BST subtree
      60
     /  \
   45    70
        /  \
      65    80
 */

import utils.TreeUtils;
import utils.pojo.TreeNode;

public class LargestBSTInBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{50, 30, 60, 5, 20, 45, 70, null, null, null, null, null, null, 65, 80});
        System.out.println(lengthOfLargestBST(node));
    }

    private static int lengthOfLargestBST(TreeNode node) {
        Meta meta = helper(node);
        return meta.count;
    }

    private static Meta helper(TreeNode node) {
        if (node == null) {
            return new Meta(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Meta left = helper(node.left);
        Meta right = helper(node.right);

        if (left.isValid && right.isValid && node.val > left.maxLeft && node.val < right.minRight) {
            return new Meta(true, left.count + right.count + 1, node.val, node.val);
        } else {
            return new Meta(false, Math.max(left.count, right.count), 0, 0);
        }
    }

    private static class Meta {
        boolean isValid;
        int maxLeft;
        int minRight;
        int count;

        public Meta(boolean isValid, int count, int maxLeft, int minRight) {
            this.maxLeft = maxLeft;
            this.minRight = minRight;
            this.isValid = isValid;
            this.count = count;
        }
    }
}
