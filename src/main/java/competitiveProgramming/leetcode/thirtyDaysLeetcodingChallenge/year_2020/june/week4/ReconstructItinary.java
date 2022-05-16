package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.june.week4;

import java.util.*;

/*
https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3374/

Reconstruct Itinerary
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
 */
public class ReconstructItinary {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("JFK", "AAA"));
        list.add(Arrays.asList("AAA", "JFK"));
        list.add(Arrays.asList("JFK", "BBB"));
        list.add(Arrays.asList("JFK", "CCC"));
        list.add(Arrays.asList("CCC", "JFK"));

        System.out.println(findItinerary(list));

    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> adjacents = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            List<String> adjacent = adjacents.getOrDefault(from, new ArrayList<>());
            adjacent.add(to);
            adjacents.put(from, adjacent);
            visited.put(from + to, false);
        }

        List<String> jfkAdjacents = adjacents.get("JFK");
        Collections.sort(jfkAdjacents);

        for (String adj : jfkAdjacents) {
            HashMap<String, Boolean> visitedCopy = new HashMap<>(visited);
            List<String> path = new ArrayList<>();
            path.add("JFK");
            visitedCopy.put("JFK" + adj, true);

            checkRecursive(adj, adjacents, visitedCopy, path, 1, tickets.size());
        }

        return null;
    }

    private static void checkRecursive(String from, HashMap<String, List<String>> adjacents, HashMap<String, Boolean> visited, List<String> path, int covered, int tobeCovered) {
        List<String> adjacent = adjacents.get(from);
        path.add(from);

        if (covered == tobeCovered) {
            System.out.println(path);
        }

        if (adjacent != null) {
            for (String to : adjacent) {
                if (!visited.get(from + to)) {
                    visited.put(from + to, true);
                    checkRecursive(to, adjacents, visited, path, covered + 1, tobeCovered);
                    visited.put(from + to, false);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
