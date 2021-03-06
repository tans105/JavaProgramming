package competitiveProgramming.others.archive.datastructures.linkedList.linkList;

/*
 * find nth node from the start 
 */
public class NthnodeLinkList {
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
		NthnodeLinkList ll = new NthnodeLinkList();
		ll.head = new Node(0);
		ll.head.next = new Node(1);
		ll.head.next.next = new Node(2);
		ll.head.next.next.next = new Node(3);
		ll.head.next.next.next.next = new Node(4);
		ll.head.next.next.next.next.next = new Node(5);
		ll.head.next.next.next.next.next.next = new Node(6);
		System.out.println(ll.getNthNode(4));
	}

	int getNthNode(int n) {
		Node node=head;
		for (int i = 0; i < n-1; i++) {
			node=node.next;
		}
		return node.data;
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
