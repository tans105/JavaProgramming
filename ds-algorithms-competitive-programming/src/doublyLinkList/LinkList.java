package doublyLinkList;

public class LinkList {
	Node head;

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int d) {
			data = d;

		}
	}

	public static void main(String[] args) {
		LinkList dll = new LinkList();
		dll.head = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);

		dll.head.next = one;
		dll.head.prev = null;

		one.next = two;
		one.prev = dll.head;

		two.next = three;
		two.prev = one;

		three.next = four;
		three.prev = two;

		four.next = five;
		four.prev = three;

		five.next = null;
		five.prev = four;

		// dll.push(-1);
		dll.append(6);
		dll.delete(dll.head);
		dll.traverse();
	}

	public void traverse() {
		Node n = head;
		int count = 1;
		while (n != null) {
			System.out.println("postion : " + count + " is " + n.data);
			count++;
			n = n.next;
		}

	}

	public void push(int key) {

		Node n = new Node(key);

		n.next = head;
		n.prev = null;
		head.prev = n;
		head = n;

	}

	public void append(int key) {
		Node n = head;
		Node newNode = new Node(key);
		while (n.next != null) {
			n = n.next;
		}
		n.next = newNode;
		newNode.next = null;

	}

	public void delete(Node del) {
		Node n = head;
		boolean found = false;
		if (del == head) {
			head=head.next;
		}
		while (n != null) {
			if (n.next == del) {
				n = n.next;
				found = true;
				break;
			} else {

				n = n.next;
			}

		}

		if (found == true) {
			if (n.prev != null) {
				n.prev.next = n.next;
			}
			if (n.next != null) {
				n.next.prev = n.prev;
			}
		} else {
			return;
		}

	}
	
	public void reverse(){
		
	}

}
