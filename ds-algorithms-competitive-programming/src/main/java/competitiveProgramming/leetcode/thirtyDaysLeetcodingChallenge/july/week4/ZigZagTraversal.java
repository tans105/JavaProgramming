package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.july.week4;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.*;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3398/

Binary Tree Zigzag Level Order Traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]

 */
public class ZigZagTraversal {
    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(TreeUtils.generateBinaryTreeFromArray(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(zigzagLevelOrder(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, 4, null, null, 5})));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        int height = getHeight(root);

        for (int i = 0; i < height; i++) {
            getCurrentLevel(i, root, level);
            tree.add(new ArrayList<>(level));
            level = new ArrayList<>();
        }

        return tree;
    }

    private static void getCurrentLevel(int i, TreeNode root, List<Integer> level) {
        if (root == null) return;
        if (i == 0) {
            level.add(root.val);
        }

        if (i % 2 == 0) {
            getCurrentLevel(i - 1, root.left, level);
            getCurrentLevel(i - 1, root.right, level);
        } else {
            getCurrentLevel(i - 1, root.right, level);
            getCurrentLevel(i - 1, root.left, level);
        }
    }

    public static int getHeight(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
