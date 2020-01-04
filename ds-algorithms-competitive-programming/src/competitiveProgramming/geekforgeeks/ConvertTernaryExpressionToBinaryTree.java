package competitiveProgramming.geekforgeeks;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/convert-ternary-expression-binary-tree/

Convert Ternary Expression to a Binary Tree
Given a string that contains ternary expressions. The expressions may be nested, task is convert the given ternary expression to a binary Tree.

Examples:

Input :  string expression =   1?2:3
Output :        1
              /  \
             2    3

Input : expression =  1?2?3:4:5
Output :     1
           /  \
          2    5
        /  \
       3    4
 */

public class ConvertTernaryExpressionToBinaryTree {
    public static void main(String[] args) {
//        TreeNode node = convert("1?2?3:4:5".toCharArray(), 0);
        TreeNode node = tenaryToTree("1?2?3:4:5");
        TreeUtils.inorderTraversal(node);
    }

    private static TreeNode convert(char[] chars, int index) {
        if (index >= chars.length) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(String.valueOf(chars[index])));
        ++index;

        if (index < chars.length && chars[index] == '?') {
            node.left = convert(chars, index + 1);
        } else if (index < chars.length) {
            node.right = convert(chars, index + 1);
        }
        return node;
    }


    public static TreeNode tenaryToTree(String s) {
        if (s.length() == 0)
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(String.valueOf(s.charAt(0))));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                TreeNode node = stack.peek();
                node.left = new TreeNode(Integer.parseInt(String.valueOf(s.charAt(i + 1))));
                stack.push(node.left);
            } else if (s.charAt(i) == ':') {
                stack.pop();
                TreeNode node = stack.pop();
                node.right = new TreeNode(Integer.parseInt(String.valueOf(s.charAt(i + 1))));
                stack.push(node.right);
            }
        }

        return root;
    }

}
