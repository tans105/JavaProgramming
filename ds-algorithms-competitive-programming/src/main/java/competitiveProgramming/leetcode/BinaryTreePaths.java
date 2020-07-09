package competitiveProgramming.leetcode;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
257. Binary Tree Paths

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        System.out.println(binaryTreePaths(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, null, 5, null, null})));
    }

    public static ArrayList<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> result = new ArrayList<>();
        binaryTreePathsHelper(result, "", root);
        return result;
    }

    private static void binaryTreePathsHelper(ArrayList<String> result, String str, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            str += root.val;
            result.add(str);
        } else {
            str += root.val + "->";
            binaryTreePathsHelper(result, str, root.left);
            binaryTreePathsHelper(result, str, root.right);
        }
    }
}
