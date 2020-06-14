package competitiveProgramming.geekforgeeks;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
Convert a Binary Tree into its Mirror Tree
Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
 */
public class MirrorTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 3, 2, null, null, 5, 4});
        node = mirror(node);
        TreeUtils.levelOrderTraversalWithQueue(node);
    }

    public static TreeNode mirror(TreeNode node) {
        TreeNode mirror = new TreeNode(node.val);
        generateMirror(node, mirror);
        return mirror;
    }

    private static void generateMirror(TreeNode node, TreeNode mirror) {
        if (node == null) return;


        if (node.left != null) {
            mirror.right=  new TreeNode(node.left);
            generateMirror(node.left, mirror.right);
        }

        if(node.right != null) {
            mirror.left = new TreeNode(node.right);
            generateMirror(node.right, mirror.left);
        }
    }
}
