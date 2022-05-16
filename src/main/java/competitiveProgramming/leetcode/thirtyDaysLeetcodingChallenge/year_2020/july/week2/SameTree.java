package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.july.week2;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3389/

Same Tree

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true

Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false

Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false


 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode p;
        TreeNode q;

        p = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3});
        q = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3});
        System.out.println(isSameTree(p, q));

        p = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2});
        q = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, null, 2});
        System.out.println(isSameTree(p, q));

        p = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 1});
        q = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 1, 2});
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }
}
