package competitiveProgramming.geekforgeeks.phase1;

import java.util.Stack;

public class MinStackII {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(1);
        stack.push(-1);


        while (!stack.isEmpty())
            System.out.print(stack.pop() + "\t");
    }
}

class MinStack {
    Stack<Integer> stack;
    Integer min;

    MinStack() {
        stack = new Stack<>();
        min = null;
    }

    public int getMin() {
        return min;
    }

    public String toString() {
        return stack.toString();
    }

    public void push(int x) {
        if (min == null) {
            min = x;
            stack.push(x);
        } else {
            if (x < min) {
                int temp = 2 * x - min;
                min = x;
                stack.push(temp);
            } else {
                stack.push(x);
            }
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            int value = stack.pop();
            if (value < min) {
                int temp = min;
                min = 2 * min - value;
                return temp;
            } else {
                return value;
            }
        }
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
