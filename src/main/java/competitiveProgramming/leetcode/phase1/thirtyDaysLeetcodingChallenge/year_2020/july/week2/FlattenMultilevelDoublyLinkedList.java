package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.july.week2;

import utils.LoggingUtil;

/*
Flatten a Multilevel Doubly Linked List

You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.



Example 1:

Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]

Example 2:

Input: head = [1,2,null,3]
Output: [1,3,2]
Explanation:

The input multilevel linked list is as follows:

  1---2---NULL
  |
  3---NULL

Example 3:

Input: head = []
Output: []



How multilevel linked list is represented in test case:

We use the multilevel linked list from Example 1 above:

 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

The serialization of each level is as follows:

[1,2,3,4,5,6,null]
[7,8,9,10,null]
[11,12,null]

To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:

[1,2,3,4,5,6,null]
[null,null,7,8,9,10,null]
[null,11,12,null]

Merging the serialization of each level and removing trailing nulls we obtain:

[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]



Constraints:

    Number of Nodes will not exceed 1000.
    1 <= Node.val <= 10^5


 */
public class FlattenMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

        Node c1 = node.next.next;
        c1.child = new Node(7);
        c1 = c1.child;

        c1.next = new Node(8);
        c1.next.next = new Node(9);
        c1.next.next.next = new Node(10);

        c1 = c1.next;
        c1.child = new Node(11);
        c1 = c1.child;
        c1.next = new Node(12);

        Node n = flatten(node);
        System.out.println(n);
    }

    public static Node flatten(Node head) {
        Node n = head;

        while (n != null) {
            if (n.child == null) {
                n = n.next;
                continue;
            }
            Node nNext = n.next;
            Node temp = n.child;
            n.next = temp;
            n.child = null;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = nNext;
            n = n.next;

        }
        return head;
    }

    private static void printList(final Node node) {
        Node n = node;
        while (n != null) {
            LoggingUtil.logNewLine(n);
            n = n.next;
        }
    }

    static class Node {
        public int val;
        public Node next;
        public Node child;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", n=" + next +
                    ", c=" + child +
                    '}';
        }

        public Node(int val) {
            this.val = val;
        }

    }

}

