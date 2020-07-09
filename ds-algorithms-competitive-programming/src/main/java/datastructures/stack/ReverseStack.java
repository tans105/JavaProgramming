package datastructures.stack;

public class ReverseStack {
	private int maxSize;
	private String[] stackArray;
	private int top;

	public ReverseStack(int s) {
		maxSize = s;
		stackArray = new String[maxSize];
		top = -1;
	}

	public void push(String j) {
		stackArray[++top] = j;
	}

	public String pop() {
		return stackArray[top--];
	}

	public String peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public static void main(String[] args) {
		Stack theStack = new Stack(10);
		theStack.push("A");
		theStack.push("B");
		theStack.push("C");
		theStack.push("D");
		theStack.push("E");
		String reverse = "";
		while (!theStack.isEmpty()) {
			reverse = reverse + theStack.pop();
		}
		System.out.println(reverse);

	}

}