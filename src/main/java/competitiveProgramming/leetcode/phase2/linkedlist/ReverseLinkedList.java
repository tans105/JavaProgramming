package competitiveProgramming.leetcode.phase2.linkedlist;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

/*
https://leetcode.com/problems/reverse-linked-list/

206. Reverse Linked List
Easy

11897

206

Add to List

Share
Given the head of a singly linked list, reverse the list, and return the reversed list.



Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

 */
public class ReverseLinkedList {
    public static void main(String[] args) {
//        ListNode n = LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5});
//        LinkedListUtil.printList(reverseListIterative(n));
//        n = LinkedListUtil.populateList(new int[]{1, 2});
//        LinkedListUtil.printList(reverseListIterative(n));
//        n = LinkedListUtil.populateList(new int[]{1});
//        LinkedListUtil.printList(reverseListIterative(n));
//        LinkedListUtil.printList(reverseListIterative(null));

        ListNode n = LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5});
        LinkedListUtil.printList(reverseListRecursive(n));
//        n = LinkedListUtil.populateList(new int[]{1, 2});
//        LinkedListUtil.printList(reverseListRecursive(n));
//        n = LinkedListUtil.populateList(new int[]{1});
//        LinkedListUtil.printList(reverseListRecursive(n));
//        LinkedListUtil.printList(reverseListRecursive(null));
    }

    public static ListNode reverseListIterative(ListNode head) {
        ListNode n = head;
        ListNode prev = null;

        while (n != null) {
            ListNode next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }

        return prev;
    }

    /*
    https://www.youtube.com/watch?v=ugQ2DVJJroc
     */
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseListRecursive(head.next);
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
    }
}

