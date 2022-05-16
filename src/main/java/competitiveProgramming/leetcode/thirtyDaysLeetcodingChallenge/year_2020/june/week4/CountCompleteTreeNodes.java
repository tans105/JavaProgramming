package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.june.week4;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3369/

Count Complete Tree Nodes

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
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(countNodes(node));
    }

    public static int countNodes(TreeNode root) {
        TreeNode lNode = root, rNode = root;
        int lHeight = 0, rHeight = 0;

        while (lNode != null) {
            lHeight++;
            lNode = lNode.left;
        }

        while (rNode != null) {
            rHeight++;
            rNode = rNode.right;
        }

        if (lHeight == rHeight) { // check if it is perfect tree. No. of nodes of a perfect tree is 2^h - 1
            return (int) Math.pow(2, lHeight) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1; //usual way of calculating the number of nodes
    }
}
