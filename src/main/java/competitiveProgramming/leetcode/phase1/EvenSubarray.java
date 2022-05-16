package competitiveProgramming.leetcode.phase1;

import java.util.*;

/*
https://leetcode.com/discuss/interview-question/278341/Uber-phone-interview-Number-of-distinct-subarrays-with-at-most-k-odd-elements/265140
Given an integer array nums, find number of distinct contiguous subarrays with at most k odd elements. Two subarrays are distinct when they have at least one different element.
 */

public class EvenSubarray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 9, 5);
        System.out.println(evenSubarray(list, 2));
    }

    private static int evenSubarray(List<Integer> list, int oddNumberLimit) {
        Set<String> distinctSubArray = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                StringBuilder builder = new StringBuilder();
                int oddCount = 0;
                for (int k = i; k <= j; k++) {
                    if (list.get(k) % 2 != 0) {
                        oddCount++;
                    }
                    builder.append(list.get(k));
                }
                if (oddCount <= oddNumberLimit) distinctSubArray.add(builder.toString());
            }
        }

        return distinctSubArray.size();
    }

}
