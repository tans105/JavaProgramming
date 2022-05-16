package competitiveProgramming.leetcode.phase1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
102. Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{3, 9, 20, null, null, 15, 7});
//        System.out.println(levelOrder(node));
//        System.out.println(zigzagLevelOrder(node));
        System.out.println(levelOrderBottom(node));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int height = TreeUtils.getHeight(root);
        for (int i = 0; i < height; i++) {
            list.add(printGivenLevel(root, new ArrayList<Integer>(), i));
        }
        return list;
    }

    private static List<Integer> printGivenLevel(TreeNode node, ArrayList<Integer> levelList, int level) {
        if (node == null) {
            return levelList;
        }
        if (level == 0) {
            levelList.add(node.val);
        }

        printGivenLevel(node.left, levelList, level - 1);
        printGivenLevel(node.right, levelList, level - 1);

        return levelList;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int height = TreeUtils.getHeight(root);
        for (int i = 0; i < height; i++) {
            if (i % 2 == 0) {
                list.add(printGivenLevelZigZag(root, new ArrayList<Integer>(), i, true));
            } else {
                list.add(printGivenLevelZigZag(root, new ArrayList<Integer>(), i, false));
            }

        }
        return list;
    }

    private static List<Integer> printGivenLevelZigZag(TreeNode node, ArrayList<Integer> levelList, int level, boolean flip) {
        if (node == null) {
            return levelList;
        }
        if (level == 0) {
            levelList.add(node.val);
        }
        if (flip) {
            printGivenLevelZigZag(node.left, levelList, level - 1, flip);
            printGivenLevelZigZag(node.right, levelList, level - 1, flip);
        } else {
            printGivenLevelZigZag(node.right, levelList, level - 1, flip);
            printGivenLevelZigZag(node.left, levelList, level - 1, flip);
        }


        return levelList;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int height = TreeUtils.getHeight(root);
        for (int i = 1; i <= height; i++) {
            list.add(printGivenLevelLevelOrderBottom(root, new ArrayList<Integer>(), i, height));
        }
        return list;
    }

    private static List<Integer> printGivenLevelLevelOrderBottom(TreeNode node, ArrayList<Integer> levelList, int level, int height) {
        if (node == null) {
            return levelList;
        }
        if (level == height) {
            levelList.add(node.val);
        }

        printGivenLevelLevelOrderBottom(node.left, levelList, level + 1, height);
        printGivenLevelLevelOrderBottom(node.right, levelList, level + 1, height);

        return levelList;
    }

}
