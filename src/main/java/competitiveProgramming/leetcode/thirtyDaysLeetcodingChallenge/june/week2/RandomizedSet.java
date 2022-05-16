package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.june.week2;

import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/

Insert Delete GetRandom O(1)

Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 */
public class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.getRandom());
    }

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean inserted = false;
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            inserted = true;
        }
//        LoggingUtil.logNewLine("INSERTED", val, list, map);
        return inserted;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        boolean removed = false;
        if (map.containsKey(val)) {
            int index = map.get(val);
            int temp = list.get(list.size() - 1);
            list.set(list.size() - 1, list.get(index));
            list.set(index, temp);
            map.put(temp,index);
            list.remove(list.size() - 1);
            map.remove(val);
            removed = true;
        }
//        LoggingUtil.logNewLine("REMOVED", val, list, map);
        return removed;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
