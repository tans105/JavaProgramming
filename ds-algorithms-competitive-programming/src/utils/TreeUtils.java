package utils;

import utils.pojo.TreeNode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TreeUtils {

    public static TreeNode generateBinaryTreeFromArray(Integer[] array) {
        if (array == null || array.length == 0) return null;
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new ConcurrentLinkedDeque<>();
        queue.add(root);
        int currentIndex = 1;
        TreeNode node = null;
        while (currentIndex < array.length) {
            node = queue.poll();
            if (array[currentIndex] != null) {
                node.left = new TreeNode(array[currentIndex]);
                queue.add(node.left);
            }
            currentIndex++;

            if (currentIndex < array.length) {
                if (array[currentIndex] != null) {
                    node.right = new TreeNode(array[currentIndex]);
                    queue.add(node.right);
                }
                currentIndex++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = generateBinaryTreeFromArray(new Integer[]{5, 1, 4, null, null, 3, 6});
        inorderTraversal(node);

    }

    public static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.val + "\t");
        inorderTraversal(node.right);
    }

    public static void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "\t");
        inorderTraversal(node.left);
        inorderTraversal(node.right);
    }

    public static void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        inorderTraversal(node.right);
        System.out.print(node.val + "\t");
    }

    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }
}
