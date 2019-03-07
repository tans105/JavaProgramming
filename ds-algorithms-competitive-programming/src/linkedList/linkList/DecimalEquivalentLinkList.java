package linkedList.linkList;
/*
 * given a link list having binary keys, the program will convert the linklist to the equivalent decimal expression
 */
public class DecimalEquivalentLinkList {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;

		}
	}

	public static void main(String args[]) {
		DecimalEquivalentLinkList ll = new DecimalEquivalentLinkList();
		ll.head = new Node(1);
		ll.head.next = new Node(1);
		ll.head.next.next = new Node(0);
		ll.head.next.next.next = new Node(1);
		ll.head.next.next.next.next = new Node(1);
		ll.head.next.next.next.next.next = new Node(1);
		ll.head.next.next.next.next.next.next = new Node(1);
		ll.head.next.next.next.next.next.next.next = null;


		System.out.println(ll.computeBinary(ll.length()));
	}
	
	public int length() {
		Node n = head;
		int count = 0;
		while (n != null) {
			count++;
			n = n.next;
		}
		return count;
	}

	public int computeBinary(int length) {
		int sum = 0;
		Node n = head;
		for (int i = length - 1; i >= 0; i--) {

			
			sum=(int) (sum+(n.data*Math.pow(2, i)));
			n = n.next;
			

		}
		return sum;

	}
}
