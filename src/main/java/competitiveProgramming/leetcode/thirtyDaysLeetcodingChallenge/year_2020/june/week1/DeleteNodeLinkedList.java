package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.june.week1;

import utils.LinkedListUtil;
import utils.pojo.ListNode;

/*
https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3348/

Delete Node in a Linked List
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:

Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
Example 2:

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.


Note:

The linked list will have at least two elements.
All of the nodes' values will be unique.
The given node will not be the tail and it will always be a valid node of the linked list.
Do not return anything from your function.
 */
public class DeleteNodeLinkedList {
    public static void main(String[] args) {
        ListNode node = LinkedListUtil.populateList(new int[]{4, 5, 1, 9});
        deleteNode(node);
        LinkedListUtil.printList(node);
    }

    public static void deleteNode(ListNode node) {
        ListNode n = node;
        ListNode prev = null;
        while (n.next != null) {
            n.val = n.next.val;
            prev = n;
            n = n.next;
        }
        prev.next =null;
    }
}
