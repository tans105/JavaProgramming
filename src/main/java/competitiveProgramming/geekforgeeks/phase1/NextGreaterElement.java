package competitiveProgramming.geekforgeeks.phase1;

import java.util.Stack;

/*
https://www.geeksforgeeks.org/next-greater-element/

Next Greater Element
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:

For any array, rightmost element always has next greater element as -1.
For an array which is sorted in decreasing order, all elements have next greater element as -1.
For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.



  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12      -->     -1
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        nextGreaterElement(new int[]{98, 23, 54, 12, 20, 7, 27});
    }

    private static void nextGreaterElement(int[] arr) {
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            if (s.size() > 0) {
                while (current > s.peek()) {
                    System.out.println(s.peek() + " -> " + current);
                    if (s.isEmpty()) break;
                    s.pop();
                }
            }

            s.push(arr[i]);
        }

        while (!s.isEmpty()) {
            System.out.println(s.pop() + " -> " + -1);
        }
    }
}
