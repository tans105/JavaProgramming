package competitiveProgramming.GeekForGeeks;

class Node {
    int value;
    Node left;
    Node right;

    Node(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }
}

public class SpiralLevelOrderTraversal {
    Node root;

    public static void main(String[] args) {
        SpiralLevelOrderTraversal tree = new SpiralLevelOrderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        int levels = getHeight(tree.root);
        levelOrderTraversal(tree.root, levels);
    }

    private static void levelOrderTraversal(Node root, int levels) {
        if (root == null) {
            return;
        } else {
            boolean flip = false;
            for (int i = 1; i <= levels; i++) {
                printGivenLevel(root, i, flip);
                flip = !flip;
            }
        }
    }

    private static void printGivenLevel(Node node, int level, boolean flip) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.value + "\t");
        } else {
            if (flip) {
                printGivenLevel(node.left, level - 1, true);
                printGivenLevel(node.right, level - 1, true);
            } else {
                printGivenLevel(node.right, level - 1, false);
                printGivenLevel(node.left, level - 1, false);
            }

        }
    }

    private static int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }


}

