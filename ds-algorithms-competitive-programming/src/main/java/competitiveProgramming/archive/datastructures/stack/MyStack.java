package competitiveProgramming.archive.datastructures.stack;

public class MyStack implements IStack {

    private int size = 100;
    private String[] stackArr;
    private int top = -1;

    MyStack() {
        stackArr = new String[size];
    }

    MyStack(int size) {
        this.size = size;
        stackArr = new String[size];
    }


    @Override
    public void push(String num) {
        stackArr[++top] = num;
    }

    @Override
    public String pop() {
        return stackArr[top--];
    }

    @Override
    public String peek() {
        return stackArr[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(stackArr[i] + "\t");
        }
    }

    @Override
    public boolean isFull() {
        return !isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(6);
        stack.push("T");
        stack.push("A");
        stack.push("N");
        stack.push("M");
        stack.push("A");
        stack.push("Y");
        stack.printStack();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
