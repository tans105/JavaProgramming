package competitiveProgramming.geekforgeeks.mustdoquestions.tree;


import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]


Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


Note:

All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
 */
public class LowestCommonAncesterBinaryTree {

    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        System.out.println(lowestCommonAncestor(node, p, q));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        return lowestCommonAncestorHelper(root, p.val, q.val);
    }

    private static TreeNode lowestCommonAncestorHelper(TreeNode node, int p, int q) {
        if(node == null) return null;

        if (node.val == p || node.val == q) return node;

        TreeNode leftLCA = lowestCommonAncestorHelper(node.left, p, q);
        TreeNode rightLCA = lowestCommonAncestorHelper(node.right, p, q);

        if (leftLCA != null && rightLCA != null) return node;

        return leftLCA != null ? leftLCA : rightLCA;
    }
}
