package datastructures.stack;

public class NextGreaterElementStack {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public NextGreaterElementStack(int s) {
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int j) {
		stackArray[++top] = j;
	}

	public int pop() {
		return stackArray[top--];
	}

	public int peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public static void main(String[] args) {
		NextGreaterElementStack stack = new NextGreaterElementStack(5);
		Integer[] a = { 4, 5, 2, 25 };
		stack.push(a[0]);
		for (int i = 1; i < a.length; i++) {
			
			int next = a[i];
			if (next > stack.peek()) {
				int num = stack.pop();
				System.out.println(num + " : " + next);
				stack.push(next);
			} else {

				stack.push(next);
			}

		}
	}
}
