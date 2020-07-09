package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.july.week2;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3385/

Maximum Width of Binary Tree

Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:

Input:

          1
         /
        3
       / \
      5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:

Input:

          1
         / \
        3   2
       /
      5

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).

Example 4:

Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).



 */
public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        MaximumWidthOfBinaryTree m = new MaximumWidthOfBinaryTree();
        System.out.println(m.widthOfBinaryTree(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 3, 2, 5, 3, null, 9})));
        System.out.println(m.widthOfBinaryTree(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 3, 2, 5})));
        System.out.println(m.widthOfBinaryTree(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 1, 1, 1, null, null, 1, 1, null, null, 1})));
        System.out.println(m.widthOfBinaryTree(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 1, 1, 1, 1, 1, 1, null, null, null, 1, null, null, null, null, 2, 2, 2, 2, 2, 2, 2, null, 2, null, null, 2, null, 2})));

    }

    public int widthOfBinaryTree(TreeNode root) {
        int height = getHeight(root);
        List<Map<String, Integer>> levelWise = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put("min", Integer.MAX_VALUE);
            map.put("max", Integer.MIN_VALUE);
            levelWise.add(map);
        }

        int width = 0;
        widthOfBinaryTreeHelper(root, 0, 0, levelWise);

        System.out.println(levelWise);
        for (Map<String, Integer> level : levelWise) {
            width = Math.max(width, level.get("max") - level.get("min"));
        }

        return width + 1;
    }

    private void widthOfBinaryTreeHelper(TreeNode root, int dist, int level, List<Map<String, Integer>> levelWise) {
        if (root == null) return;

        Map<String, Integer> levelData = levelWise.get(level);
        int currMin = levelData.get("min");
        int currMax = levelData.get("max");

        currMin = Math.min(dist, currMin);
        currMax = Math.max(dist, currMax);
        levelData.put("min", currMin);
        levelData.put("max", currMax);

        levelWise.set(level, levelData);

        if (root.right != null) {
            widthOfBinaryTreeHelper(root.right, 2 * dist + 1, level + 1, levelWise);
        }

        if (root.left != null) {
            widthOfBinaryTreeHelper(root.left, 2 * dist, level + 1, levelWise);
        }
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }
}
