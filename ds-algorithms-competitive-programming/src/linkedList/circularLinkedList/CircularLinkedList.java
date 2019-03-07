package linkedList.circularLinkedList;

public class CircularLinkedList {
	Node head, head1, head2;

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
		CircularLinkedList ll = new CircularLinkedList();
		ll.head = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node ten = new Node(10);
		ll.head.next = one;
		ll.head.next.next = two;
		ll.head.next.next.next = three;
		ll.head.next.next.next.next = four;
		ll.head.next.next.next.next.next = five;
		ll.head.next.next.next.next.next.next = six;
		ll.head.next.next.next.next.next.next.next = seven;
		ll.head.next.next.next.next.next.next.next.next = eight;
		ll.head.next.next.next.next.next.next.next.next.next = ten;
		ll.head.next.next.next.next.next.next.next.next.next.next = ll.head;

		/* ll.traversal(); */
		System.out.println("------------------------");
		/* ll.split(); */
		ll.sortedInsert(9);
		ll.traversal();
	}

	/*
	 * traverser through the CLL
	 */

	public void traversal() {
		Node n = head;
		Node temp = head;
		while (true) {
			System.out.println(n.data);
			n = n.next;
			if (n.data == temp.data) {
				break;
			}
		}
	}

	/*
	 * split the link list into 2
	 */
	public void split() {

		int nodeCount = nodeCount();

		Node head1 = head;
		Node head2 = null;
		for (int i = 0; i < nodeCount / 2; i++) {
			head1 = head1.next;
		}
		head2 = head1.next;
		head1.next = head;

		printList(head1);
		Node temp = head2;
		while (head2.next != head) {

			head2 = head2.next;

		}
		head2.next = temp;
		System.out.println("--------------------------");
		printList(head2);

	}

	/*
	 * print the circular linked list
	 */
	void printList(Node node) {
		Node temp = node;
		if (node != null) {
			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != node);
		}
	}

	public int nodeCount() {
		Node n = head;
		Node temp = head;
		int count = 0;
		while (true) {
			n = n.next;
			if (n.data == temp.data) {
				break;
			}
			count++;

		}
		return count;
	}

	public void sortedInsert(int key) {
		Node nine = new Node(key);
		Node n = head;
		Node prev = null;
		Node curr=null;
		while (n.next != head) {

			prev = n;
			if (n.next.data > key) {
				n = n.next;
				curr=n;
				break;
			}
			n = n.next;
		}
		
		
		nine.next=prev.next;
		prev.next=nine;
		
		
		

	}
}
