package Utils;

public class LinkedListUtil {
    public static final String LL_SEPARATOR = " -> ";

    public static ListNode populateList(int[] arr, ListNode head) {
        ListNode n = head;
        ListNode head1 = n;
        for (int i : arr) {
            n.next = new ListNode(i);
            n = n.next;
        }

        return head1;
    }

    public static ListNode populateList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode n = new ListNode(arr[0]);
        ListNode head1 = n;
        for (int i = 1; i < arr.length; i++) {
            n.next = new ListNode(arr[i]);
            n = n.next;
        }

        return head1;
    }

    public static void printList(ListNode head) {
        ListNode n = head;
        while (n != null) {
            System.out.print(n.val + LL_SEPARATOR);
            n = n.next;
        }

        System.out.print("null");
    }
}
