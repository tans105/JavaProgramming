package utils.pojo;

import utils.ArrayUtils;

import java.util.*;

public class Graph {
    public Map<Integer, List<Integer>> adjacentVertices;
    public List<Integer> vertices;
    private boolean isDirected;

    private void init() {
        this.vertices = new ArrayList<>();
        this.adjacentVertices = new HashMap<>();
    }

    public Graph(boolean isDirected) {
        init();
        this.isDirected = isDirected;
    }

    public Graph(int N, boolean isDirected, boolean fromZero) {
        init();
        this.isDirected = isDirected;
        int[] arr = ArrayUtils.generateArray(N, fromZero);
        addVertices(arr);
    }

    public Graph(int N, boolean isDirected) {
        init();
        this.isDirected = isDirected;
        int[] arr = ArrayUtils.generateArray(N, false);
        addVertices(arr);
    }

    public void addVertex(int vertex) {
        vertices.add(vertex);
        adjacentVertices.put(vertex, new ArrayList<>());
    }

    public void addVertices(int[] vertices) {
        for (int v : vertices) {
            adjacentVertices.put(v, new ArrayList<>());
            this.vertices.add(v);
        }
    }

    public List<Integer> getVertices() {
        return vertices;
    }

    public void addEdge(int v, int w) {
        if (vertices.contains(v) && vertices.contains(w)) {
            if (isDirected) {
                adjacentVertices.get(v).add(w);
            } else {
                adjacentVertices.get(v).add(w);
                adjacentVertices.get(w).add(v);
            }
        } else {
            throw new IllegalArgumentException("Either of the vertex is not registered");
        }
    }

    @Override
    public String toString() {
        return "Graph{" + "adj=" + adjacentVertices + '}';
    }


    public List<Integer> getAdjacent(int vertex) {
        return this.adjacentVertices.get(vertex);
    }
}
