package competitiveProgramming.leetcode.topinterviewquestions;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

/*
https://leetcode.com/problems/add-two-numbers/

2. Add Two Numbers
Medium

18383

3758

Add to List

Share
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = LinkedListUtil.populateList(new int[]{2, 4, 3});
        ListNode l2 = LinkedListUtil.populateList(new int[]{5, 6, 4});

        LinkedListUtil.printList(addTwoNumbers(l1, l2));

        l1 = LinkedListUtil.populateList(new int[]{0});
        l2 = LinkedListUtil.populateList(new int[]{0});

        LinkedListUtil.printList(addTwoNumbers(l1, l2));

        l1 = LinkedListUtil.populateList(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = LinkedListUtil.populateList(new int[]{9, 9, 9, 9});

        LinkedListUtil.printList(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode n3 = null;
        ListNode head = null;

        int carry = 0;


        while (n1 != null && n2 != null) {
            int sum = n1.val + n2.val + carry;

            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            if (n3 == null) {
                n3 = new ListNode(sum);
                head = n3;
            } else {
                n3.next = new ListNode(sum);
                n3 = n3.next;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        while (n1 != null) {
            int sum = n1.val + carry;

            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            if (n3 == null) {
                n3 = new ListNode(sum);
                head = n3;
            } else {
                n3.next = new ListNode(sum);
                n3 = n3.next;
            }

            n1 = n1.next;
        }

        while (n2 != null) {
            int sum = n2.val + carry;

            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            if (n3 == null) {
                n3 = new ListNode(sum);
                head = n3;
            } else {
                n3.next = new ListNode(sum);
                n3 = n3.next;
            }

            n2 = n2.next;
        }

        if(carry == 1) {
            n3.next = new ListNode(1);
        }

        return head;
    }
}
