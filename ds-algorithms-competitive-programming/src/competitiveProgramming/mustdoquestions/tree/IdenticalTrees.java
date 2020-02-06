package competitiveProgramming.mustdoquestions.tree;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/

Write Code to Determine if Two Trees are Identical

Two trees are identical when they have same data and arrangement of data is also same.
To identify if two trees are identical, we need to traverse both trees simultaneously, and while traversing we need to compare data and children of the trees.
 */
public class IdenticalTrees {
    public static void main(String[] args) {
        TreeNode n1 = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, null, 3, null, 10});
        TreeNode n2 = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, null, 3, null, 10});

        System.out.println(checkIdentical(n1, n2));
    }

    private static boolean checkIdentical(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.val != n2.val) {
            return false;
        } else {
            return checkIdentical(n1.left, n2.left) && checkIdentical(n1.right, n2.right);
        }

    }
}
