package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.september.week2;

import utils.TreeUtils;
import utils.pojo.TreeNode;

public class SumToRootLeafBinarySum {
    public static void main(String[] args) {
        System.out.println(sumRootToLeaf(TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 0, 1, 0, 1, 0, 1})));
    }

    public static int sumRootToLeaf(TreeNode root) {
        return sumPath(root, 0);
    }

    private static int sumPath(TreeNode root, int pathSum) {
        if (root == null) return 0;

        pathSum = 2 * pathSum + root.val;

        if (root.left == null && root.right == null) {
            return pathSum;
        }

        return sumPath(root.left, pathSum) + sumPath(root.right, pathSum);

    }

}
