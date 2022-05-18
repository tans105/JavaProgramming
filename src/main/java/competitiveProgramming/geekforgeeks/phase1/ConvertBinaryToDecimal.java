package competitiveProgramming.geekforgeeks.phase1;


import utils.LinkedListUtil;
import utils.pojo.ListNode;


/*
https://www.geeksforgeeks.org/decimal-equivalent-of-binary-linked-list/

Decimal Equivalent of Binary Linked List

Given a singly linked list of 0s and 1s find its decimal equivalent.

   Input  : 0->0->0->1->1->0->0->1->0
   Output : 50

   Input  : 1->0->0
   Output : 4
Decimal Value of an empty linked list is considered as 0.
 */

public class ConvertBinaryToDecimal {
    public static void main(String[] args) {
        utils.pojo.ListNode node = LinkedListUtil.populateList(new int[]{0, 1, 0, 0, 1, 1});
        System.out.println(getNumber(node));
    }

    public static long getNumber(utils.pojo.ListNode binary) {
        ListNode node = reverseIterative(binary);
        LinkedListUtil.printList(node);
        long value = 0;
        int i = 0;

        while (node != null) {
            value += node.val * Math.pow(2, i++);
            node = node.next;
        }
        return value;
    }


    private static utils.pojo.ListNode reverseIterative(utils.pojo.ListNode node) {
        utils.pojo.ListNode prev = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
