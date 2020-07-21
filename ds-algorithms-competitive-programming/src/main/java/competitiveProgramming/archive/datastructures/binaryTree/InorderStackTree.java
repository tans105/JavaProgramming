package competitiveProgramming.archive.datastructures.binaryTree;

import java.util.Stack;

/*
 * inorder traversal using competitiveProgramming.archive.datastructures.stack
 */
public class InorderStackTree {
	Node root;

	static class Node {
		int key;
		Node left;
		Node right;

		Node(int key) {
			this.key = key;
		}
	}

	public static void main(String[] args) {
		InorderStackTree tree = new InorderStackTree();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);
		tree.inOrderTraversal(tree.root);
	}

	public void inOrderTraversal(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node n = root;
		while (n != null) {
			stack.push(n);
			n = n.left;
		}
		while (stack.size() > 0) {
			n = stack.pop();
			System.out.println(n.key);
			if (n.right != null) {
				n = n.right;
				while (n != null) {
					stack.push(n);
					n = n.left;

				}

			}

		}
	}
}
