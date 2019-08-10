package competitiveProgramming.leetcode;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(levelOrder(node));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int height = TreeUtils.getHeight(root);
        for (int i = 0; i < height; i++) {
            list.add(printGivenLevel(root, new ArrayList<Integer>(), i));
        }
        return list;
    }

    private static List<Integer> printGivenLevel(TreeNode node, ArrayList<Integer> levelList, int level) {
        if (node == null) {
            return levelList;
        }
        if (level == 0) {
            levelList.add(node.val);
        }

        printGivenLevel(node.left, levelList, level - 1);
        printGivenLevel(node.right, levelList, level - 1);

        return levelList;
    }

}
