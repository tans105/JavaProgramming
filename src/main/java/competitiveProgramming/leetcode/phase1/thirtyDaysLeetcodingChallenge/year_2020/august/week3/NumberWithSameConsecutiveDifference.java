package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.august.week3;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3428/

Numbers With Same Consecutive Differences

Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.



Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.

Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]



Note:

    1 <= N <= 9
    0 <= K <= 9


 */
public class NumberWithSameConsecutiveDifference {
    public static void main(String[] args) {
        ArrayUtils.printArray(numsSameConsecDiff(4, 7));
    }

    public static int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) return new int[]{K};

        Set<String> sequences = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (Math.abs(i - j) == K) {
                    sequences.add(String.valueOf(i) + j);
                }
            }
        }

        int n = 2;

        while (n < N) {
            sequences = generate(sequences, n);
            n++;
        }

        List<Integer> ans = new ArrayList<>();

        for (String sequence : sequences) {
            if (sequence.charAt(0) != '0') {
                ans.add(Integer.parseInt(sequence));
            }
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private static Set<String> generate(Set<String> sequences, int n) {
        Set<String> newSequence = new HashSet<>();
        for (String sequence : sequences) {
            newSequence.add(sequence + sequence.charAt(sequence.length() - 2));
            newSequence.add(sequence.charAt(1) + sequence);
        }

        return newSequence;
    }

}
