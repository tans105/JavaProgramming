package ds;

public class LinkedList {
	static Node head;

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
		printLL();
		delete(8);
		delete(5);
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
		printLL();
	}
}
