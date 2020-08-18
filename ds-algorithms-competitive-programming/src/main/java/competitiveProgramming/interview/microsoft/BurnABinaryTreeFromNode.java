package competitiveProgramming.interview.Microsoft;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Exp: https://www.geeksforgeeks.org/microsoft-interview-experience-3-yrs-experienced/
https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/

Burn the binary tree starting from the target node
Last Updated: 24-04-2020
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
public class BurnABinaryTreeFromNode {
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
        burn(node, 3);
    }

    static Map<Integer, Integer> map = new HashMap<>();
    static Map<Integer, List<Integer>> dayWise = new HashMap<>();

    public static void burn(TreeNode root, int val) {
        getPath(root, val);
        burnTree(root, 0);
        System.out.println(dayWise);
    }

    private static void burnTree(TreeNode root, int day) {
        if (root == null) {
            return;
        }

        //Getting the distance from map if available. Else go with the flow.
        if (map.containsKey(root.val)) {
            day = map.get(root.val);
        }

        List<Integer> dayBurn = dayWise.getOrDefault(day, new ArrayList<>());
        dayBurn.add(root.val);
        dayWise.put(day, dayBurn);

        burnTree(root.left, day + 1);
        burnTree(root.right, day + 1);

    }

    /**
     * The method will go till target node and generate a map of all the nodes it crosses vs time it takes to reach them.
     * @param root
     * @param target
     * @return
     */
    private static int getPath(TreeNode root, int target) {
        if (root == null) return -1;
        if (root.val == target) {
            map.put(root.val, 0);
            return 0;
        }
        int left = getPath(root.left, target);
        if (left >= 0) {
            map.put(root.val, left + 1);
            return left + 1;
        }
        int right = getPath(root.right, target);
        if (right >= 0) {
            map.put(root.val, right + 1);
            return right + 1;
        }
        return -1;
    }


}
