package datastructures.stack;

public class BalancedParenthesesStack {
	private int maxSize;
	private String[] stackArray;
	private int top;

	public BalancedParenthesesStack(int s) {
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

	public String counterParentheses(String parentheses) {
		String counter = null;
		if (parentheses.equals("("))
			counter = ")";
		if (parentheses.equals("{"))
			counter = "}";
		if (parentheses.equals("["))
			counter = "]";
		if (parentheses.equals(")"))
			counter = "(";
		if (parentheses.equals("}"))
			counter = "{";
		if (parentheses.equals("]"))
			counter = "[";
		return counter;
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public static void main(String[] args) {
		String s = "[()]{}{[()()]}()";
		BalancedParenthesesStack theStack = new BalancedParenthesesStack(s.length());
		String peekVal = null;

		for (int i = 0; i < s.length(); i++) {
			peekVal = s.substring(i, i + 1);
			if (!theStack.isEmpty()) {
				if (theStack.counterParentheses(peekVal).equals(theStack.peek())) {
					theStack.pop();
				} else {
					theStack.push(peekVal);
				}
			} else {
				theStack.push(peekVal);
			}
		}
		if(theStack.isEmpty()){
			System.out.println("yes!");
		}
		else{
			System.out.println("no");
		}
	}
}