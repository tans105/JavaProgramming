package competitiveProgramming.leetcode;


import utils.LinkedListUtil;
import utils.ListNode;


/**
 * https://leetcode.com/problems/partition-list/
 * 86. Partition List
 * Medium
 * <p>
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.populateList(new int[]{1, 4, 3, 2, 1, 5, 2, 2, 2});
//        LinkedListUtil.printList(head);
        LinkedListUtil.printList(partition(head, 3));
    }

    /**
     * 1 -> 4 -> 3 -> 2 -> 5 -> 2 -> null  1 1 4 1
     * 1 -> 4 -> 3 -> 2 -> 5 -> 2 -> null  4 1 3 4
     * 1 -> 4 -> 3 -> 2 -> 5 -> 2 -> null  4 1 2 3
     * 1 -> 2 -> 4 -> 3 -> 5 -> 2 -> null  4 2 5 3
     * 1 -> 2 -> 4 -> 3 -> 5 -> 2 -> null  5 2 2 5
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode n = head;
        ListNode back = head;
        ListNode front = head;
        ListNode prev = head;
        boolean start = false;
        boolean frontSet = false;
        while (n != null) {
            if (n.val > x) {
                if (!frontSet) {
                    back = prev;
                    front = n;
                    frontSet = true;
                } else {
                    prev = n;
                    n = n.next;
                }
                start = true;
            } else if (n.val < x && start) {
                //swap
                ListNode copy = new ListNode(n.val);
                back.next = copy;
                copy.next = front;
                n = n.next;
                prev.next = n;
                back = back.next;
            } else {
                prev = n;
                n = n.next;
            }
        }
        return head;
    }
}
