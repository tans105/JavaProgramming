package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.october.week1;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3486/

Rotate List

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL

Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL


 */
public class RotateList {
    public static void main(String[] args) {
        ListNode node = LinkedListUtil.populateList(new int[]{1, 2, 3, 4, 5});
        LinkedListUtil.printList(rotateRight(node, 2));

        node = LinkedListUtil.populateList(new int[]{0, 1, 2});
        LinkedListUtil.printList(rotateRight(node, 4));

        node = LinkedListUtil.populateList(new int[]{1});
        LinkedListUtil.printList(rotateRight(node, 0));
    }

    public static ListNode rotateRight(ListNode node, int index) {
        if(node == null) return node;
        if(index == 0) return node;

        int length = getLength(node);
        int point = length - (index % length);

        ListNode prev = null;
        ListNode current = node;

        for (int i = 0; i < point; i++) {
            prev = current;
            current = current.next;
        }

        if (prev != null) prev.next = null;

        ListNode n = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;

        return n;
    }

    private static int getLength(ListNode node) {
        int len = 0;

        while (node != null) {
            len++;
            node = node.next;
        }

        return len;
    }
}
