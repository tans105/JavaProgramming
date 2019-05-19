package queue;

public class Queue {
	public int front;
	public int rear;
	public int[] queue;
	public int size;

	public Queue(int size) {
		this.size = size;
		front = -1;
		rear = 0;
		queue = new int[size];

	}

    public void enqueue(int num) {
		
		if (front < size-1) {
			front++;
			queue[front] = num;
			System.out.println("Enqueued :" + num);
		} else {
			System.out.println("Overflow");
		}
	}

	public void dequeue() {
		if (front >= rear) {

			rear++;

		} else {
			System.out.println("Underflow");
		}

	}

	public void display() {
		while (front > rear) {
			System.out.println(queue[rear++]);
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		
		q.dequeue();
		q.enqueue(6);
		
		

	}

}
