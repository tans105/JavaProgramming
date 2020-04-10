package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.week2;


import utils.LoggingUtil;

import java.util.Arrays;
import java.util.Stack;

/*
Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */
public class MinStack {
    Stack<Integer> stack;
    Integer min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }

        stack.push(x);
    }

    public void pop() {
        if (stack.pop().equals(min)) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    /**
     * Runner Method
     * @param args
     */
    public static void main(String[] args) {
        String[] operations = new String[]{"MinStack", "push", "push", "push", "push", "pop", "getMin", "pop", "getMin", "pop", "getMin"};
        Integer[] values = new Integer[]{null, 512, -1024, -1024, 512, null, null, null, null, null, null};
        apply(operations, values);
    }

    /**
     * Utility method to run bulk operations
     * @param operations - List of stack operations to be performed
     * @param values - Params needed for operations (if applicable)
     */
    private static void apply(String[] operations, Integer[] values) {
        MinStack minStack = new MinStack();
        Object[] response = new Object[operations.length];
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MinStack": {
                    response[i] = null;
                    continue;
                }
                case "push": {
                    response[i] = null;
                    minStack.push(values[i]);
                    break;
                }
                case "pop": {
                    response[i] = null;
                    minStack.pop();
                    break;
                }
                case "getMin": {
                    response[i] = minStack.getMin();
                    break;
                }
                case "top": {
                    response[i] = minStack.top();
                    break;
                }
            }
        }
    }
}
