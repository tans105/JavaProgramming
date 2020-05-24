package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week4;

import utils.ArrayUtils;
import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/

Construct Binary Search Tree from Preorder Traversal

Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]


Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 10^8
The values of preorder are distinct.
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    static int preIndex = 0;

    public static void main(String[] args) {
        int[] arr;

        arr = ArrayUtils.parseArray("[8,5,1,7,10,12]");
        TreeUtils.levelOrderTraversalWithQueue(bstFromPreorder(arr));
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MAX_VALUE);
    }

    static TreeNode constructBST(int[] preOrder, int val) {
        if (preIndex == preOrder.length || val < preOrder[preIndex])
            return null;
        TreeNode root = new TreeNode(preOrder[preIndex++]);
        root.left = constructBST(preOrder, root.val);
        root.right = constructBST(preOrder, val);
        return root;
    }
}
