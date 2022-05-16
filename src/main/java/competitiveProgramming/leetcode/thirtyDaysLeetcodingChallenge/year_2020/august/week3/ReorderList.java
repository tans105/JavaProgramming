package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.august.week3;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3430/

Reorder List

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.


 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode node = LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5});
        reorderList(node);
        LinkedListUtil.printList(node);

        node = LinkedListUtil.populateList(new int[]{1, 2, 3, 4});
        reorderList(node);
        LinkedListUtil.printList(node);

        node = LinkedListUtil.populateList(new int[]{1, 2});
        reorderList(node);
        LinkedListUtil.printList(node);

        node = LinkedListUtil.populateList(new int[]{1});
        reorderList(node);
        LinkedListUtil.printList(node);
    }

    public static void reorderList(ListNode head) {
        if(head == null ) return;

        Deque<ListNode> queue = new LinkedList<>();
        ListNode n = head;

        while (n != null) {
            ListNode temp = n.next;
            queue.offer(n);
            n.next = null;
            n = temp;
        }

        head = queue.pollFirst();
        n = head;
        n.next = queue.pollLast();
        n = n.next;

        while (!queue.isEmpty()) {
            n.next = queue.pollFirst();
            n = n.next;

            if(!queue.isEmpty()) {
                n.next = queue.pollLast();
                n = n.next;
            }
        }
    }
}
