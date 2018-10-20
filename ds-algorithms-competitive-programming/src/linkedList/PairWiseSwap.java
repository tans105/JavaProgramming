package linkedList;

public class PairWiseSwap {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			next = null;
			this.data = data;

		}
	}

	public static void main(String[] args) {
		PairWiseSwap ll = new PairWiseSwap();
		ll.head = new Node(0);
		ll.head.next = new Node(1);
		ll.head.next.next = new Node(2);
		ll.head.next.next.next = new Node(3);
		ll.head.next.next.next.next = new Node(4);
		ll.head.next.next.next.next.next = new Node(5);
		ll.traverseList(ll.head);

		ll.parWiseSwap();
		System.out.println("-------------");
		ll.traverseList(ll.head);
	}

	public void traverseList(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	public void parWiseSwap() {
		Node n = head;
		if (n == null) {
			return;
		}
		//Configuring the new head
		Node n1 = n.next;
		n.next = n1.next;
		n1.next = n;
		head = n1;
		System.out.println();
		while (n != null && n.next != null && n.next.next != null) {
			n1 = n.next;
			Node n2 = n1.next;
			n1.next = n2.next;
			n2.next = null;
			n.next = n2;
			n2.next = n1;
			n = n.next.next;
		}
	}
}
