package Utils;

public class LinkedListUtil {
    public static ListNode populateList(int[] arr, ListNode head) {
        ListNode n = head;
        ListNode head1 = n;
        for (int i : arr) {
            n.next = new ListNode(i);
            n = n.next;
        }

        return head1;
    }

    public static void printList(ListNode head) {
        ListNode n = head;
        while (n != null) {
            System.out.println(n.val + "\t");
            n = n.next;
        }
    }
}
