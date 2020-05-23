package utils;

import utils.pojo.Edge;
import utils.pojo.Vertex;

import java.util.*;

public class Graph<T> {
    private Map<Vertex<T>, List<Vertex<T>>> adjacentVertices;
    private Map<T, Vertex<T>> vertexMap;
    private List<Vertex<T>> vertices;
    private List<Edge<T>> allEdges;
    private boolean isDirected;

    private void init(boolean isDirected) {
        this.vertices = new ArrayList<>();
        this.adjacentVertices = new HashMap<>();
        this.isDirected = isDirected;
        this.allEdges = new ArrayList<>();
        this.vertexMap = new HashMap<>();
    }

    public Vertex<T> getVertex(T v) {
        return vertexMap.get(v);
    }

    public Graph(boolean isDirected) {
        init(isDirected);
    }

    public Vertex<T> addVertex(T v) {
        Vertex<T> vertex;
        if (!vertexMap.containsKey(v)) {
            vertex = new Vertex<>(v);
            vertices.add(vertex);
            adjacentVertices.put(vertex, new ArrayList<>());
            vertexMap.put(v, vertex);
        } else {
            vertex = vertexMap.get(v);
        }

        return vertex;
    }

    public void addVertices(T[] vertices) {
        for (T v : vertices) {
            addVertex(v);
        }
    }

    public List<Vertex<T>> getVertices() {
        return vertices;
    }

    private boolean isPresent(Vertex<T> v) {
        return vertices.contains(v);
    }

    public void addEdge(T v, T w) {
        addEdge(v, w, 1);
    }

    public void addEdge(T v, T w, Integer weight) {
        Vertex<T> v1 = addVertex(v);
        Vertex<T> v2 = addVertex(w);

        if (vertices.contains(v1) && vertices.contains(v2)) {
            if (isDirected) {
                connectVertices(v1, v2, weight);
            } else {
                connectVertices(v1, v2, weight);
                connectVertices(v2, v1, weight);
            }
        } else {
            throw new IllegalArgumentException("Either of the vertex is not registered");
        }
    }

    private void connectVertices(Vertex<T> v1, Vertex<T> v2, int weight) {
        Edge<T> edge = new Edge<>(v1, v2, weight, this.isDirected);
        allEdges.add(edge);
        v1.addEdge(edge);
        adjacentVertices.get(v1).add(v2);
        v1.addAdjacentVertices(v2);
    }

    public void addEdges(T[] edgeSet, boolean hasWeight) {
        int k = (hasWeight) ? 2 : 3;
        if (edgeSet.length % k != 0) {
            throw new IllegalArgumentException("Edge set not right. Check the params again");
        }
        for (int i = 0; i < edgeSet.length; i += k) {
            if (hasWeight) addEdge(edgeSet[i], edgeSet[i + 1], (Integer) edgeSet[i + 2]);
            else addEdge(edgeSet[i], edgeSet[i + 1]);
        }
    }


    public List<Vertex<T>> getAdjacent(Vertex<T> vertex) {
        return this.adjacentVertices.get(vertex);
    }

    public Map<Vertex<T>, List<Vertex<T>>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public int getDistanceBetweenVertex(Vertex<T> from, Vertex<T> to) {
        int distance = -1;
        for (Edge<T> e : from.getEdges()) {
            if (e.getV2().equals(to)) {
                distance = e.getWeight();
                break;
            }
        }
        return distance;
    }

    @Override
    public String toString(){
        StringBuilder buffer = new StringBuilder();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getV1() + " " + edge.getV2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}