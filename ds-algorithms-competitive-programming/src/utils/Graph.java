package utils;

import utils.ArrayUtils;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjacentVertices;
    private List<Integer> vertices;
    private boolean isDirected;

    private void init(boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.adjacentVertices = new HashMap<>();
        this.isDirected = isDirected;
    }

    public Graph(boolean isDirected) {
        init(isDirected);
    }

    public Graph(int N, boolean isDirected, boolean fromZero) {
        init(isDirected);
        int[] arr = ArrayUtils.generateArray(N, fromZero);
        addVertices(arr);
    }

    public Graph(int N, boolean isDirected) {
        init(isDirected);
        int[] arr = ArrayUtils.generateArray(N, false);
        addVertices(arr);
    }

    public Graph(String edgeSet, boolean isDirected) {
        init(isDirected);
        int[] edgeSetArray = ArrayUtils.parseArray(edgeSet);
        for(int vertex: edgeSetArray) {
            if(!this.vertices.contains(vertex)) {
                adjacentVertices.put(vertex, new ArrayList<>());
                this.vertices.add(vertex);
            }
        }
        addEdges(edgeSet);
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

    public void addEdges(int[] edgeSet) {
        if (edgeSet.length % 2 != 0) {
            throw new IllegalArgumentException("Edge set cannot be odd");
        }
        for (int i = 0; i < edgeSet.length; i += 2) {
            addEdge(edgeSet[i], edgeSet[i + 1]);
        }
    }

    public void addEdges(String edgeSet) {
        addEdges(ArrayUtils.parseArray(edgeSet));
    }

    @Override
    public String toString() {
        return "Graph{" + "adj=" + adjacentVertices + '}';
    }


    public List<Integer> getAdjacent(int vertex) {
        return this.adjacentVertices.get(vertex);
    }
}
