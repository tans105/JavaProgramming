package datastructures.binaryTree;

import java.util.Stack;

public class AncestorTree {
	Node root;

	static class Node {
		Node left;
		Node right;
		int key;

		Node(int d) {
			key = d;
		}
	}

	public static void main(String[] args) {
		AncestorTree tree = new AncestorTree();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.getAncestor(new Node(4));
	}

	public void getAncestor(Node node) {
		Stack<Node> stack = new Stack();
		Node n = root;
		while (n != null) {
			stack.push(n);
			n = n.left;
		}
		while (!stack.isEmpty()) {
			
			Node curr = stack.pop();
			
			System.out.println("data is " + curr.key);
			if (curr.right != null) {
				stack.push(curr);
				curr = curr.right;
				while (curr != null) {
					stack.push(curr);
					curr = curr.left;
				}
			}
		}
	}
}
