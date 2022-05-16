package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.october.week2;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3489/

Serialize and Deserialize BST

Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.



Example 1:

Input: root = [2,1,3]
Output: [2,1,3]

Example 2:

Input: root = []
Output: []



Constraints:

    The number of nodes in the tree is in the range [0, 104].
    0 <= Node.val <= 104
    The input tree is guaranteed to be a binary search tree.


 */
public class SerializeDeserializeBST {
    public static void main(String[] args) {
        SerializeDeserializeBST ser = new SerializeDeserializeBST();
        SerializeDeserializeBST deser = new SerializeDeserializeBST();
        /*
                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14
         */
        TreeNode node = TreeUtils.getTemplateTree();
        List<Integer> tree = ser.serialize(node);
        TreeNode ans = deser.deserialize(tree);

        TreeUtils.levelOrderTraversalWithQueue(ans);
    }

    private TreeNode deserialize(List<Integer> tree) {
        TreeNode node = new TreeNode(tree.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int currentIndex = 1;

        while (currentIndex < tree.size()) {
            TreeNode current = queue.poll();
            if (current != null) {
                if (tree.get(currentIndex) != null) {
                    current.left = new TreeNode(tree.get(currentIndex));
                } else {
                    current.left = null;
                }
                queue.add(current.left);
                currentIndex++;

                if (currentIndex < tree.size() && tree.get(currentIndex) != null) {
                    current.right = new TreeNode(tree.get(currentIndex));
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

    private List<Integer> serialize(TreeNode tree) {
        if (tree == null) return null;

        List<Integer> serializedTree = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(tree);
        serializedTree.add(tree.val);

        while (true) {
            TreeNode node = queue.poll();

            if (node == null) {
                if (queue.size() > 0) {
                    queue.offer(null);
                    continue;
                } else {
                    break;
                }
            }

            if (node.left != null) {
                serializedTree.add(node.left.val);
                queue.offer(node.left);
            } else {
                serializedTree.add(null);
            }

            if (node.right != null) {
                serializedTree.add(node.right.val);
                queue.offer(node.right);
            } else {
                serializedTree.add(null);
            }
        }

        return serializedTree;

    }
}
