package competitiveProgramming.leetcode;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
173. Binary Search Tree Iterator

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 */
public class BSTIterator {
    private TreeNode current;
    private List<Integer> tree;
    private int currentIndex;

    public BSTIterator(TreeNode root) {
        current = root;
        tree = traverse(root);
        currentIndex = 0;
    }

    private List<Integer> traverse(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverseHelper(root, list);
        return list;
    }

    private void traverseHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traverseHelper(node.left, list);
        list.add(node.val);
        traverseHelper(node.right, list);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return tree.get(currentIndex++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return currentIndex != tree.size();
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.generateBinaryTreeFromArray(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());    // return 3
        System.out.println(iterator.next());    // return 7
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 9
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 15
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next());    // return 20
        System.out.println(iterator.hasNext()); // return false
    }
}
