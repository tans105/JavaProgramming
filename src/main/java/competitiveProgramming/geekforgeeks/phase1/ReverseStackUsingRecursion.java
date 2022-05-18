package competitiveProgramming.geekforgeeks.phase1;

import java.util.Stack;

/*
Reverse a stack using recursion
https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/

Write a program to reverse a stack using recursion. You are not allowed to use loop constructs like while, for..etc, and you can only use the following ADT functions on Stack S:
isEmpty(S)
push(S)
pop(S)

 */
public class ReverseStackUsingRecursion {
    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) {

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println("Original Stack: " + st);
        reverse();
        System.out.println("Reversed Stack: " + st);
    }

    private static void reverse() {
        if (st.size() > 0) {
            int num = st.pop();
            reverse();
            insertFromBottom(num);
        }
    }

    private static void insertFromBottom(int num) {
        if (st.size() == 0) {
            st.push(num);
        } else {
            int n = st.pop();
            insertFromBottom(num);
            st.push(n);
        }
    }
}
