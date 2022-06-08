package competitiveProgramming.leetcode.topinterviewquestions;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz


Follow up: Could you do this in one pass?
 */
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        LinkedListUtil.printList(removeNthFromEnd(LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5}), 2));
        LinkedListUtil.printList(removeNthFromEnd(LinkedListUtil.populateList(new int[]{1, 2}), 1));
        LinkedListUtil.printList(removeNthFromEnd(LinkedListUtil.populateList(new int[]{1}), 1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {return head;}

        int toBeDeleted = length(head) - n;
        ListNode node = head;
        ListNode prev = null;
        int i = 0;

        while (i != toBeDeleted) {
            prev = node;
            node = node.next;
            i++;
        }

        if (prev != null) {
            prev.next = node.next;
            node.next = null;
            return head;
        }
        else {
            return head.next;
        }

    }

    public static int length(ListNode head) {
        int length = 0;
        ListNode n = head;

        while (n != null) {
            length++;
            n = n.next;
        }

        return length;
    }
}
