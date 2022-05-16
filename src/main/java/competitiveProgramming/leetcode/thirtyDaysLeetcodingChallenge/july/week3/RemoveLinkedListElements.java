package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.july.week3;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3396/

Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5


 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode node;

        node = LinkedListUtil.populateList(new int[]{1, 2, 6, 3, 4, 5, 6});
        LinkedListUtil.printList(removeElements(node, 6));

        node = LinkedListUtil.populateList(new int[]{1, 2, 6, 3, 4, 5, 6});
        LinkedListUtil.printList(removeElements(node, 1));

        node = LinkedListUtil.populateList(new int[]{1, 2, 1, 3, 1, 5, 1});
        LinkedListUtil.printList(removeElements(node, 1));

        node = LinkedListUtil.populateList(new int[]{1});
        LinkedListUtil.printList(removeElements(node, 1));

        node = LinkedListUtil.populateList(new int[]{2, 2});
        LinkedListUtil.printList(removeElements(node, 2));

        node = LinkedListUtil.populateList(new int[]{2, 2, 3, 2, 2, 3});
        LinkedListUtil.printList(removeElements(node, 2));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode n = head;
        ListNode prev = null;

        while (n != null) {
            if (prev != null && n.val == val) {
                prev.next = n.next;
                n = n.next;
            } else if (n.val == val) {
                head = n.next;
                n = head;
                prev = null;
            } else {
                prev = n;
                n = n.next;
            }
        }

        return head;
    }
}
