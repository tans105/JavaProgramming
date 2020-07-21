package competitiveProgramming.archive.datastructures.linkedList.linkList;

import java.util.Stack;

public class PalindromeLinkList {
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
		PalindromeLinkList ll = new PalindromeLinkList();
		ll.head = new Node(1);
		ll.head.next = new Node(2);
		ll.head.next.next = new Node(3);
		ll.head.next.next.next = new Node(4);
		ll.head.next.next.next.next = new Node(3);
		ll.head.next.next.next.next.next = new Node(2);
		ll.head.next.next.next.next.next.next = new Node(1);
		ll.head.next.next.next.next.next.next.next = null;
		System.out.println(ll.isPalindrome());
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

	public boolean isPalindrome() {
		int len = length();
		Stack<Integer> stack = new Stack<Integer>();
		Node n = head;
		int counter = 0;
		int palindrome = 0;
		if (length() % 2 == 0) {
			while (counter != len / 2) {
				stack.push(n.data);
				counter++;
				n = n.next;
			}
			while (n != null) {
				if (n.data == Integer.parseInt(stack.pop().toString())) {
					palindrome++;
				}
				n = n.next;
			}
			if (palindrome == len / 2)
				return true;
		} else {
			Node prev = null;
			while (counter != (len / 2) + 1) {
				stack.push(n.data);
				counter++;
				prev = n;
				n = n.next;
			}
			while (prev != null) {
				int popItem = Integer.parseInt(stack.pop().toString());
				if (prev.data == popItem) {
					palindrome++;
				}
				prev = prev.next;
			}
			if (palindrome == len / 2 + 1)
				return true;
		}
		return false;

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
