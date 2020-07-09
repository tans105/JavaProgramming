package datastructures.linkedList.linkList;

public class InsertToSortedLinkList {
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
		InsertToSortedLinkList ll = new InsertToSortedLinkList();
		ll.head = new Node(2);
		ll.head.next = new Node(4);
		ll.head.next.next = new Node(6);
		ll.head.next.next.next = new Node(8);
		ll.head.next.next.next.next = new Node(10);
		ll.head.next.next.next.next.next = new Node(12);
		ll.head.next.next.next.next.next.next = new Node(14);
		ll.sortedInsert(15);
		ll.sortedInsert(0);
		ll.sortedInsert(5);
		ll.sortedInsert(5);
		ll.traverseLinkList();
	}

	void sortedInsert(int key) {
		Node n = head;
		Node newNode = new Node(key);
		if (key < n.data) {
			newNode.next = n;
			head = newNode;

		} else {
			Node prev = null;
			while (n.data <= key && n.next != null) {
				prev = n;
				n = n.next;
			}
			if (n.next != null) {
				prev.next = newNode;
				newNode.next = n;
			} else {
				n.next = newNode;
				newNode.next = null;
			}
		}
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
