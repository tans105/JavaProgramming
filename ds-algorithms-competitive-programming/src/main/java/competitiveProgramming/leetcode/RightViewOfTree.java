package competitiveProgramming.leetcode;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;


/*
199. Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 */

public class RightViewOfTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1,2,3,null,5,null,4});
        System.out.println(traverseLevelOrder(node));
    }

    private static List<Integer> traverseLevelOrder(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        int height = TreeUtils.getHeight(node);
        for (int i = 0; i < height; i++) {
            ArrayList<Integer> levelItems = new ArrayList<>();
            printGivenLevel(node, i, levelItems);
            list.add(levelItems.get(levelItems.size() - 1));
        }
        return list;
    }

    private static void printGivenLevel(TreeNode node, int level, ArrayList<Integer> levelItems) {
        if (node == null) return;

        if (level == 0) {
            levelItems.add(node.val);
        }

        printGivenLevel(node.left, level - 1, levelItems);
        printGivenLevel(node.right, level - 1, levelItems);
    }
}
