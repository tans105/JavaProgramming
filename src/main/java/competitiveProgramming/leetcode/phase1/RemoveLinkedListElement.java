package competitiveProgramming.leetcode.phase1;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

/*
203. Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */
public class RemoveLinkedListElement {
    public static void main(String[] args) {
        ListNode node = LinkedListUtil.populateList(new int[]{6, 1, 2, 6, 3, 4, 5, 6});
        ListNode head = removeElements(node, 6);
        LinkedListUtil.printList(head);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode n = head;
        ListNode prev = null;

        while (n != null) {
            if (n.val == val) {
                if (prev == null) {
                    ListNode temp = n;
                    n = n.next;
                    temp.next = null;
                    head = n;
                    continue;
                } else {
                    ListNode temp = n;
                    n = n.next;
                    prev.next = temp.next;
                    temp.next = null;
                    continue;
                }
            }
            prev = n;
            n = n.next;
        }

        return head;
    }
}
