package datastructures.linkedList.linkList;
/*
 * merging two sorted linklist 
 */
public class MergeSortedLinkList {
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
		MergeSortedLinkList ll1 = new MergeSortedLinkList();
		MergeSortedLinkList ll2 = new MergeSortedLinkList();
		ll1.head = new Node(0);
		ll1.head.next = new Node(2);
		ll1.head.next.next = new Node(4);
		ll1.head.next.next.next = new Node(6);
		ll1.head.next.next.next.next = new Node(8);
		ll1.head.next.next.next.next.next = new Node(10);
		ll1.head.next.next.next.next.next.next = new Node(12);
		ll2.head = new Node(1);
		ll2.head.next = new Node(3);
		ll2.head.next.next = new Node(5);
		ll2.head.next.next.next = new Node(7);
		ll2.head.next.next.next.next = new Node(9);
		ll2.head.next.next.next.next.next = new Node(11);
		ll2.head.next.next.next.next.next.next = new Node(13);
		System.out.println("----------LL-1------------");
		ll1.traverseLinkList();
		System.out.println("----------LL-2----------------");
		ll2.traverseLinkList();
		
		MergeSortedLinkList ll = new MergeSortedLinkList();
		Node n = ll1.head;
		Node m = ll2.head;

		if (n.data < m.data) {
			ll.head = n;
			n = n.next;
		} else {
			ll.head = m;
			m = m.next;
		}

		Node x = ll.head;
		while (n != null && m != null) {

			if (n.data < m.data) {
				x.next = n;
				x = x.next;
				n = n.next;
			} else {
				x.next = m;
				x = x.next;
				m = m.next;
			}
		}

		while (n != null) {
			x.next = n;
			x = x.next;
			n = n.next;
		}
		while (m != null) {
			x.next = m;
			x = x.next;
			m = m.next;
		}
		System.out.println("----------LL-result----------------");
		ll.traverseLinkList();

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
