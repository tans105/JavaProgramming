package competitiveProgramming.leetcode.topinterviewquestions;
/*
21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */

import utils.LinkedListUtil;
import utils.pojo.ListNode;

public class MergeSortedLinkedList {
    public static void main(String[] args) {
        LinkedListUtil.printList(mergeTwoLists(LinkedListUtil.populateList(new int[]{1, 2, 4}),
                                               LinkedListUtil.populateList(new int[]{1, 3, 4})));

        LinkedListUtil.printList(mergeTwoLists(LinkedListUtil.populateList(new int[]{}),
                                               LinkedListUtil.populateList(new int[]{})));

        LinkedListUtil.printList(mergeTwoLists(LinkedListUtil.populateList(new int[]{}),
                                               LinkedListUtil.populateList(new int[]{0})));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return list1;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode n, head = null, list3 = null;
        boolean headAssigned = false;

        while (list1 != null && list2 != null) {
            int list1Val = list1.val;
            int list2Val = list2.val;

            if (list1Val <= list2Val) {
                n = new ListNode(list1Val);
                list1 = list1.next;
            }
            else {
                n = new ListNode(list2Val);
                list2 = list2.next;
            }

            if (!headAssigned) {
                head = n;
                list3 = head;
                headAssigned = true;
            }
            else {
                list3.next = n;
                list3 = list3.next;
            }
        }

        while (list1 != null) {
            int list1Val = list1.val;
            n = new ListNode(list1Val);

            if (!headAssigned) {
                head = n;
                list3 = head;
                headAssigned = true;
            }
            else {
                list3.next = n;
                list3 = list3.next;
            }

            list1 = list1.next;
        }

        while (list2 != null) {
            int list2Val = list2.val;
            n = new ListNode(list2Val);

            if (!headAssigned) {
                head = n;
                list3 = head;
                headAssigned = true;
            }
            else {
                list3.next = n;
                list3 = list3.next;
            }

            list2 = list2.next;
        }

        return head;
    }
}
