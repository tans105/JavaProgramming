package competitiveProgramming.geekforgeeks.phase1;

/*
https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/

Convert a given tree to its Sum Tree
Given a Binary Tree where each node has positive and negative values. Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. The values of leaf nodes are changed to 0.
For example, the following tree

                  10
               /      \
             -2        6
           /   \      /  \
         8     -4    7    5
should be changed to



                 20(4-2+12+6)
               /      \
         4(8-4)      12(7+5)
           /   \      /  \
         0      0    0    0
 */

import utils.TreeUtils;
import utils.pojo.TreeNode;

public class ConvertGivenTreeToItsSumTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{10, -2, 6, 8, -4, 7, 5});
        getTreeSum(node);
        System.out.println(node);
    }

    private static int getTreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getTreeSum(node.left);
        int right = getTreeSum(node.right);
        int temp = node.val;
        node.val = left + right;
        return left + right + temp;
    }
}
