package competitiveProgramming.leetcode.phase1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.*;

/*
Asked in : Microsoft

https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

863. All Nodes Distance K in Binary Tree

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.



Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation:
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.



Note:

    The given tree is non-empty.
    Each node in the tree has unique values 0 <= node.val <= 500.
    The target node is a node in the tree.
    0 <= K <= 1000.


 */
public class AllNodesFromDistanceK {
    public static void main(String[] args) {
        AllNodesFromDistanceK dist = new AllNodesFromDistanceK();

        TreeNode node;
        node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(dist.distanceK(node, new TreeNode(7), 2));
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        System.out.println(map);
        dfs(root, K, map.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root.val == target.val) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    //If length is found => Use the length
    private void dfs(TreeNode root, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root); //override the length from traversal if it's in the path
        if (length == K) res.add(root.val);

        dfs(root.left, K, length + 1, res);
        dfs(root.right, K, length + 1, res);
    }
}
