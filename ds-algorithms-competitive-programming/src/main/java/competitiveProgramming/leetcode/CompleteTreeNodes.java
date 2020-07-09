package competitiveProgramming.leetcode;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
222. Count Complete Tree Nodes

Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
 */
public class CompleteTreeNodes {
    public static void main(String[] args) {
        CompleteTreeNodes ctn = new CompleteTreeNodes();
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(ctn.countNodes(node));
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
