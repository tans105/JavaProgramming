package competitiveProgramming.leetcode;

import algorithms.sorting.QuickSort;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
215. Kth Largest Element in an Array

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
 */
public class KLargestElement {
    public static void main(String[] args) {

        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest3(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // create an min-heap using PriorityQueue class and insert
        // first k elements of the array into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(list.subList(0, k));

        // do for remaining array elements
        for (int i = k; i < list.size(); i++) {
            // if current element is more than the root of the heap
            if (list.get(i) > pq.peek()) {
                // replace root with the current element
                pq.poll();
                pq.add(list.get(i));
            }
        }

        // return the root of min-heap
        return pq.peek();
    }

    private static int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = QuickSort.partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private static int findKthLargest3(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        helper(nums, k, lo, hi);
        return nums[k];
    }

    private static void helper(int[] nums, int k, int lo, int hi) {
        final int j = QuickSort.partition(nums, lo, hi);
        if (j < k) {
            lo = j + 1;
            helper(nums, k, lo, hi);
        } else if (j > k) {
            hi = j - 1;
            helper(nums, k, lo, hi);
        }
    }
}
