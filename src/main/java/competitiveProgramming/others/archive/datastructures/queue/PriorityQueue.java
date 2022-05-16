package competitiveProgramming.others.archive.datastructures.queue;

public class PriorityQueue {
	Node head;

	static class Node {
		int data;
		int priority;
		Node next;

		Node(int d, int priority) {
			data = d;
			this.priority = priority;
		}
	}

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.head = new Node(1, 1);
		
		pq.enqueue(new Node(5, 0));
		pq.display();
		pq.deleteHighestPriority();
		pq.display();
	}

	public void enqueue(Node newNode) {
		Node n = head;

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

	public Integer getHighestPriority() {
		Node n = head;
		int highest = 0;
		while (n != null) {
			if (n.priority > highest)
				highest = n.data;
			n = n.next;
		}
		return highest;
	}

	public void display() {
		Node n = head;
		while (n != null) {
			System.out.println("key:" + n.data + " priority: " + n.priority);
			n = n.next;
		}
	}

	public void deleteHighestPriority() {
		int highest = getHighestPriority();
		Node n = head;
		if (head.priority == highest) {
			head = n.next;
		} else {
			while (n.next.priority != highest) {
				n = n.next;
			}
			Node prev = n;
			if (n.next.next == null) {
				prev.next = null;
			} else {
				// regular case
				prev.next = n.next;
				n.next = null;
			}
		}

	}
}
