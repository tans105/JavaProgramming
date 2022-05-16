package competitiveProgramming.leetcode.phase1;

import java.util.HashMap;

/*
146. LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2   ); //capacity

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

 */

public class LRUCache {

    private int capacity;
    private int currentCapacity;
    private HashMap<Integer, DLLNode> lookup;
    private DoublyLinkedList linkedList;

    private LRUCache(int capacity) {
        this.capacity = capacity;
        lookup = new HashMap<>();
        linkedList = new DoublyLinkedList();
        currentCapacity = 0;
    }

    public int get(int key) {
        DLLNode node = lookup.get(key);
        if (node == null) {
            return -1;
        } else {
            linkedList.moveToHead(node);
        }
        linkedList.print();

        return node.value;

    }

    public void put(int key, int value) {
        if (!lookup.containsKey(key)) {
            DLLNode node = new DLLNode(key, value);
            if (currentCapacity != capacity) {
                linkedList.addAtStart(node);
                lookup.put(key, node);
                currentCapacity++;
            } else {
                DLLNode removedNode = linkedList.removeFromEnd();
                linkedList.addAtStart(node);
            }
        }
//        LoggingUtil.logNewLine(lookup);
        linkedList.print();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(7);
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
    private DLLNode head;
    private DLLNode tail;

    DoublyLinkedList() {
        head = new DLLNode();
        tail = new DLLNode();
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addAtStart(new DLLNode(1, 1));
        dll.addAtStart(new DLLNode(2, 2));
        dll.addAtStart(new DLLNode(3, 3));
        dll.print();
        dll.removeFromEnd();
        dll.print();
        dll.removeFromEnd();
        dll.print();
        dll.removeFromEnd();
        dll.print();
    }

    void addAtStart(DLLNode temp) {
        DLLNode back = head;
        DLLNode ahead = head.next;
        temp.next = ahead;
        back.next = temp;
        temp.prev = back;
        ahead.prev = temp;
    }

    DLLNode removeFromEnd() {
        DLLNode last = tail;
        DLLNode lastNotNullNode = last.prev;
        if (last.prev != null && last.prev.prev != null) {
            DLLNode temp = last.prev.prev;
            temp.next = tail;
            tail.prev = temp;
        }
        return lastNotNullNode;
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

    void moveToHead(DLLNode node) {
        removeFromList(node);
        addAtStart(node);
    }

    private void removeFromList(DLLNode node) {
        DLLNode savedPrev = node.prev;
        DLLNode savedNext = node.next;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }
}

class DLLNode {
    public Integer value;
    public Integer key;
    public DLLNode prev;
    public DLLNode next;

    DLLNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    DLLNode() {
        this.key = null;
        this.value = null;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "[value=" + value + ", key=" + key + "]";
    }
}
