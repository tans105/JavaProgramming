package competitiveProgramming.geekforgeeks.mustdoquestions;

import utils.ArrayUtils;
import utils.TreeUtils;
import utils.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode node = TreeUtils.getTemplateTree();

        Integer[] array = serialize(node);
        System.out.print("Serialized: \t");
        ArrayUtils.printArray(array);

        System.out.println();

        node = deserialize(array);
        System.out.print("Deserialized: \t");
        TreeUtils.inorderTraversal(node);
    }

    private static TreeNode deserialize(Integer[] arr) {
        TreeNode node = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int currentIndex = 1;

        while (currentIndex < arr.length) {
            TreeNode current = queue.poll();
            if (current != null) {
                if (arr[currentIndex] != null) {
                    current.left = new TreeNode(arr[currentIndex]);
                } else {
                    current.left = null;
                }
                queue.add(current.left);
                currentIndex++;

                if (currentIndex < arr.length && arr[currentIndex] != null) {
                    current.right = new TreeNode(arr[currentIndex]);
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

    private static Integer[] serialize(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        list.add(node.val);

        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();

            if (n == null) {
                if (queue.size() > 0) {
                    queue.offer(null);
                    continue;
                } else {
                    break;
                }
            }

            if (n.left != null) {
                queue.offer(n.left);
            }

            if (n.right != null) {
                queue.offer(n.right);
            }

            list.add(n.left != null ? n.left.val : null);
            list.add(n.right != null ? n.right.val : null);

        }

        return list.toArray(new Integer[0]);
    }
}
