package competitiveProgramming.leetcode;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
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
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
//        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
//        q.left = new TreeNode(3);
        System.out.println(isSameTree(p, q));
        System.out.println(isSameTree2(p, q));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList = new ArrayList<>();
        traverseList(p, pList);

        List<Integer> qList = new ArrayList<>();
        traverseList(q, qList);

        return pList.equals(qList);
    }

    private static void traverseList(TreeNode treeNode, List<Integer> pList) {
        if (treeNode == null) {
            pList.add(null);
            return;
        }

        pList.add(treeNode.val);
        traverseList(treeNode.left, pList);
        traverseList(treeNode.right, pList);
    }

    private static boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        } else {
            return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
        }
    }
}
