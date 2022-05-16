package competitiveProgramming.leetcode;

import utils.LoggingUtil;

import java.util.*;

/*
763. Partition Labels

https://leetcode.com/problems/partition-labels/

A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
 */
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("caedbdedda"));
        System.out.println(partitionLabels("eaaaabaaec"));
        System.out.println(partitionLabels("vhaagbqkaq"));

    }

    public static List<Integer> partitionLabels(String s) {
        Map<Character, int[]> map = new HashMap<>();
        List<int[]> intervals = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int largestIndex = -1;
        int largestEndIndex = -1;
        int smallestIndex = Integer.MAX_VALUE;
        int smallestEndIndex = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new int[]{i, -1});
                largestIndex = Math.max(largestIndex, i);
                smallestIndex = Math.min(smallestIndex, i);
            } else {
                int[] arr = map.get(c);
                arr[1] = i;
                smallestEndIndex = Math.min(smallestEndIndex, arr[0]);
                largestEndIndex = Math.max(largestEndIndex, i);
                map.put(c, arr);
            }
        }

        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            if (entry.getValue()[1] != -1) {
                intervals.add(entry.getValue());
            }
        }

        intervals.sort(Comparator.comparingInt(a -> a[0]));

        if (smallestIndex < smallestEndIndex) {
            for (int i = 0; i < smallestEndIndex - smallestIndex; i++) {
                result.add(1);
            }
        }

        mergeIntervals(intervals, result);

        if (largestIndex > largestEndIndex) {
            for (int i = 0; i < largestIndex - largestEndIndex; i++) {
                result.add(1);
            }
        }
        return result;
    }

    private static void mergeIntervals(List<int[]> intervals, List<Integer> result) {
        Stack<int[]> stack = new Stack<>();
        int currentIndex = 0;

        while (currentIndex < intervals.size()) {
            int[] currentInterval = intervals.get(currentIndex);

            if (stack.isEmpty()) {
                stack.push(intervals.get(currentIndex));
            } else {
                int[] top = stack.pop();
                /**
                 * Case 1 : Independent
                 * Case 2: Partially
                 * Case 3: Overlapped
                 */
                if (currentInterval[0] > top[1]) { //independent
                    stack.push(top);
                    stack.push(currentInterval);
                } else if (currentInterval[0] < top[1] && currentInterval[0] > top[0] && currentInterval[1] > top[1]) { //partially
                    stack.push(new int[]{top[0], currentInterval[1]});
                } else {
                    stack.push(top);
                }
            }
            currentIndex++;
        }

        for (int[] arr : stack) {
            result.add(arr[1] - arr[0] + 1);
        }
    }

}
