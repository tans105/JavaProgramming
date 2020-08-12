package competitiveProgramming.interview.microsoft;

import utils.LinkedListUtil;
import utils.LoggingUtil;
import utils.pojo.ListNode;

/*
Exp: https://www.geeksforgeeks.org/microsoft-interview-experience-for-sde-1/

Original: https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/

Reverse a Linked List in groups of given size | Set 1

Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

Example:

    Input: 1->2->3->4->5->6->7->8->NULL, K = 3
    Output: 3->2->1->6->5->4->8->7->NULL

    Input: 1->2->3->4->5->6->7->8->NULL, K = 5
    Output: 5->4->3->2->1->8->7->6->NULL
 */
public class ReverseLinkedListInGroup {
    public static void main(String[] args) {
        ListNode node;

        node = LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        LinkedListUtil.printList(reverse(node, 3));

        node = LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        LinkedListUtil.printList(reverse(node, 5));
    }

    private static ListNode reverse(ListNode node, int k) {
        if(node == null ) return null;

        ListNode n = node;
        ListNode prev = null;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            if (n == null) break;
            next = n.next;
            n.next = prev;
            prev = n;
            n = next;
        }

        node.next = reverse(next, k);
        return prev;
    }
}
