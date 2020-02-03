package competitiveProgramming.mustdoquestions.linkedlist;


import utils.LinkedListUtil;
import utils.pojo.ListNode;

/*
https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1

Given a linked list of N nodes. The task is to reverse this list.

Input: Head of following linked list
1->2->3->4->NULL
Output: Linked list should be changed to,
4->3->2->1->NULL

Input: Head of following linked list
1->2->3->4->5->NULL
Output: Linked list should be changed to,
5->4->3->2->1->NULL

Input: NULL
Output: NULL

Input: 1->NULL
Output: 1->NULL

Input:
First line of input contains number of testcases T. For each testcase, first line contains length of linked list and next line contains the elements of linked list.

Output:
Reverse the linked list and return head of the modified list.

User Task:
The task is to complete the function reverseList() which head reference as the only argument and should return new head after reversing the list.

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
2
6
1 2 3 4 5 6
5
2 7 8 9 10

Output:
6 5 4 3 2 1
10 9 8 7 2

Explanation:
Testcase 1: After reversing the list, elements are as 6->5->4->3->2->1.
 */
public class ReverseLinkedList {

    //driver
    public static void main(String[] args) {
        ListNode node = LinkedListUtil.populateList(new int[]{1, 2, 3, 4});
        LinkedListUtil.printList(node);
        System.out.println();
        LinkedListUtil.printList(reverseIterative(node));
        node = LinkedListUtil.populateList(new int[]{1, 2, 3, 4});
        System.out.println();
        LinkedListUtil.printList(reverseRecursive(node));
    }

    private static ListNode reverseIterative(ListNode node) {
        ListNode prev = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    private static ListNode reverseRecursive(ListNode node) {
        return recurse(node, null);
    }

    private static ListNode recurse(ListNode node, ListNode prev) {
        if (node == null) {
            return prev;
        }

        ListNode next = node.next;
        node.next = prev;
        prev = node;
        return recurse(next, prev);
    }


}
