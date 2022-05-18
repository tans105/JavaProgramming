package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week2;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/

Find the Town Judge
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.



Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3


Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
 */
public class FindTheTownJudge {
    public static void main(String[] args) {
        System.out.println(findJudge(2, ArrayUtils.parse2DArray("[[1,2]]")));
        System.out.println(findJudgeApproach2(2, ArrayUtils.parse2DArray("[[1,2]]")));

        System.out.println(findJudge(3, ArrayUtils.parse2DArray("[[1,3],[2,3]]")));
        System.out.println(findJudgeApproach2(3, ArrayUtils.parse2DArray("[[1,3],[2,3]]")));

        System.out.println(findJudgeApproach2(3, ArrayUtils.parse2DArray("[[1,3],[2,3],[3,1]]")));
        System.out.println(findJudge(3, ArrayUtils.parse2DArray("[[1,3],[2,3],[3,1]]")));

        System.out.println(findJudge(3, ArrayUtils.parse2DArray("[[1,2],[2,3]]")));
        System.out.println(findJudgeApproach2(3, ArrayUtils.parse2DArray("[[1,2],[2,3]]")));

        System.out.println(findJudge(4, ArrayUtils.parse2DArray("[[1,3],[1,4],[2,3],[2,4],[4,3]]")));
        System.out.println(findJudgeApproach2(4, ArrayUtils.parse2DArray("[[1,3],[1,4],[2,3],[2,4],[4,3]]")));
    }

    public static int findJudge(int N, int[][] trust) {
        if (trust == null) return -1;
        if (trust.length == 0 && N == 1) return 1;

        Map<Integer, Set<Integer>> m1 = new HashMap<>(); // map with member vs who all it trusts
        Map<Integer, Set<Integer>> m2 = new HashMap<>(); // map with member vs member who trust it


        for (int[] ints : trust) {
            Set<Integer> set1;
            Set<Integer> set2;
            if (m1.containsKey(ints[0])) {
                set1 = m1.get(ints[0]);
                set1.add(ints[1]);
                m1.put(ints[0], set1);
            } else {
                set1 = new HashSet<>();
                set1.add(ints[1]);
                m1.put(ints[0], set1);
            }


            if (m2.containsKey(ints[1])) {
                set2 = m2.get(ints[1]);
                set2.add(ints[0]);
                m2.put(ints[1], set2);
            } else {
                set2 = new HashSet<>();
                set2.add(ints[0]);
                m2.put(ints[1], set2);
            }
        }

        for (Map.Entry<Integer, Set<Integer>> entry : m2.entrySet()) {
            if (!m1.containsKey(entry.getKey()) && m2.containsKey(entry.getKey()) && m2.get(entry.getKey()).size() == N - 1)
                return entry.getKey();
        }

        return -1;
    }

    public static int findJudgeApproach2(int N, int[][] trust) {
        int[] inwards = new int[N];
        int[] outwards = new int[N];

        for (int[] set : trust) {
            inwards[set[0] - 1]++;
            outwards[set[1] - 1]++;
        }

        for (int i = 0; i < outwards.length; i++) if (outwards[i] == N - 1 && inwards[i] == 0) return i + 1;

        return -1;
    }
}