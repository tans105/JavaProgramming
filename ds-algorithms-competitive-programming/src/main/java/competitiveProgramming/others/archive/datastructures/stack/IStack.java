package competitiveProgramming.others.archive.datastructures.stack;

public interface IStack {
    void push(String num);

    String pop();

    String peek();

    boolean isEmpty();

    void printStack();

    boolean isFull();

}
