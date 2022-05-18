package competitiveProgramming.geekforgeeks.phase1;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.*;

/*
https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/

Burn the binary tree starting from the target node

Given a binary tree and target node. By giving the fire to the target node and fire starts to spread in a complete tree. The task is to print the sequence of the burning nodes of a binary tree.

Rules for burning the nodes :

    Fire will spread constantly to the connected nodes only.
    Every node takes the same time to burn.
    A node burns only once.

Examples:

Input :
                       12
                     /     \
                   13       10
                          /     \
                       14       15
                      /   \     /  \
                     21   24   22   23
target node = 14

Output :
14
21, 24, 10
15, 12
22, 23, 13

Explanation : First node 14 burns then it gives fire to it's
neighbors(21, 24, 10) and so on. This process continues until
the whole tree burns.


Input :
                       12
                     /     \
                  19        82
                 /        /     \
               41       15       95
                 \     /         /  \
                  2   21        7   16
target node = 41

Output :
41
2, 19
12
82
15, 95
21, 7, 16

 */
public class BurnABinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.getTemplateTree();
         /*
                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14
         */

        burn(node, 14);
    }

    private static void burn(TreeNode node, int target) {
        List<TreeNode> path = new ArrayList<>();
        getPath(node, target, path);
        Map<Integer, List<TreeNode>> dayMapping = new HashMap<>();
        Set<Integer> traversed = new HashSet<>();

        getPath(node, target, path); //getting the path to the nodes

        for (int i = 0; i < path.size(); i++) { //traversing node by node in the path and exploring the childs
            TreeNode current = path.get(i);
            checkRecursive(current, i, dayMapping, path, traversed);
        }

        System.out.println(dayMapping);
    }

    private static void checkRecursive(TreeNode current, int day, Map<Integer, List<TreeNode>> dayMapping, List<TreeNode> path, Set<Integer> traversed) {
        if (current == null) return;

        if(traversed.contains(current.val)) return;

        List<TreeNode> list = dayMapping.getOrDefault(day, new ArrayList<>());
        list.add(current);
        dayMapping.put(day, list);
        traversed.add(current.val);

        checkRecursive(current.left, day + 1, dayMapping, path, traversed);
        checkRecursive(current.right, day + 1, dayMapping, path, traversed);
    }


    private static TreeNode getPath(TreeNode node, int target, List<TreeNode> path) {
        if (node == null) return null;

        if (node.val == target) {
            return node;
        }

        TreeNode leftPath = getPath(node.left, target, path);
        if (leftPath != null) path.add(node);

        TreeNode rightPath = getPath(node.right, target, path);
        if (rightPath != null) path.add(node);


        if (leftPath != null) return leftPath;
        else return rightPath;

    }
}
