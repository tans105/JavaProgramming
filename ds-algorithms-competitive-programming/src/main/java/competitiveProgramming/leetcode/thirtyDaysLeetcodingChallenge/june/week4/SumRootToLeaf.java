package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.june.week4;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3372/

Sum Root to Leaf Numbers
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */
public class SumRootToLeaf {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{4, 9, 0, 5, 1});
        System.out.println(sumNumbers(node));
        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3});
        System.out.println(sumNumbers(node));
        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{0, 1});
        System.out.println(sumNumbers(node));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<String> paths = new ArrayList<>();
        traverseToLeaf(paths, root, "");

        int sum = 0;
        for (String path : paths) {
            sum += Integer.parseInt(path);
        }

        return sum;
    }

    private static void traverseToLeaf(List<String> paths, TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            path += root.val;
            paths.add(path);
            return;
        }

        StringBuilder builder = new StringBuilder(path);
        builder.append(root.val);

        if (root.left != null) traverseToLeaf(paths, root.left, builder.toString());
        if (root.right != null) traverseToLeaf(paths, root.right, builder.toString());
    }
}
