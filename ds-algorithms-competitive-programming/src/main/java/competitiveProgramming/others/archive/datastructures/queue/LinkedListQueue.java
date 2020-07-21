package competitiveProgramming.others.archive.datastructures.queue;

public class LinkedListQueue {
	Node head;

	static class Node {
		Node next;
		int data;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String args[]) {
		LinkedListQueue llq = new LinkedListQueue();
		llq.head = null;
		llq.enqueue(0);
		llq.enqueue(1);
		llq.enqueue(2);
		llq.enqueue(3);
		llq.enqueue(4);
		llq.dequeue();
		llq.dequeue();
		llq.enqueue(6);
		llq.dequeue();
		llq.display();
	}

	public void enqueue(int key) {
		Node n = head;
		Node newNode = new Node(key);
		if (head == null) {
			head = newNode;
			newNode.next = null;
		} else {
			while (n.next != null) {
				n = n.next;
			}
			n.next = newNode;
			newNode.next = null;
		}
	}
	
	public void dequeue(){
		if(head==null){
			return;
		}
		Node n=head;
		head=n.next;
	}
	
	public void display() {
		Node n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}

}
