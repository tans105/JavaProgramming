package competitiveProgramming.leetcode.topinterviewquestions;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        //        LinkedListUtil.printList(removeNthFromEnd(LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5}), 2));
        //        LinkedListUtil.printList(removeNthFromEnd(LinkedListUtil.populateList(new int[]{1, 2}), 1));
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
