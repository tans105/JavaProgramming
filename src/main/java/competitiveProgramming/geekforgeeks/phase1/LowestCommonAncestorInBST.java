package competitiveProgramming.geekforgeeks.phase1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/

Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA). You may assume that both the values exist in the tree.
BST_LCA

Following is definition of LCA from Wikipedia:
Let T be a rooted tree.
The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).

The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root. Computation of lowest common ancestors may be useful, for instance, as part of a procedure for determining the distance between pairs of nodes in a tree: the distance from n1 to n2 can be computed as the distance from the root to n1, plus the distance from the root to n2, minus twice the distance from the root to their lowest common ancestor.
 */
public class LowestCommonAncestorInBST {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.generateBinaryTreeFromArray(new Integer[]{20, 8, 22, 4, 12, null, null, null, null, 10, 14});
        System.out.println(getLCA(root, 4, 14));
    }

    private static int getLCA(TreeNode root, int first, int second) {
        int value = root.val;
        if (first > value && second > value) {
            return getLCA(root.right, first, second);
        } else if (first < value && second < value) {
            return getLCA(root.left, first, second);
        } else {
            return value;
        }
    }
}
