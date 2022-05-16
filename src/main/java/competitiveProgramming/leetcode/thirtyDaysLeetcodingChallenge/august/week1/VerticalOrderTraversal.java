package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.august.week1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3415/


Vertical Order Traversal of a Binary Tree

Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.



Example 1:

Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).

Example 2:

Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.



Note:

    The tree will have between 1 and 1000 nodes.
    Each node's value will be between 0 and 1000.


 */
public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(verticalTraversal(node));

        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(verticalTraversal(node));
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> verticalMap = new TreeMap<>();
        List<List<Integer>> list = new ArrayList<>();
        traverse(root, verticalMap, 0);

        for (Map.Entry<Integer, List<Integer>> entry : verticalMap.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }

    private static void traverse(TreeNode root, Map<Integer, List<Integer>> verticalMap, int width) {
        if (root == null) return;

        traverse(root.left, verticalMap, width - 1);

        List<Integer> nodes;
        if (verticalMap.containsKey(width)) {
            nodes = verticalMap.get(width);
            nodes.add(root.val);
        } else {
            nodes = new ArrayList<>();
            nodes.add(root.val);
        }

        verticalMap.put(width, nodes);

        traverse(root.right, verticalMap, width + 1);

    }
}
