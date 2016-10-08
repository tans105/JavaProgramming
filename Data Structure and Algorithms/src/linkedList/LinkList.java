package linkedList;



public class LinkList {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/*
	 * main method
	 */
	public static void main(String args[]) {
		LinkList ll = new LinkList();
		ll.head = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);

		ll.head.next = one;
		one.next = two;
		ll.push(4);
		ll.push(5);
		ll.append(10);
		ll.insert(one, 11);

		/*
		 * ll.deleteNode(10); ll.positionalDelete(3);
		 * 
		 * System.out.println("before"); ll.traverseLinkList();
		 * System.out.println("Iterative count is: " + ll.getIterativeCount());
		 * System.out.println("Recursive count is: " +
		 * ll.getRecursiveCount(ll.head));
		 * 
		 * ll.swapNodes(5, 4); System.out.println("now"); ll.traverseLinkList();
		 * 
		 * ll.reverse(); ll.traverseLinkList();
		 */
		ll.traverseLinkList();
		ll.rotate(4);
		ll.traverseLinkList();

	}

	/*
	 * if the new node is the head
	 */
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	/*
	 * insert in the middle of linklist
	 */
	public void insert(Node prevNode, int data) {
		if (head.next == null) {
			return;
		} else {
			Node n = head;
			while (n != prevNode) {
				n = n.next;
			}
			Node newNode = new Node(data);
			newNode.next = n.next;
			n.next = newNode;
		}

	}

	/*
	 * add node at the end
	 */
	public void append(int data) {
		if (head.next == null) {
			return;
		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			Node newNode = new Node(data);
			n.next = newNode;
			newNode.next = null;

		}
	}

	/*
	 * delete at position
	 */

	public void positionalDelete(int position) {
		Node n = head;
		for (int i = 0; i < position - 1; i++) {
			n = n.next;
		}
		deleteNode(n.data);

	}

	/*
	 * delete Node
	 */

	void deleteNode(int key) {

		Node temp = head, prev = null;

		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}

		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;

		prev.next = temp.next;
	}

	/*
	 * traverse through the linklist
	 */
	public void traverseLinkList() {
		Node n = head;
		int count = 1;
		while (n != null) {
			System.out.println("postion : " + count + " is " + n.data);
			count++;
			n = n.next;
		}

	}

	/*
	 * Counting the element in a linklist iteratively
	 */
	public int getIterativeCount() {
		int count = 0;
		Node n = head;
		while (n != null) {
			count++;
			n = n.next;
		}
		return count;

	}

	/*
	 * Counting the element in a linklist recursively
	 */
	public int getRecursiveCount(Node node) {
		if (node == null)
			return 0;

		return 1 + getRecursiveCount(node.next);
	}

	/*
	 * check if the nodes exists
	 */
	public boolean exists(int x, int y) {

		Node n = head;
		boolean existsX = false;
		boolean existsY = false;
		// check for both
		while (n != null) {
			if (n.data == x) {
				existsX = true;
			}
			if (n.data == y) {
				existsY = true;
				break;
			}
			n = n.next;
		}

		if (existsX && existsY) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * Check if the nodes are adjacent
	 */
	public int isAdjacent(int x, int y) {
		Node n = head;
		Node prev = null;
		Node curr = null;
		int index = 0;
		while (n != null) {
			if (n.data == x) {
				prev = n;
				curr = n.next;
				break;
			}
			index++;
			n = n.next;
		}
		if (prev.data == x && curr.data == y) {
			return index;

		} else {
			return -1;
		}
	}

	/*
	 * swap the nodes
	 * 
	 * @params- two data x and y case1 - same node case2 - either one does not
	 * exists case3 - both nodes adjacent case4 - x is head case5 - y is tail
	 */
	public void mySwapNodes(int x, int y) {
		Node n = head;
		if (x == y)
			return;
		if (!exists(x, y)) {
			return;
		} else {
			int index = isAdjacent(x, y);

			Node nodeX = null;
			Node nodeBeforeX = null;
			Node nodeY = null;

			if (index != -1) {
				// is adjacent
				if (index != 0) {
					// is adjacent but x is not head
					for (int i = 0; i < index; i++) {

						nodeBeforeX = n;
						nodeX = n.next;
						n = n.next;
						nodeY = n.next;

					}

					nodeBeforeX.next = null;
					nodeX.next = nodeY.next;
					nodeY.next = nodeX;
					nodeBeforeX.next = nodeY;
				} else {

					// is adjacent but x is head

					nodeX = n;
					nodeY = n.next;
					nodeX.next = null;
					nodeX.next = nodeY.next;

					nodeY.next = nodeX;
					nodeY = head;

				}
			} else {
				System.out.println("adjaceent only brh!!");
				// not adjacenet
			}
		}

	}

	/*
	 * copied from geeks method-myswapNodes
	 */
	public void swapNodes(int x, int y) {
		// Nothing to do if x and y are same
		if (x == y)
			return;

		// Search for x (keep track of prevX and CurrX)
		Node prevX = null, currX = head;
		while (currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}

		// Search for y (keep track of prevY and currY)
		Node prevY = null, currY = head;
		while (currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}

		// If either x or y is not present, nothing to do
		if (currX == null || currY == null)
			return;

		// If x is not head of linked list
		if (prevX != null)
			prevX.next = currY;
		else
			// make y the new head
			head = currY;

		// If y is not head of linked list
		if (prevY != null)
			prevY.next = currX;
		else
			// make x the new head
			head = currX;

		// Swap next pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}

	/*
	 * reverse linklist
	 */
	public void reverse() {

		Node currNode = head;
		Node prevNode = null;
		Node nextNode = null;

		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;

		}
		head = prevNode;

	}

	public void rotate(int k) {
		Node n = head;
		Node temp = head;
		Node startNode = null;
		Node endNode = null;
		for (int i = 0; i < k - 1; i++) {
			endNode = n.next;
			n = n.next;
			startNode = n.next;
		}

		endNode.next = null;
		head = startNode;
		while (startNode.next != null) {
			startNode = startNode.next;
		}

		startNode.next = temp;
	}
	

}
