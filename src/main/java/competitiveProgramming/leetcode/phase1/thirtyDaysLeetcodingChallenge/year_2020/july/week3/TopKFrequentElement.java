package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.july.week3;

import utils.ArrayUtils;

import java.util.*;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/

Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
    It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
    You can return the answer in any order.


 */
public class TopKFrequentElement {
    public static void main(String[] args) {
//        ArrayUtils.printArray(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
//        ArrayUtils.printArray(topKFrequent2(new int[]{1, 1, 1, 2, 2, 3}, 2));

//        ArrayUtils.printArray(topKFrequent(new int[]{3, 0, 1, 0}, 1));
//        ArrayUtils.printArray(topKFrequent2(new int[]{3, 0, 1, 0}, 1));

        ArrayUtils.printArray(topKFrequent2(new int[]{1}, 1));
    }

    //Approach - 2 Using dummy buckets
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] listBucket = new ArrayList[nums.length + 1];

        for (int num : nums) countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        for (int key : countMap.keySet()) {
            int currentCount = countMap.get(key);
            List<Integer> list;

            if (listBucket[currentCount] != null) list = listBucket[currentCount];
            else list = new ArrayList<>();

            list.add(key);
            listBucket[currentCount] = list;
        }

        int[] result = new int[k];
        int resultIndex = 0;

        outerloop:
        for (int i = listBucket.length - 1; i >= 0; i--) {
            if (listBucket[i] != null) {
                List<Integer> list = listBucket[i];
                for (Integer o : list) {
                    if (resultIndex == k) break outerloop;
                    result[resultIndex] = o;
                    resultIndex++;
                }
            }
        }

        return result;
    }


    //Approach - 1 Using comparator
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> set = new ArrayList<>();

        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        FrequencyComparator<Integer> comparator = new FrequencyComparator<>(countMap);
        Collections.sort(set, comparator);

        System.out.println(set);
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = set.get(i);
        }

        return result;
    }

    private static class FrequencyComparator<Integer> implements Comparator<Integer> {
        Map<Integer, Integer> compareMap;

        FrequencyComparator(Map<Integer, Integer> compareMap) {
            this.compareMap = compareMap;
        }

        @Override
        public int compare(Integer o, Integer t1) {
            int o1 = (int) compareMap.get(o);
            int o2 = (int) compareMap.get(t1);
            return java.lang.Integer.compare(o2, o1);
        }
    }
}
