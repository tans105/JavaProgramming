package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.Objects;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/

Cousins in Binary Tree
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.



Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false


Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
 */
public class CousinsInBinaryTree {
    public static void main(String[] args) {
        System.out.println(isCousins(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, 4}), 4, 3));
        System.out.println(isCousins(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, null, 4, null, 5}), 5, 4));
        System.out.println(isCousins(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, null, 4}), 2, 3));
        System.out.println(isCousins(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1,null,2,3,null,null,4,null,5}), 1, 3));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        TreeData xData = getHeight(root, null, x, 0);
        TreeData yData = getHeight(root, null, y, 0);

        return xData.equals(yData);
    }

    private static TreeData getHeight(TreeNode root, TreeNode parent, int val, int heightSoFar) {
        if (root == null) return null;
        if (root.val == val) return (parent != null ) ? new TreeData(heightSoFar, parent.val): new TreeData();

        TreeData data = getHeight(root.left, root, val, heightSoFar + 1);
        if (data != null) {
            return data;
        }

        data = getHeight(root.right, root, val, heightSoFar + 1);
        return data;
    }

    private static class TreeData {
        int height;
        int parent;

        public TreeData(int height, int parent) {
            this.height = height;
            this.parent = parent;
        }

        public TreeData() {
        }

        @Override
        public String toString() {
            return "TreeData{" +
                    "height=" + height +
                    ", parent=" + parent +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeData treeData = (TreeData) o;
            return height == treeData.height &&
                    parent != treeData.parent;
        }

        @Override
        public int hashCode() {
            return Objects.hash(height, parent);
        }
    }
}
