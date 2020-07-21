package competitiveProgramming.archive.datastructures.binaryTree;

/*
 * compute maximum height of btree
 */
public class MaximumHeightBTree {
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
		MaximumHeightBTree tree = new MaximumHeightBTree();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(6);
		tree.root.left.left.left=new Node(7);
		tree.root.left.left.left.left=new Node(8);
		System.out.println(tree.height(tree.root));
	}

	public int height(Node n) {
		if(n==null){
			return 0;
		}
		return Math.max(height(n.left), height(n.right)) + 1;
	}
}
