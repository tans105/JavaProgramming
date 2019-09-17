package competitiveProgramming.leetcode;

/*
128. Longest Consecutive Sequence

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    private static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longestStreak = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num + 1, currentStreak = 1;
                while (set.contains(current)) {
                    currentStreak++;
                    current++;
                }

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            }
        }

        return longestStreak;
    }
}
