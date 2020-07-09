package competitiveProgramming.geekforgeeks.mustdoquestions.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
Connect nodes at same level
https://www.geeksforgeeks.org/connect-nodes-at-same-level/

Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.

Example:



Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F


Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL
 */
public class ConnectNodesAtSameLevel {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(6);
        node.left.left.right = new TreeNode(7);

        /****************
         1
         / \
         2   3
         / \
         4   5
         / \
         6  7
         ********************/

        connectNodes(node);
    }

    private static void connectNodes(TreeNode node) {
        if (node == null) return;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);
        queue.add(null);
        TreeNode current = null;
        TreeNode prev = null;

        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current == null) {
                prev = null;
                System.out.println();
                if (queue.size() > 0) {
                    queue.add(null);
                    continue;
                } else {
                    break;
                }
            }

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }

            if (prev != null) prev.nextRight = current;
            prev = current;
        }
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode nextRight;
    public int val;

    TreeNode(int val) {
        this.left = null;
        this.right = null;
        this.nextRight = null;
        this.val = val;
    }

}
