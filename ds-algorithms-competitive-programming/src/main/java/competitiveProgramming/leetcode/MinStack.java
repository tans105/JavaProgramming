package competitiveProgramming.leetcode;

import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
155. Min Stack

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

    private int[] arr;
    List<Integer> minList;
    int min = Integer.MAX_VALUE;
    private int capacity;
    private int currentIndex;

    public MinStack() {
        capacity = 5;
        arr = new int[capacity];
        minList = new ArrayList<>();
        currentIndex = -1;
    }

    public void push(int x) {
        if (currentIndex == capacity - 1) {
            arr = Arrays.copyOf(arr, arr.length + capacity);
        }
        if (x < min) {
            minList.add(x);
            min = x;
        }
        arr[++currentIndex] = x;
    }

    public void pop() {
//        LoggingUtil.logNewLine("Before", Arrays.toString(arr), minList, min, currentIndex);
        if (min == arr[currentIndex]) {
            minList.remove(minList.size() - 1);
            if (minList.size() > 0) min = minList.get(minList.size() - 1);
            else min = Integer.MAX_VALUE;
        }
        currentIndex--;
//        LoggingUtil.logNewLine("After", Arrays.toString(arr), minList, min, currentIndex);
    }

    public int top() {
        return arr[currentIndex];
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(-2);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }
}
