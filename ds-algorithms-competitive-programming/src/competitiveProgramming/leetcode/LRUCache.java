package competitiveProgramming.leetcode;

import java.util.HashMap;

public class LRUCache {

    private int capacity;
    HashMap<Integer, DLLNode> lookup;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lookup = new HashMap();
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}

class DoublyLinkedList {
    DLLNode head;
    DLLNode tail;


    public void addAtStart(int value) {
        DLLNode back = head;
        DLLNode ahead = head.next;
        DLLNode temp = new DLLNode(value);
        temp.next = ahead;
        back.next = temp;
        temp.prev = back;
        ahead.prev = temp;
    }

    public void removeFromEnd() {
        DLLNode last = tail;
        if (last.prev != null && last.prev.prev != null) {
            DLLNode temp = last.prev.prev;
            temp.next = tail;
            tail.prev = temp;
        }
    }

    public void print() {
        DLLNode n = head;
        if (n.next != null) {
            n = n.next;
            System.out.print("null " + "\t");
            while (n != null) {
                System.out.print(n.value + "\t");
                n = n.next;
            }
            System.out.println();
        }
    }

    public void printReverse() {
        DLLNode n = tail;
        if (n.prev != null) {
            n = n.prev;
            System.out.print("null " + "\t");
            while (n != null) {
                System.out.print(n.value + "\t");
                n = n.prev;
            }
            System.out.println();
        }
    }
}

class DLLNode {
    public Integer value;
    public DLLNode prev;
    public DLLNode next;

    public DLLNode(Integer value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public DLLNode() {
        this.value = null;
        this.next = null;
        this.prev = null;
    }
}
