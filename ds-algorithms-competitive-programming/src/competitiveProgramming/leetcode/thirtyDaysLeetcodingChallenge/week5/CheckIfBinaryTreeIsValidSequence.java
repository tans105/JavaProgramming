package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.week5;

import utils.TreeUtils;
import utils.pojo.TreeNode;

/*
  Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.

We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.


Example 1:


Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
Output: true
Explanation:
The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
Other valid sequences are:
0 -> 1 -> 1 -> 0
0 -> 0 -> 0
Example 2:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
Output: false
Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
Example 3:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
Output: false
Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.


Constraints:

1 <= arr.length <= 5000
0 <= arr[i] <= 9
Each node's value is between [0 - 9].
 */
public class CheckIfBinaryTreeIsValidSequence {
    public static void main(String[] args) {
        TreeNode node;
        int[] arr;

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{0, 1, 0, 0, 1, 0, null, null, 1, 0, 0});
        arr = new int[]{0, 1, 1, 0, 0};
        System.out.println(isValidSequence(node, arr));

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{0});
        arr = new int[]{0};
        System.out.println(isValidSequence(node, arr));
    }

    public static boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequenceHelper(root, arr, 0);
    }

    private static boolean isValidSequenceHelper(TreeNode root, int[] arr, int index) {
        if (root == null || index == arr.length) return false;
        if (root.left == null && root.right == null) { //leaf
            return root.val == arr[index] && index == arr.length - 1;
        } else {
            if (root.val == arr[index]) {
                return isValidSequenceHelper(root.left, arr, index + 1) || isValidSequenceHelper(root.right, arr, index + 1);
            } else {
                return false;
            }

        }
    }
}
