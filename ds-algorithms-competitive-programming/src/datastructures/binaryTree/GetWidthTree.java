package datastructures.binaryTree;

public class GetWidthTree {
	Node root;

	static class Node {
		int key;
		Node right;
		Node left;

		Node(int d) {
			key = d;
		}
	}

	public static void main(String[] args) {
		GetWidthTree tree = new GetWidthTree();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.left.left.left = new Node(7);
		tree.root.left.left.left.left = new Node(8);
		System.out.println("max width is: "+tree.getMaxWidth(tree.root));
	}

	public int height(Node n) {
		if (n == null) {
			return 0;
		}
		return Math.max(height(n.left), height(n.right)) + 1;
	}

	public int getMaxWidth(Node n) {
		int maxWidth = 0, width = 0;
		for (int i = 1; i < height(n) + 1; i++) {
			width = getWidth(n, i);
			System.out.println("level :"+i+ " width: "+width);
			if (width > maxWidth)
				maxWidth = width;
		}
		return maxWidth;
	}

	public int getWidth(Node node, int level) {
		if (node == null)
			return 0;

		if (level == 1)
			return 1;
		else if (level > 1)
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		return 0;
	}

}
