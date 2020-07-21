package competitiveProgramming.archive.datastructures.stack;

/*
 * sorting a competitiveProgramming.archive.datastructures.stack using two competitiveProgramming.archive.datastructures.stack
 */
public class SortStack {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public SortStack(int s) {
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
		SortStack stack = new SortStack(10);
		SortStack auxStack = new SortStack(10);

		stack.push(1);
		stack.push(22);
		stack.push(13);
		stack.push(43);
		stack.push(11);
		stack.push(18);
		stack.push(10);
		stack.push(100);
		stack.push(152);
		stack.push(125);
		

		while (!stack.isEmpty()) {
			if (auxStack.isEmpty()) {
				auxStack.push(stack.pop());
			} else {
				int curr = stack.pop();

				if (curr > auxStack.peek()) {
					auxStack.push(curr);
				} else {
					int prev = auxStack.peek();
					while (true) {
						if (auxStack.isEmpty()) {
							break;
						}
						if (curr < auxStack.peek()) {
							stack.push(auxStack.pop());
						} else {
							break;
						}
					}

					auxStack.push(curr);
					while (stack.peek() != prev) {
						auxStack.push(stack.pop());
					}
					auxStack.push(stack.pop());
				}
			}
		}
		while (!auxStack.isEmpty()) {
			stack.push(auxStack.pop());
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
