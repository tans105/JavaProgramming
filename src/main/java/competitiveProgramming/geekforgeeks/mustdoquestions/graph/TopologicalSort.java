package competitiveProgramming.geekforgeeks.mustdoquestions.graph;

import utils.Graph;
import utils.pojo.Vertex;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>(true);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        topologicalSort(g);
    }

    private static void topologicalSort(Graph<Integer> g) {
        Stack<Vertex<Integer>> sorted = new Stack<>();
        Set<Vertex<Integer>> visited = new HashSet<>();

        for (int i = 0; i < g.getVertices().size(); i++) {
            Vertex<Integer> v =  new Vertex<>(i);
            if (visited.add(v)) {
                exploreChildren(v, g, sorted, visited);
            }
        }

        while (!sorted.isEmpty()) {
            System.out.print(sorted.pop() + "\t");
        }
    }

    private static void exploreChildren(Vertex<Integer> current, Graph<Integer> g, Stack<Vertex<Integer>> sorted, Set<Vertex<Integer>> visited) {
        if (g.getAdjacent(current).size() == 0) { //nothing more to explore
            sorted.add(current);
        } else {
            //explore all the chilren of current
            for (int i = 0; i < g.getAdjacent(current).size(); i++) {
                Vertex<Integer> temp = g.getAdjacent(current).get(i);
                if (!visited.contains(temp)) {
                    exploreChildren(temp, g, sorted, visited);
                }
            }

            if (!sorted.contains(current))
                sorted.add(current);

        }
    }
}
