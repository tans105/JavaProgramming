package datastructures.linkedList.linkList;

public class ReorderList {
	Node head;

	static class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {
		ReorderList list = new ReorderList();
		list.head = new Node(0);
		list.head.next = new Node(1);
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(3);
		list.head.next.next.next.next = new Node(4);

		
		
		ReorderList list1 = new ReorderList();
		list1 = reverseList(list);
		System.out.print(" List :");
		traverseList(list);
		System.out.print("Reverse List :");
		traverseList(list1);
	}

	static void traverseList(ReorderList list) {
		Node n = list.head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	static ReorderList reverseList(ReorderList list) {
		ReorderList list1=new ReorderList();
		list1=list;
		Node currNode = list1.head;
		Node nextNode = null;
		Node prevNode = null;

		while (currNode != null) {

			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;

		}
		list.head = prevNode;
		return list1;
	}

}
