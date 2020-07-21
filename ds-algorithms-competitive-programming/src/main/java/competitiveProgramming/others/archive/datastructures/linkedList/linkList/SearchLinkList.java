package competitiveProgramming.others.archive.datastructures.linkedList.linkList;

/*
 * search through linklist 
 * -iterative
 * -recursive
 */
public class SearchLinkList {
	Node head;

	static class Node {
		Node next;
		int data;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		SearchLinkList ll = new SearchLinkList();
		ll.head = new Node(0);
		ll.head.next = new Node(1);
		ll.head.next.next = new Node(2);
		ll.head.next.next = new Node(3);
		ll.head.next.next.next = new Node(4);
		ll.head.next.next.next.next = new Node(5);
		System.out.println(ll.searchIterative(5));
		System.out.println(ll.searchRecursive(ll.head, 6));
	}

	boolean searchIterative(int key) {
		Node n = head;
		boolean isFound = false;
		while (n != null) {
			if (n.data == key) {
				isFound = true;
			}

			n = n.next;

		}
		return isFound;
	}

	boolean searchRecursive(Node node, int key) {
		if (node == null) {
			return false;
		}
		if (node.data == key) {
			return true;
		} else {
			return searchRecursive(node.next, key);
		}
	}
}
