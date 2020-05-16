package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week3;

import utils.LinkedListUtil;
import utils.LoggingUtil;
import utils.pojo.ListNode;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3331/

Odd Even Linked List
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode node = oddEvenList(LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5}));
        LinkedListUtil.printList(node);

        node = oddEvenList(LinkedListUtil.populateList(new int[]{2, 1, 3, 5, 6, 4, 7}));
        LinkedListUtil.printList(node);

        node = oddEvenList(LinkedListUtil.populateList(new int[]{2}));
        LinkedListUtil.printList(node);

        node = oddEvenList(LinkedListUtil.populateList(new int[]{2, 1}));
        LinkedListUtil.printList(node);

        node = oddEvenList(LinkedListUtil.populateList(new int[]{2, 1, 3}));
        LinkedListUtil.printList(node);
    }


    public static ListNode oddEvenList(ListNode head) {
        if(head == null) return head;

        ListNode i = head;
        ListNode j = head.next;

        while (j != null) {
            ListNode toBeMoved = j.next;
            if (toBeMoved == null) break;
            j.next = toBeMoved.next;

            j = j.next;

            toBeMoved.next = i.next;
            i.next = toBeMoved;

            i = toBeMoved;
        }

        return head;
    }
}
