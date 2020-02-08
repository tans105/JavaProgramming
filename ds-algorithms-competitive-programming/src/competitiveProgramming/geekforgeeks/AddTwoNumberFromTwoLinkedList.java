package competitiveProgramming.geekforgeeks;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

/*
https://www.geeksforgeeks.org/sum-of-two-linked-lists/

Add two numbers represented by linked lists | Set 2

Given two numbers represented by two linked lists, write a function that returns the sum list. The sum list is linked list representation of the addition of two input numbers. It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).

Example

Input:
  First List: 5->6->3  // represents number 563
  Second List: 8->4->2 //  represents number 842
Output
  Resultant list: 1->4->0->5  // represents number 1405
 */
public class AddTwoNumberFromTwoLinkedList {
    public static void main(String[] args) {
        ListNode num1 = LinkedListUtil.populateList(new int[]{9, 9, 9});
        ListNode num2 = LinkedListUtil.populateList(new int[]{9, 9, 9});
        ListNode num3 = add(num1, num2);
        LinkedListUtil.printList(num3);
    }

    private static ListNode add(ListNode num1, ListNode num2) {
        num1 = LinkedListUtil.reverse(num1);
        num2 = LinkedListUtil.reverse(num2);

        boolean carry = false;
        boolean head = false;
        ListNode prev = null;
        ListNode num3 = null;
        ListNode ref = null;

        while (num1 != null && num2 != null) {

            int sum = num1.val + num2.val;

            if (carry) {
                sum++;
            }

            if (sum > 9) {
                carry = true;
                num3 = new ListNode(sum - 10);
            } else {
                num3 = new ListNode(sum);
                carry = false;
            }

            if (!head) {
                prev = num3;
                ref = prev;
                head = true;
            } else {
                prev.next = num3;
                prev = num3;
            }

            num1 = num1.next;
            num2 = num2.next;
        }

        while (num1 != null) {
            int sum = 0;
            if (carry) {
                sum = num1.val + 1;
            }

            if (sum > 9) {
                carry = true;
                num3 = new ListNode(sum - 10);
            } else {
                num3 = new ListNode(sum);
                carry = false;
            }

            prev.next = num3;
            prev = num3;
            num1 = num1.next;
        }

        while (num2 != null) {
            int sum = 0;
            if (carry) {
                sum = num2.val + 1;
            }

            if (sum > 9) {
                carry = true;
                num3 = new ListNode(sum - 10);
            } else {
                num3 = new ListNode(sum);
                carry = false;
            }

            prev.next = num3;
            prev = num3;
            num2 = num2.next;
        }

        if (carry) {
            prev.next = new ListNode(1);
        }

        return LinkedListUtil.reverse(ref);
    }


}
