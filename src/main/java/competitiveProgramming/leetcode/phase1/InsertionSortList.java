package competitiveProgramming.leetcode.phase1;

/*
147. Insertion Sort List

Sort a linked list using insertion sort.

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */

import utils.LinkedListUtil;
import utils.pojo.ListNode;

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode root = LinkedListUtil.populateList(new int[]{-1, 5, 3, 4, 0});
        LinkedListUtil.printList(insertionSortList(root));
    }

    private static ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode current = head.next;
        ListNode prev = head;
        while (current != null) {
            if (current.val < prev.val) {
                //Removing the current from the list
                ListNode nextNode = current.next;
                prev.next = current.next;
                current.next = null;

                //Adding the current back
                head = findSpotAndInsert(head, current);
                current = nextNode;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    private static ListNode findSpotAndInsert(ListNode head, ListNode current) {
        ListNode n = head;
        ListNode prev = null;
        if (current.val < head.val) {
            current.next = head;
            return current;
        } else {
            while (n != null) {
                if (prev != null && n.val > current.val) {
                    prev.next = current;
                    current.next = n;
                    break;
                }
                prev = n;
                n = n.next;
            }
        }
        return head;
    }
}
