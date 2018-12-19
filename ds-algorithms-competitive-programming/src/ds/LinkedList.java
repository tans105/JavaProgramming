package ds;

import ds.Node;
import linkedList.PrintMiddleElementLinkList;

public class LinkedList {
	public static Node head;

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		ll.head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		append(new Node(5));
		prepend(new Node(6));
		prepend(new Node(7));
		append(new Node(8));
//		delete(8);
//		delete(5);
//		delete(1);
		/**
		 * 7 6 1 2 3 4 5 8
		 */
		printLL();
//		reverseListIterative	();
//		reverseLinkListRecursive(head, null);
//		System.out.println(lengthOfLLRecursives(head));
//		System.out.println(searchElement(head, 7));
//		printMiddleElement();
		

	}

	private static void reverseListIterative() {
		Node n = head;
		Node temp = null;
		Node prev = null;
		while (n != null) {
			temp = n.next;
			if (n == head) {
				n.next = null;
			} else {
				n.next = prev;
			}
			prev = n;
			n = temp;
		}
		head = prev;
	}

	private static void reverseLinkListRecursive(Node curr, Node prev) {
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return;
		}
		Node temp = curr.next;
		curr.next = prev;
		reverseLinkListRecursive(temp, curr);
	}

	public static void printLL() {
		Node n = head;
		while (n != null) {
			System.out.print(n.val + "\t");
			n = n.next;
		}
		System.out.println();
	}

	public static void append(Node val) {
		Node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = val;
	}

	public static void prepend(Node val) {
		val.next = head;
		head = val;
	}

	public static void delete(int val) {
		Node n = head;
		if (n.val == val) {
			Node next = n.next;
			n.next = null;
			head = next;
			printLL();
			return;
		}
		Node prev = null;
		while (n.val != val) {
			prev = n;
			n = n.next;
		}
		// n is now current
		Node newNode = n.next;
		n.next = null;
		prev.next = newNode;
	}

	public static int lengthOfLLRecursives(Node n) {
		if (n == null) {
			return 0;
		}
		return lengthOfLLRecursives(n.next) + 1;
	}

	public static boolean searchElement(Node n, int val) {
		if (n.val == val) {
			return true;
		}
		if (n.next == null) {
			return false;
		}
		return searchElement(n.next, val);
	}

	public static void printMiddleElement() {
		Node singleStep = head;
		Node twoStep = head;
		while (twoStep != null && twoStep.next !=null) {
			singleStep = singleStep.next;
			twoStep = twoStep.next.next;
		}
		System.out.println(singleStep.val);
	}
}
