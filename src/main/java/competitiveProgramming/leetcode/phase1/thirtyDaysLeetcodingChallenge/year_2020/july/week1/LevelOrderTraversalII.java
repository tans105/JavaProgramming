package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.july.week1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.*;

/*
Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]

 */
public class LevelOrderTraversalII {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(levelOrderBottom(node));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new ArrayList<>();

        if(root == null) return levels;

        levels.add(Collections.singletonList(root.val));
        queue.offer(root);
        queue.offer(null);


        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                if (queue.size() > 0) {
                    queue.offer(null);
                    levels.add(level);
                    level = new ArrayList<>();
                    continue;
                } else {
                    break;
                }
            }

            if (current.left != null) {
                level.add(current.left.val);
                queue.offer(current.left);
            }
            if (current.right != null) {
                level.add(current.right.val);
                queue.offer(current.right);
            }
        }

        Collections.reverse(levels);
        return levels;
    }
}
