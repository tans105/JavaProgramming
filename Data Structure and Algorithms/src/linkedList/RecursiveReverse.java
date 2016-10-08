package linkedList;

import linkedList.Template.Node;

public class RecursiveReverse {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		RecursiveReverse ll = new RecursiveReverse();
		ll.head = new Node(0);
		ll.head.next = new Node(1);
		ll.head.next.next = new Node(2);
		ll.head.next.next.next = new Node(3);
		ll.head.next.next.next.next = new Node(4);
		ll.head.next.next.next.next.next = new Node(5);
		ll.head.next.next.next.next.next.next = new Node(6);
		ll.reverse(ll.head, null);
		ll.traverseLinkList();
	}

	Node reverse(Node curr, Node prev) {

		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return null;
		}
		Node next1 = curr.next;
		curr.next = prev;
		reverse(next1, curr);
		return head;
	}

	public void traverseLinkList() {
		Node n = head;
		int count = 0;
		while (n != null) {
			if (count == 0) {
				System.out.println("postion : head  is " + n.data);
			} else {
				System.out.println("postion : " + count + "     is " + n.data);
			}
			count++;
			n = n.next;
		}

	}
}
