package competitiveProgramming.leetcode;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
113. Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class PathSumII {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        System.out.println(pathSum(node, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        pathSumHelper(root, 0, sum, temp, finalList);
        return finalList;
    }

    private static void pathSumHelper(TreeNode root, int currentSum, int sum, List<Integer> temp, List<List<Integer>> finalList) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (currentSum + root.val == sum) {
                finalList.add(new ArrayList<>(temp));
            }
        }

        pathSumHelper(root.left, currentSum + root.val, sum, new ArrayList<>(temp), finalList);
        pathSumHelper(root.right, currentSum + root.val, sum, new ArrayList<>(temp), finalList);
    }
}
