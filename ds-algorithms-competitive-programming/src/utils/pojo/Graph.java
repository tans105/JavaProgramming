package utils.pojo;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    public int vertices;
    public LinkedList<Integer>[] adjacentVertices;
    private boolean isDirected = true;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacentVertices = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjacentVertices[i] = new LinkedList<>();
    }

    public Graph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        adjacentVertices = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i) {
            adjacentVertices[i] = new LinkedList<>();
        }

        this.isDirected = isDirected;
    }

    @Override
    public String toString() {
        return "Graph{" + "adj=" + Arrays.toString(adjacentVertices) + '}';
    }

    public void addEdge(int v, int w) {
        if (isDirected) {
            adjacentVertices[v].add(w);
        } else {
            adjacentVertices[v].add(w);
            adjacentVertices[w].add(v);
        }
    }

    public LinkedList<Integer> getAdjacent(int val) {
        return this.adjacentVertices[val];
    }
}
