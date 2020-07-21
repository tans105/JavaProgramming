package competitiveProgramming.archive.datastructures.linkedList.linkList;
/*
 * search middle elemet of the linklist
 * 
 */

public class PrintMiddleElementLinkList {
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
		PrintMiddleElementLinkList ll = new PrintMiddleElementLinkList();
		ll.head = new Node(0);
		ll.head.next = new Node(1);
		ll.head.next.next = new Node(2);
		ll.head.next.next.next = new Node(3);
		ll.head.next.next.next.next = new Node(4);
		ll.head.next.next.next.next.next = new Node(5);
		ll.head.next.next.next.next.next.next = new Node(6);
		ll.head.next.next.next.next.next.next.next=new Node(7);
		System.out.println(ll.printMiddleElement());
	}

	int printMiddleElement() {
		Node fastPtr = head;
		Node slowPtr = head;
		while (fastPtr!= null && fastPtr.next!=null) {
			slowPtr = slowPtr.next;
			fastPtr=fastPtr.next.next;
		}
		return slowPtr.data;
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
