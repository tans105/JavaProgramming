package competitiveProgramming.mustdoquestions.tree;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

Diameter of Binary Tree

The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 */
public class DiameterBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{10, 2, 10, 20, 1, null, -25, null, null, null, null, 3, 4});
        System.out.println(diameter(node));
    }

    private static int diameter(TreeNode node) {
        if (node == null) return 0;

        int lHeight = TreeUtils.getHeight(node.left);
        int rHeight = TreeUtils.getHeight(node.right);
        int lDiameter = diameter(node.left);
        int rDiameter = diameter(node.right);

        return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));

    }
}
