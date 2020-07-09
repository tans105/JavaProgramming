package competitiveProgramming.random;

import java.util.Scanner;

public class JumpingCloudsRevisited {
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
		JumpingCloudsRevisited ll = new JumpingCloudsRevisited();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ll.head = new Node(sc.nextInt());
		Node node = ll.head;

		for (int i = 0; i < n - 1; i++) {
			node.next = new Node(sc.nextInt());
			node = node.next;
		}
		node.next = null;
		
		Node m = ll.head;
		int energy = 100;
		while (m != null) {
			if(m.data==1){
				energy=energy-3;
			}
			else{
				energy=energy-1;
			}
			for(int i=0;i<k;i++){
				m=m.next;
			}
		}
		System.out.println(energy);
		
		
		
		
	}
}
