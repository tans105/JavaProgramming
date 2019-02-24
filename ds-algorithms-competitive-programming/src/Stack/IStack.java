package Stack;

public interface IStack {
    void push(String num);

    String pop();

    String peek();

    boolean isEmpty();

    void printStack();

    boolean isFull();

}
