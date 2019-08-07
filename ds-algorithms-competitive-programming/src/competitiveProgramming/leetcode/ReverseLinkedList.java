package competitiveProgramming.leetcode;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

import java.util.Stack;

/**
 * 92. Reverse Linked List II
 * Medium
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5});
        LinkedListUtil.printList(reverseBetween(head, 1, 5));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == 0 || n == 0 || m > n) return head;

        ListNode node = head;
        int count = 0;
        ListNode startPoint = null;
        ListNode endPoint = null;
        Stack<ListNode> stack = new Stack<>();
        while (m > 0 && count != m - 1) {
            startPoint = node;
            node = node.next;
            count++;
        }

        while (count != n) {
            stack.push(node);
            node = node.next;
            count++;
        }
        endPoint = node;
        node = startPoint;

        if (node == null) {
            node = stack.pop();
            head = node;
        }

        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = endPoint;
        return head;
    }
}
