package competitiveProgramming.random;

/*
There are a list of nodes that you are banned to visit,
Given the list path, count the number of ways in which we can travel. You are starting from 0th index /node 1

thieves = new int[]{2, 3, 4};
edges= [[1,2],[1,6],[2,3],[2,4],[2,5]]

Total possible paths =>

1 - 2
1 - 6
1 - 2 - 5
1 - 2 - 3
1 - 2 - 4

Out of which you can only visit 1 - 6 because 2,3,4 are banned to visit

 */
import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VisitTemple {
    public static void main(String[] args) {
        int[] thieves;
        int[][] edges;
        int n;
        int k;

        thieves = new int[]{2, 3, 4};
        edges= ArrayUtils.parse2DArray("[[1,2],[1,6],[2,3],[2,4],[2,5]]");
        n = 6;
        k= 3;

        System.out.println(Solution(thieves, edges, n, k));


        thieves = new int[]{4};
        edges = ArrayUtils.parse2DArray("[[1,2],[2,3],[1,4]]");
        n = 4;
        k = 4;

        System.out.println(Solution(thieves, edges, n, k));

    }

    static int Solution(int[] thieves, int[][] edges, int n, int k) {
        count = 0;
        List<List<Integer>> adjacencies = new ArrayList<>();
        Set<Integer> seen;
        Set<Integer> thievesSet = new HashSet<>();

        for (int thief : thieves) {
            thievesSet.add(thief - 1);
        }

        for (int i = 0; i < n; i++) adjacencies.add(new ArrayList<>());

        getAdjacencies(edges, adjacencies);
        List<Integer> neighbours = adjacencies.get(0);

        for (int i = 0; i < neighbours.size(); i++) {
            seen = new HashSet<>();
            seen.add(0);
            checkRecursive(seen, adjacencies, neighbours.get(i), thievesSet);
        }

        return count;
    }

    private static void checkRecursive(Set<Integer> seen, List<List<Integer>> adjacencies, int current, Set<Integer> thievesSet) {
        if (!seen.contains(current) && !thievesSet.contains(current)) {
            seen.add(current);
            count++;
            List<Integer> neighbours = adjacencies.get(current);

            for (Integer neighbour : neighbours) {
                if(seen.contains(neighbour)) continue;
                checkRecursive(seen, adjacencies, neighbour, thievesSet);
            }
        }
    }

    static int count = 0;

    private static void getAdjacencies(int[][] prerequisites, List<List<Integer>> adjcies) {
        for (int[] prerequisite : prerequisites) {
            List<Integer> adjacents = new ArrayList<>();
            if (adjcies.get(prerequisite[0] - 1).size() != 0) adjacents = adjcies.get(prerequisite[0] - 1);
            adjacents.add(prerequisite[1] - 1);
            adjcies.set(prerequisite[0] - 1, adjacents);

            adjacents = new ArrayList<>();
            if (adjcies.get(prerequisite[1] - 1).size() != 0) adjacents = adjcies.get(prerequisite[1] - 1);
            adjacents.add(prerequisite[0] - 1);
            adjcies.set(prerequisite[1] - 1, adjacents);
        }
    }
}
