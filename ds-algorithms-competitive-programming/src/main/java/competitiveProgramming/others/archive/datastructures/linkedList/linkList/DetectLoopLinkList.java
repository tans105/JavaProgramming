package competitiveProgramming.others.archive.datastructures.linkedList.linkList;

import java.util.ArrayList;

public class DetectLoopLinkList {
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
		DetectLoopLinkList ll = new DetectLoopLinkList();
		ll.head = new Node(0);
		ll.head.next = new Node(1);
		ll.head.next.next = new Node(2);
		ll.head.next.next.next = new Node(3);
		ll.head.next.next.next.next = new Node(4);
		ll.head.next.next.next.next.next = new Node(5);
		ll.head.next.next.next.next.next.next = new Node(6);
		
		/*ll.traverseLinkList();*/
		System.out.println(ll.detectLoop());
	}

	public boolean detectLoop() {
		ArrayList<Node> arr = new ArrayList<Node>();
		Node n = head;
		boolean isLoop = false;
		while (n != null) {
			if (arr.contains(n)) {
				isLoop = true;
				break;
			}

			arr.add(n);
			n = n.next;
		}
		return isLoop;
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
