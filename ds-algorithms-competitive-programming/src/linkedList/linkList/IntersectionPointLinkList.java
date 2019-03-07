package linkedList.linkList;

import java.util.HashSet;

public class IntersectionPointLinkList {
	Node head1;
	Node head2;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		IntersectionPointLinkList list = new IntersectionPointLinkList();

		list.head1 = new Node(3);
		list.head1.next = new Node(6);
		list.head1.next.next = new Node(15);
		list.head1.next.next.next = new Node(15);
		list.head1.next.next.next.next = new Node(30);

		// creating second linked list
		list.head2 = new Node(10);
		list.head2.next = new Node(15);
		list.head2.next.next = new Node(30);

		list.getIntersection(list.head1, list.head2);

	}

	public void getIntersection(Node n1, Node n2) {
		HashSet<Integer> arr = new HashSet<Integer>();
		while (n1 != null) {
			arr.add(n1.data);
			n1 = n1.next;
		}

		while (n2 != null) {
			if (arr.contains(n2.data)) {
				System.out.println("yes!!");
				break;
			}
			n2 = n2.next;

		}

	}

	public void traverseLinkList(Node n) {

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
