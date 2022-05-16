package competitiveProgramming.leetcode.phase1;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

/**
 * Remove Duplicates from Sorted List II
 * Medium
 * <p>
 * 902
 * <p>
 * 76
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a sorted linked list, delete all duplicate nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->3->4->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        //1->2->3->3->4->4->5
        ListNode head = LinkedListUtil.populateList(new int[]{2, 3, 3, 4, 4, 5, 5}, new ListNode(1));
        LinkedListUtil.printList(deleteDuplicates(head));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        ListNode head1 = prev;//keeping record
        ListNode n = head;
        n = n.next;
        boolean removeDuplicate = false;
        while (n != null) {
            if (prev.val == n.val) {
                removeDuplicate = true;
            } else if (prev.val != n.val && removeDuplicate) {
                removeDuplicate = false;
                prev.next = n;
                prev = n;
            } else if (prev.val != n.val && !removeDuplicate) {
                prev = n;

            }
            n = n.next;
        }

        if(prev != n) {
            prev.next = null;
        }

        return head1;
    }
}
