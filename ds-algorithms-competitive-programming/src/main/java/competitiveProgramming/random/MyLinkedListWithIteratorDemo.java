package competitiveProgramming.random;

import utils.LinkedListUtil;

import java.util.Iterator;

public class MyLinkedListWithIteratorDemo implements Iterable {
    ListNodeItr head = null;

    public static void main(String[] args) {
        MyLinkedListWithIteratorDemo list = new MyLinkedListWithIteratorDemo();
        list.head = new ListNodeItr(1);
        list.head.next = new ListNodeItr(2);
        list.head.next.next = new ListNodeItr(3);
        list.head.next.next.next = new ListNodeItr(4);

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

class ListNodeItr {
    public int val;
    public ListNodeItr next;

    ListNodeItr(int val) {
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
    ListNodeItr current;

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
