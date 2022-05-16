package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;
import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.Arrays;

/*
108. Convert Sorted Array to Binary Search Tree

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.parseArray("[-10,-3,0,5,9]");
        TreeUtils.inorderTraversal(sortedArrayToBST(arr));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return generateTree(0, nums.length - 1, nums);
    }

    private static TreeNode generateTree(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = generateTree(start, mid - 1, nums);
        node.right = generateTree(mid + 1, end, nums);
        return node;
    }
}
