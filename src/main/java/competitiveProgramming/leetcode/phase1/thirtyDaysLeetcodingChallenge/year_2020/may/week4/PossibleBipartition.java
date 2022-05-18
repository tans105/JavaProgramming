package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week4;

import utils.ArrayUtils;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3342/

Possible Bipartition

Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group.

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.



Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false



Note:

    1 <= N <= 2000
    0 <= dislikes.length <= 10000
    1 <= dislikes[i][j] <= N
    dislikes[i][0] < dislikes[i][1]
    There does not exist i != j for which dislikes[i] == dislikes[j].


 */
public class PossibleBipartition {
    public static void main(String[] args) {
        System.out.println(possibleBipartition(4, ArrayUtils.parse2DArray("[[1,2],[1,3],[2,4]]")));
        System.out.println(possibleBipartition(3, ArrayUtils.parse2DArray("[[1,2],[1,3],[2,3]]")));
        System.out.println(possibleBipartition(5, ArrayUtils.parse2DArray("[[1,2],[2,3],[3,4],[4,5],[1,5]]")));
        System.out.println(possibleBipartition(10, ArrayUtils.parse2DArray("[[4,7],[4,8],[5,6],[1,6],[3,7],[2,5],[5,8],[1,2],[4,9],[6,10],[8,10],[3,6],[2,10],[9,10],[3,9],[2,3],[1,9],[4,6],[5,7],[3,8],[1,8],[1,7],[2,4]]")));
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> adjacencies = new ArrayList<>();
        getAdjacencies(N, adjacencies, dislikes);
        System.out.println(adjacencies);
        return dfs(adjacencies);
    }

    private static boolean dfs(List<List<Integer>> adjacencies) {
        Set<Integer> seen;

        for (int i = 0; i < adjacencies.size(); i++) {
            seen = new HashSet<>();
            seen.add(i);
            if (!dfs(adjacencies, i, seen, null)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(List<List<Integer>> adjacencies, int current, Set<Integer> seen, Integer prev) {
        List<Integer> adjacentPeople = adjacencies.get(current);

        for (Integer adjacentPerson : adjacentPeople) {
            if (adjacentPerson.equals(prev)) continue;
            if (seen.contains(adjacentPerson)) return false;
            seen.add(current);
            return dfs(adjacencies, adjacentPerson, seen, current);
        }

        return true;
    }


    private static void getAdjacencies(int n, List<List<Integer>> adjacencies, int[][] dislikes) {
        for (int i = 0; i < n; i++) {
            adjacencies.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes) {
            adjacencies.get(dislike[0] - 1).add(dislike[1] - 1);
            adjacencies.get(dislike[1] - 1).add(dislike[0] - 1);
        }
    }
}
