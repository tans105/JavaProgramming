package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.tree;

import utils.ArrayUtils;
import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Serialize and Deserialize a Binary Tree
https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize competitiveProgramming.others.archive.algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.getTemplateTree();

        Integer[] array = serialize(node);
        System.out.print("Serialized: \t");
        ArrayUtils.printArray(array);

        System.out.println();

        node = deserialize(array);
        System.out.print("Deserialized: \t");
        TreeUtils.inorderTraversal(node);
    }

    private static TreeNode deserialize(Integer[] arr) {
        TreeNode node = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int currentIndex = 1;

        while (currentIndex < arr.length) {
            TreeNode current = queue.poll();
            if (current != null) {
                if (arr[currentIndex] != null) {
                    current.left = new TreeNode(arr[currentIndex]);
                } else {
                    current.left = null;
                }
                queue.add(current.left);
                currentIndex++;

                if (currentIndex < arr.length && arr[currentIndex] != null) {
                    current.right = new TreeNode(arr[currentIndex]);
                } else {
                    current.right = null;
                }
                queue.add(current.right);
                currentIndex++;
            } else {
                currentIndex++;
            }
        }
        return node;
    }

    private static Integer[] serialize(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        list.add(node.val);

        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();

            if (n == null) {
                if (queue.size() > 0) {
                    queue.offer(null);
                    continue;
                } else {
                    break;
                }
            }

            if (n.left != null) {
                queue.offer(n.left);
            }

            if (n.right != null) {
                queue.offer(n.right);
            }

            list.add(n.left != null ? n.left.val : null);
            list.add(n.right != null ? n.right.val : null);

        }

        return list.toArray(new Integer[0]);
    }
}
