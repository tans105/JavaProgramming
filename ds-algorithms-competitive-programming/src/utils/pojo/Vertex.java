package utils.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex<T> {
    private T value;
    private List<Vertex<T>> adjacentVertices;
    private List<Edge<T>> edges;

    public T getValue() {
        return value;
    }

    public List<Vertex<T>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void addAdjacentVertices(Vertex<T> vertex) {
        this.adjacentVertices.add(vertex);
    }

    public void addEdge(Edge<T> edge) {
        this.edges.add(edge);
    }

    public Vertex(T value) {
        this.adjacentVertices = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return value.equals(vertex.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

