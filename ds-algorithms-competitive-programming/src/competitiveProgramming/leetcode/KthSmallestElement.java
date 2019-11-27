package competitiveProgramming.leetcode;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{3, 1, 4, null, 2});
        System.out.println(kthSmallest(node, 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list.get(list.size() - k - 1);
    }

    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
