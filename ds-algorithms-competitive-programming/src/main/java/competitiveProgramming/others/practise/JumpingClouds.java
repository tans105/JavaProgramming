package competitiveProgramming.others.practise;

import java.util.Scanner;

public class JumpingClouds {
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
		JumpingClouds ll = new JumpingClouds();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		ll.head = new Node(sc.nextInt());
		Node node = ll.head;

		for (int i = 0; i < n - 1; i++) {
			node.next = new Node(sc.nextInt());
			node = node.next;
		}
		node.next = null;
		int count = 0;
		Node inode = ll.head;

		while (inode.next != null) {
			if (inode.next.data == 1) {
				if (inode.next.next == null) {
					count++;
					break;
				} else {
					count++;
					inode = inode.next.next;
					if (inode.next == null) {
						break;
					}
				}
			} else {
				if (inode.next.next == null) {
					count++;
					break;
				}
				if (inode.next.next.data == 0) {
					count++;
					inode = inode.next.next;
					if (inode.next == null) {
						break;
					}
				}
				if (inode.next.next.data == 1) {
					count++;
					inode = inode.next;
					if (inode.next == null) {
						break;
					}
				}

			}

		}

		System.out.println(count);

	}

}
