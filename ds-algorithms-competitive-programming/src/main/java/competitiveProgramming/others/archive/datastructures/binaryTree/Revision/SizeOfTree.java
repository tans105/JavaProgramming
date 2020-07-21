package competitiveProgramming.others.archive.datastructures.binaryTree.Revision;

public class SizeOfTree {
	Node root;

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int d) {
			left = null;
			right = null;
			data = d;
		}
	}

	public static void main(String[] args) {
		SizeOfTree tree = new SizeOfTree();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);
		System.out.println(sizeOfTree(tree.root));
	}

	static int count;

	public static int sizeOfTree(Node node) {
		if (node == null) {
			return 0;
		} else {
			return 1+sizeOfTree(node.left)+sizeOfTree(node.right);
		}

	}
}
