package competitiveProgramming.mustdoquestions.tree;

import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.*;

/*
https://www.geeksforgeeks.org/bottom-view-binary-tree/

Bottom View of a Binary Tree
Given a Binary Tree, we need to print the bottom view from left to right. A node x is there in output if x is the bottommost node at its horizontal distance. Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

Examples:

                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14

For the above tree the output should be 5, 10, 3, 14, 25.



If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to print 4.


                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \
                  10    14
For the above tree the output should be 5, 10, 4, 14, 25.
 */
public class BottomViewBinaryTree {
    public static void main(String[] args) {
        /*
                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14
         */
        TreeNode node = TreeUtils.generateBinaryTreeFromArray(new Integer[]{20, 8, 22, 5, 3, null, 25, null, null, 10, 14, null, null});
        bottomView(node);
    }

    private static void bottomView(TreeNode node) {
        Queue<HeightedNode> queue = new LinkedList<>();
        Map<Integer, List<HeightedNode>> hash = new TreeMap<>();

        List<HeightedNode> temp = new ArrayList();
        temp.add(new HeightedNode(node, 0));
        queue.add(new HeightedNode(node, 0));
        hash.put(0, temp);
        queue.add(null);

        while (!queue.isEmpty()) {

            HeightedNode hNode = queue.poll();

            if (hNode == null) {
                if (queue.size() > 0) {
                    queue.add(null);
                    continue;
                } else {
                    break;
                }
            }

            if (hNode.node.left != null) {
                int height = hNode.height - 1;
                HeightedNode lHnode = new HeightedNode(hNode.node.left, height);
                queue.add(lHnode);
                List<HeightedNode> t = hash.get(height);
                if (t == null) {
                    t = new ArrayList<>();
                    t.add(lHnode);
                    hash.put(height, t);
                } else {
                    t.add(lHnode);
                    hash.put(height, t);
                }
            }
            if (hNode.node.right != null) {
                int height = hNode.height + 1;
                HeightedNode rHnode = new HeightedNode(hNode.node.right, height);
                queue.add(rHnode);
                List<HeightedNode> t = hash.get(height);
                if (t == null) {
                    t = new ArrayList<>();
                    t.add(rHnode);
                    hash.put(height, t);
                } else {
                    t.add(rHnode);
                    hash.put(height, t);
                }
            }
        }

        for (Map.Entry<Integer, List<HeightedNode>> entry : hash.entrySet()) {
            System.out.print(entry.getValue().get(entry.getValue().size() - 1).node + "\t");
        }
    }

    static class HeightedNode {
        public TreeNode node;
        public Integer height;

        public HeightedNode(TreeNode node, Integer height) {
            this.node = node;
            this.height = height;
        }

        @Override
        public String toString() {
            return "HeightedNode{" +
                    "node=" + node +
                    ", height=" + height +
                    '}';
        }
    }
}
