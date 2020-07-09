package competitiveProgramming.geekforgeeks;

import com.sun.source.tree.Tree;
import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
https://www.geeksforgeeks.org/largest-bst-binary-tree-set-2/

Largest BST in a Binary Tree | Set 2
Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size of the whole tree.
Examples:

Input:
      5
    /  \
   2    4
 /  \
1    3

Output: 3
The following subtree is the
maximum size BST subtree
   2
 /  \
1    3


Input:
       50
     /    \
  30       60
 /  \     /  \
5   20   45    70
              /  \
            65    80
Output: 5
The following subtree is the
maximum size BST subtree
      60
     /  \
   45    70
        /  \
      65    80
 */
public class LargestBSTinBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{50, 30, 60, 5, 20, 45, 70, null, null, null, null, null, null, 65, 80});
        System.out.println(largestBST(node));

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{5, 2, 4, 1, 3});
        System.out.println(largestBST(node));

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{25, 18, 50, 19, 20, 35, 60, null, 15, 18, 25, 20, 40, 55, 70, null, null, null, null, null, null, null, null, null, null, 25});
        System.out.println(largestBST(node));
    }

    private static int largestBST(TreeNode node) {
        Metadata m = largestBSTHelper(node);
        return m.count;
    }

    private static Metadata largestBSTHelper(TreeNode node) {
        if (node == null) {
            return new Metadata();
        }

        Metadata mLeft = largestBSTHelper(node.left);
        Metadata mRight = largestBSTHelper(node.right);

        if (mLeft.valid && mRight.valid && node.val > mLeft.maxLeft && node.val < mRight.minRight) {
            return new Metadata(true, 1 + mLeft.count + mRight.count, node.left != null ? mLeft.maxLeft : node.val, node.right != null ? mLeft.minRight : node.val);
        } else {
            return new Metadata(false, Math.max(mLeft.count, mRight.count), 0, 0);
        }
    }
}

class Metadata {
    boolean valid;
    int maxLeft;
    int minRight;
    int count;

    public Metadata(boolean valid, int count, int maxLeft, int minRight) {
        this.valid = valid;
        this.maxLeft = maxLeft;
        this.minRight = minRight;
        this.count = count;
    }

    public Metadata() {
        minRight = Integer.MAX_VALUE;
        maxLeft = Integer.MIN_VALUE;
        valid = true;
        count = 0;
    }

    @Override
    public String toString() {
        return "Metadata{" + "valid=" + valid + ", maxLeft=" + maxLeft + ", minRight=" + minRight + ", count=" + count + '}';
    }
}
