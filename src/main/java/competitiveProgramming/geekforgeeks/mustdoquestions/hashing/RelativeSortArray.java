package competitiveProgramming.geekforgeeks.mustdoquestions.hashing;

import utils.ArrayUtils;
import java.util.*;

/*
https://practice.geeksforgeeks.org/problems/relative-sorting/0

Relative sorting

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.



Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]


Constraints:

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        ArrayUtils.printArray(relativeSortArray(ArrayUtils
                .parseArray("[2,3,1,3,2,4,6,7,9,2,19]"), ArrayUtils.parseArray("[2,1,4,3,9,6]")));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new TreeMap<>();
        int[] result = new int[arr1.length];

        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        int count = 0;
        for (int num : arr2) {
            if (countMap.containsKey(num)) {
                count = countMap.get(num);
                Arrays.fill(result, index, index + count, num);
                index = index + count;
                countMap.remove(num);
            }
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            Arrays.fill(result, index, index + entry.getValue(), entry.getKey());
            index = index + entry.getValue();
        }

        return result;
    }
}
