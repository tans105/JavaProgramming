package competitiveProgramming.others.practise;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.Stack;

public class InorderTraversalUsingStack {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.getTemplateTree();
        inorderTraverse(node);
    }

    private static void inorderTraverse(TreeNode node) {
        /*
                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14
         */

        Stack<TreeNode> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            System.out.print(n + "\t");

            if (n.right != null) {
                n = n.right;
                while (n != null) {
                    stack.push(n);
                    n = n.left;
                }
            }
        }

    }
}
