package competitiveProgramming.mustdoquestions.tree;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
https://practice.geeksforgeeks.org/problems/symmetric-tree/1

Given a Binary Tree of size N, your task is to complete the function isSymettric(), that check whether a binary is Symmetric or not, i.e. the binary tree is Mirror image of itself or not.
For example:
The following binary tree is symmetric:

        1
      /   \
    2       2
  /   \   /   \
 3     4 4     3

But the following is not:

       1
     /   \
    2      2
     \      \
      3      3
Input:

The function takes a single argument as input, the root node of the binary tree. There will be T test cases and for each test case the function will be called separately.


Output:
For each testcase the function should return a boolean value.

Constraints:
1<=T<=100
1<=N<=100

Example:
Input:
3
1 1
1 2 L 1 2 R 0
2 1
10 20 R 10 20 L 20 30 R 5
2 2
10 20 R 10 20 L 10 20 R 10 20 L 20 30 L 100

Output:
True
False
True
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(isSymmetric(node));
        /*
                1
              /   \
            2       2
          /   \   /   \
         3     4 4     3
         */
    }

    private static boolean isSymmetric(TreeNode node) {
        TreeNode n1 = node;
        TreeNode n2 = node;
        return isSymmetricHelper(n1, n2);
    }

    private static boolean isSymmetricHelper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;

        if (n1 == null || n2 == null) return false;

        if (n1.val != n2.val) return false;

        return isSymmetricHelper(n1.left, n2.right) && isSymmetricHelper(n1.right, n2.left);
    }
}
