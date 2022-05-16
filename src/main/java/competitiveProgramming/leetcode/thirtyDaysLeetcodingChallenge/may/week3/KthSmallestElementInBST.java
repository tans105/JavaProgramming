package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week3;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Kth Smallest Element in a BST

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 */
public class KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{3, 1, 4, null, 2});
        System.out.println(kthSmallest(node, 1));
        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        System.out.println(kthSmallest(node, 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = new ArrayList<>();
        inorderTraverse(root, nodes);
        return nodes.get(k - 1);
    }

    private static void inorderTraverse(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left, nodes);
        nodes.add(root.val);
        inorderTraverse(root.right, nodes);
    }
}
