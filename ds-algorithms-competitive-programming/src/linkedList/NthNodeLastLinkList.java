package linkedList;

public class NthNodeLastLinkList {
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
		NthNodeLastLinkList ll = new NthNodeLastLinkList();
		ll.head = new Node(0);
		ll.head.next = new Node(1);
		ll.head.next.next = new Node(2);
		ll.head.next.next.next = new Node(3);
		ll.head.next.next.next.next = new Node(4);
		ll.head.next.next.next.next.next = new Node(5);
		ll.head.next.next.next.next.next.next = new Node(6);
		ll.traverseLinkList();
		System.out.println(ll.NthNodeLast(2));
	}

	int NthNodeLast(int n) {
		Node main = head;
		Node ref = head;
		for (int i = 0; i < n; i++) {
			ref = ref.next;
		}
		while (ref != null) {
			main = main.next;
			ref = ref.next;

		}
		return main.data;
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