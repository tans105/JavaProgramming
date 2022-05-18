package competitiveProgramming.geekforgeeks.phase1;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

import java.util.Stack;

/*
https://practice.geeksforgeeks.org/problems/reorder-list/1

Given a singly linked list: A0→A1→…→An-1→An,
reorder it to: A0→An→A1→An-1→A2→An-2→…

Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

It is recommended do this in-place without altering the nodes' values.
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode node = LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5, 6});
        LinkedListUtil.printList(node);
        LinkedListUtil.printList(reorderList(node));
    }

    private static ListNode reorderList(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode dummy = head;
        ListNode result = head;

        Stack<ListNode> stack = new Stack<>();

        while (fastPtr.next != null && fastPtr.next.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        ListNode curr = slowPtr;
        slowPtr = slowPtr.next;
        curr.next = null;

        while (slowPtr != null) {
            stack.push(slowPtr);
            slowPtr = slowPtr.next;
        }

        System.out.println();
        System.out.println(dummy);

        while(!stack.isEmpty()) {
            ListNode temp = dummy.next;
            dummy.next = stack.pop();
            dummy = dummy.next;
            dummy.next = temp;
            dummy = dummy.next;
        }

        return result;
    }
}
