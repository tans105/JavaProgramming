package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;
import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/delete-node-in-a-bst/

450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

 */
public class DeleteNodeBST {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeUtils.inorderTraversal(deleteNode(node, 5));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode prev = null;
        TreeNode[] nodes = findNode(root, prev, key);

        /* Leaf Node: Delete the leaf node just like that. */
        if (nodes[1].left == null && nodes[1].right == null) {
            deleteLeafNode(nodes);
            return root;
        }

        /* Single child: Delete the node and swap it with the child */
        if (nodes[1].left != null && nodes[1].right == null) { //one child
            if (nodes[0].left != null && nodes[0].left.val == nodes[1].val) {
                nodes[0].left = nodes[1].left;
            } else {
                nodes[0].right = nodes[1].left;
            }
            return root;
        } else if (nodes[1].left == null) {
            if (nodes[0].left != null && nodes[0].left.val == nodes[1].val) {
                nodes[0].left = nodes[1].right;
            } else {
                nodes[0].right = nodes[1].right;
            }
            return root;
        }


        //two child: Swap it with immediate inorder successor or inorder predecessor
        List<Integer> inorderList = new ArrayList<>();
        getInorderList(inorderList, root);

        int index = 0;
        while (index < inorderList.size()) {
            if (inorderList.get(index) == key) {
                break;
            }
            index++;
        }

        TreeNode[] nodes1 = findNode(root, null, inorderList.get(index - 1));
        nodes[1].val = inorderList.get(index - 1);
        deleteLeafNode(nodes1);
        return root;
    }

    private static void deleteLeafNode(TreeNode[] nodes) {
        if (nodes[0].left != null && nodes[0].left.val == nodes[1].val) {
            nodes[0].left = null;
        } else {
            nodes[0].right = null;
        }
    }


    private static void getInorderList(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        getInorderList(list, root.left);
        list.add(root.val);
        getInorderList(list, root.right);

    }

    private static TreeNode[] findNode(TreeNode current, TreeNode prev, int key) {
        if (current == null) {
            return null;
        }

        TreeNode[] arr;

        if (current.val == key) {
            arr = new TreeNode[2];
            arr[0] = prev;
            arr[1] = current;
            return arr;
        }

        if (key < current.val && current.left != null) {
            return findNode(current.left, current, key);
        } else if (key > current.val && current.right != null) {
            return findNode(current.right, current, key);
        }

        return null;
    }
}
