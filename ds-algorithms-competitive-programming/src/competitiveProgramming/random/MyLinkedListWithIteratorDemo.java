package competitiveProgramming.random;

import utils.LinkedListUtil;

import java.util.Iterator;

public class MyLinkedListWithIteratorDemo implements Iterable {
    ListNode head = null;

    public static void main(String[] args) {
        MyLinkedListWithIteratorDemo list = new MyLinkedListWithIteratorDemo();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);

        Iterator itr = list.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    // return Iterator instance
    public Iterator iterator() {
        return new ListIterator(this);
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class ListIterator implements Iterator {
    ListNode current;

    ListIterator(MyLinkedListWithIteratorDemo list) {
        current = list.head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        int data = current.val;
        current = current.next;
        return data;
    }
}
