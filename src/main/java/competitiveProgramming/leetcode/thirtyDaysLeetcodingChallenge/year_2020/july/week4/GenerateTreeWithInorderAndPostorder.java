package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.july.week4;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7


 */
public class GenerateTreeWithInorderAndPostorder {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.getTemplateTree();
        /*
                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14

                  Inorder : 5, 8, 10, 3, 14, 20, 22, 25
                  Postorder: 5, 10, 14, 3, 8, 25, 22, 20
         */

        System.out.println(buildTree(new int[]{5, 8, 10, 3, 14, 20, 22, 25}, new int[]{5, 10, 14, 3, 8, 25, 22, 20}));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart) {
        if (postStart < 0 || inStart < inEnd)
            return null;

        //The last element in postorder is the root.
        TreeNode root = new TreeNode(postorder[postStart]);

        //find the index of the root from inorder. Iterating from the end.
        int rIndex = inStart;
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == postorder[postStart]) {
                rIndex = i;
                break;
            }
        }
        //build right and left subtrees. Again, scanning from the end to find the sections.
        root.right = buildTree(inorder, inStart, rIndex + 1, postorder, postStart - 1);
        root.left = buildTree(inorder, rIndex - 1, inEnd, postorder, postStart - (inStart - rIndex) - 1);
        return root;
    }


}
