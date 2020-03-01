package competitiveProgramming.geekforgeeks.mustdoquestions.linkedlist;


import datastructures.linkedList.linkList.LinkedList;
import utils.LinkedListUtil;
import utils.pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
Reverse a Linked List in groups of given size.

https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1

Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.

Input:
First line of input contains number of testcases T. For each testcase, first line contains length of linked list and next line contains the linked list elements.

Output:
For each testcase, there will be a single line of output which contains the linked list with every k group elements reversed.

User Task:
The task is to complete the function reverse() which should reverse the linked list in group of size k.

Example:
Input:
1
8
1 2 2 4 5 6 7 8
4

Output:
4 2 2 1 8 7 6 5

Explanation:
Testcase 2: Since, k = 4. So, we have to reverse everty group of two elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.
 */
public class ReverseLinkedListinAGroupOfGivenSize {
    public static void main(String[] args) {
//        ListNode node = LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
//        LinkedListUtil.printList(reverse(node, 2));
        ListNode node = LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        LinkedListUtil.printList(reverseInGroup(node, 2));
    }


    static ListNode reverse(ListNode head, int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }

    private static ListNode reverseInSize(ListNode node, int k) {
        if (node == null) return null;

        ListNode n = node;
        ListNode start = node;
        List<ListNode[]> listNodes = new ArrayList<>();

        while (n != null) {
            int i = 0;
            while (i < k - 1 && n != null) {
                n = n.next;
                i++;
            }

            if (n == null) {
                listNodes.add(reverse(start));
                break;
            } else {
                ListNode temp = n.next;
                n.next = null;
                listNodes.add(reverse(start));
                start = temp;
                n = start;
            }
        }

        for (int i = 0; i < listNodes.size() - 1; i++) {
            ListNode[] currentSegment = listNodes.get(i);
            ListNode[] nextSegment = listNodes.get(i + 1);
            ListNode[] prevSegment = null;
            if (i != 0) prevSegment = listNodes.get(i - 1);

            if (prevSegment == null) {
                currentSegment[1].next = nextSegment[0];
            } else {
                prevSegment[1].next = currentSegment[0];
                currentSegment[1].next = nextSegment[0];
            }
        }

        return listNodes.get(0)[0];
    }

    private static ListNode[] reverse(ListNode node) {
        ListNode prev = null;
        ListNode head = node;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return new ListNode[]{prev, head};
    }

    private static ListNode reverseInGroup(ListNode node, int k) {
        ListNode current = node;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;

        while (current != null && count != k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) node.next = reverseInGroup(next, k);

        return prev;
    }
}
