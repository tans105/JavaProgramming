package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.april.week2;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

/*
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3290/

Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.

 */
public class MiddleElement {
    public static void main(String[] args) {
        ListNode node = LinkedListUtil.populateList(new int[]{1, 2, 3, 5, 6});
        System.out.println(middleNode(node));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode n = head;
        ListNode fastN = head;

        while (fastN != null && fastN.next != null) {
            n = n.next;
            fastN = fastN.next.next;
        }

        return n;
    }
}
