package competitiveProgramming.mustdoquestions.tree;


import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/

Level order traversal in spiral form

                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14

Write a function to print spiral order traversal of a tree. For below tree, function should print 20,22,8,5,3,25,14,10.
 */
public class LevelOrderTraversalSpiralForm {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{20, 8, 22, 5, 3, null, 25, null, null, 10, 14, null, null});
        spiralOrderTraversal(node);
    }

    private static void spiralOrderTraversal(TreeNode node) {
        int height = TreeUtils.getHeight(node);
        boolean swap = false;

        for (int i = 0; i < height; i++) {
            printGivenLevel(node, i, swap);
            swap = !swap;
        }
    }

    private static void printGivenLevel(TreeNode node, int i, boolean swap) {
        if (node == null) {
            return;
        }

        if (i == 0) {
            System.out.print(node + "\t");
        }

        if(swap) {
            printGivenLevel(node.left, i - 1, swap);
            printGivenLevel(node.right, i - 1, swap);
        } else {
            printGivenLevel(node.right, i - 1, swap);
            printGivenLevel(node.left, i - 1, swap);
        }

    }
}
