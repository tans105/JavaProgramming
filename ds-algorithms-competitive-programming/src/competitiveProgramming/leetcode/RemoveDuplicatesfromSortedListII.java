package competitiveProgramming.leetcode;

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
        ListNode head = populateListNode(new int[]{2, 3, 3, 4, 4, 5}, new ListNode(1));
        printLL(deleteDuplicates(head));
    }

    private static ListNode populateListNode(int[] arr, ListNode head) {
        ListNode n = head;
        ListNode head1 = n;
        for (int i : arr) {
            n.next = new ListNode(i);
            n = n.next;
        }

        return head1;
    }

    private static void printLL(ListNode head) {
        ListNode n = head;
        while (n != null) {
            System.out.println(n.val + "\t");
            n = n.next;
        }
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

        return head1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
