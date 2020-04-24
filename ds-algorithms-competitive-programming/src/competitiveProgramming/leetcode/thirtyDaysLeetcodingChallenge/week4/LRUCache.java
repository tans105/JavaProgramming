package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.week4;

import competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.week2.MinStack;
import utils.ArrayUtils;

import java.util.HashMap;

/*
https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3309/

LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( capacity  )

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
    private HashMap<Integer, Entry> hash;
    int currentCapacity;
    int totalCapacity;
    Entry head;
    Entry tail;

    static class Entry {
        Entry left;
        Entry right;

        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return "Entry{" + ", key=" + key + ", value=" + value + '}';
        }
    }

    public LRUCache(int capacity) {
        hash = new HashMap<>();
        totalCapacity = capacity;
        head = tail = null;
    }

    public int get(int key) {
        if (!hash.containsKey(key)) {
            return -1;
        } else {
            Entry entry = hash.get(key);
            remove(entry);
            addToFront(entry);
            return entry.value;
        }
    }

    public void put(int key, int value) {
        Entry entry;
        if (!hash.containsKey(key)) {
            entry = new Entry(key, value);
            currentCapacity++;
            if (currentCapacity > totalCapacity) {
                hash.remove(tail.key);
                removeFromEnd();
                currentCapacity--;
            }
            addToFront(entry);
            hash.put(key, entry);
        } else {
            entry = hash.get(key);
            remove(entry);
            entry.value = value;
            addToFront(hash.get(key));
        }
    }

    private void addToFront(Entry entry) {
        if (head == null) {
            head = tail = entry;
        } else {
            entry.right = head;
            head.left = entry;
            head = entry;
        }
    }

    private void removeFromEnd() {
        if (tail != null && tail.left != null) {
            tail.left.right = null;
            tail = tail.left;
        } else if (tail != null) {
            tail = null;
            head = null;
        }
    }

    private void remove(Entry node) {

        if (node.left != null) {
            node.left.right = node.right;
        } else {
            head = node.right;
        }

        if (node.right != null) {
            node.right.left = node.left;
        } else {
            tail = node.left;
        }
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"LRUCache", "put", "put", "get", "get", "put", "get", "get", "get"};
        Integer[][] values = {{2}, {2, 1}, {3, 2}, {3}, {2}, {4, 3}, {2}, {3}, {4}};
        apply(operations, values);
    }

    private static void apply(String[] operations, Integer[][] values) {
        LRUCache cache = null;
        Object[] response = new Object[operations.length];
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "LRUCache": {
                    response[i] = null;
                    cache = new LRUCache(values[i][0]);
                    continue;
                }
                case "put": {
                    response[i] = null;
                    cache.put(values[i][0], values[i][1]);
                    break;
                }

                case "get": {
                    response[i] = null;
                    response[i] = cache.get(values[i][0]);
                    break;
                }
            }
        }

        ArrayUtils.printArray(response);
    }
}
