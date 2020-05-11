package competitiveProgramming.geekforgeeks;

import utils.pojo.Graph;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        topologicalSort(g);
    }

    private static void topologicalSort(Graph g) {
        Stack<Integer> sorted = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < g.vertices; i++) {
            if (visited.add(i)) {
                exploreChildren(i, g, sorted, visited);
            }
        }

        while (!sorted.isEmpty()) {
            System.out.print(sorted.pop() + "\t");
        }
    }

    private static void exploreChildren(int current, Graph g, Stack<Integer> sorted, Set<Integer> visited) {
        if (g.getAdjacent(current).size() == 0) { //nothing more to explore
            sorted.add(current);
        } else {
            //explore all the chilren of current
            for (int i = 0; i < g.getAdjacent(current).size(); i++) {
                int temp = g.getAdjacent(current).get(i);
                if (!visited.contains(temp)) {
                    exploreChildren(temp, g, sorted, visited);
                }
            }

            if (!sorted.contains(current))
                sorted.add(current);

        }
    }
}
