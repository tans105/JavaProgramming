package utils;

import utils.pojo.Edge;
import utils.pojo.Vertex;

import java.util.*;

public class Graph<T> {
    private Map<Vertex<T>, List<Vertex<T>>> adjacentVertices;
    private List<Vertex<T>> vertices;
    private boolean isDirected;

    private void init(boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.adjacentVertices = new HashMap<>();
        this.isDirected = isDirected;
    }

    public Graph(boolean isDirected) {
        init(isDirected);
    }

    public void addVertex(T v) {
        Vertex<T> vertex = new Vertex<>(v);
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            adjacentVertices.put(vertex, new ArrayList<>());
        }
    }

    public void addVertices(T[] vertices) {
        for (T v : vertices) {
            addVertex(v);
        }
    }

    public List<Vertex<T>> getVertices() {
        return vertices;
    }

    private boolean isAbsent(Vertex<T> v) {
        return !vertices.contains(v);
    }

    public void addEdge(T v, T w) {
        Vertex<T> v1 = new Vertex<>(v);
        Vertex<T> v2 = new Vertex<>(w);

        if(isAbsent(v1)) addVertex(v);
        if(isAbsent(v2)) addVertex(w);

        if (vertices.contains(v1) && vertices.contains(v2)) {
            Edge<T> edge = new Edge<T>(v1, v2, isDirected);
            if (isDirected) {
                adjacentVertices.get(v1).add(v2);
            } else {
                adjacentVertices.get(v1).add(v2);
                adjacentVertices.get(v2).add(v1);
            }
        } else {
            throw new IllegalArgumentException("Either of the vertex is not registered");
        }
    }

    public void addEdges(T[] edgeSet) {
        if (edgeSet.length % 2 != 0) {
            throw new IllegalArgumentException("Edge set cannot be odd");
        }
        for (int i = 0; i < edgeSet.length; i += 2) {
            addEdge(edgeSet[i], edgeSet[i + 1]);
        }
    }

    public List<Vertex<T>> getAdjacent(Vertex<T> vertex) {
        return this.adjacentVertices.get(vertex);
    }

    public Map<Vertex<T>, List<Vertex<T>>> getAdjacentVertices() {
        return adjacentVertices;
    }

//    @Override
//    public String toString(){
//        StringBuffer buffer = new StringBuffer();
//        for(Edge<T> edge : getAllEdges()){
//            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
//            buffer.append("\n");
//        }
//        return buffer.toString();
//    }
}