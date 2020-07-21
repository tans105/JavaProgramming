package competitiveProgramming.archive.datastructures.linkedList.linkList;

public class RemoveDuplicateLinkList {
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
		RemoveDuplicateLinkList ll = new RemoveDuplicateLinkList();
		ll.head = new Node(11);
		ll.head.next = new Node(11);
		ll.head.next.next = new Node(11);
		ll.head.next.next.next = new Node(3);
		ll.head.next.next.next.next = new Node(44);
		ll.head.next.next.next.next.next = new Node(44);
		ll.head.next.next.next.next.next.next = new Node(6);

		ll.removeDuplicate();
		// ll.removeDuplicates();
		ll.traverseLinkList();
	}

	void removeDuplicate() {
		Node n = head;
		while (n.next != null) {
			if (n.next.data == n.data) {
				n.next = n.next.next;
			} else {
				n = n.next;
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
