package competitiveProgramming.geekforgeeks.phase1;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/sort-a-stack-using-recursion/

Sort a stack using recursion

Given a stack, sort it using recursion. Use of any loop constructs like while, for..etc is not allowed. We can only use the following ADT functions on Stack S:
is_empty(S)  : Tests whether stack is empty or not.
push(S)         : Adds new element to the stack.
pop(S)         : Removes top element from the stack.
top(S)         : Returns value of the top element. Note that this
               function does not remove element from the stack.
Example:

Input:  -3  <--- Top
        14
        18
        -5
        30

Output: 30  <--- Top
        18
        14
        -3
        -5
 */
public class SortStackUsingRecursion {
    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) {

        st.push(1);
        st.push(4);
        st.push(3);
        st.push(2);

        System.out.println("Original Stack: " + st);
        sort();
        System.out.println("Reversed Stack: " + st);
    }

    private static void sort() {
        if (st.size() > 0) {
            int num = st.pop();
            sort();
            insertFromBottom(num);
        }
    }

    private static void insertFromBottom(int num) {
        if (st.size() == 0 || st.peek() < num) {
            st.push(num);
        } else {
            int n = st.pop();
            insertFromBottom(num);
            st.push(n);
        }
    }
}
