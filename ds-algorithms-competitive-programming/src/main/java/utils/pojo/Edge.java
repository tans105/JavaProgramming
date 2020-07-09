package utils.pojo;


import java.util.Objects;

public class Edge<T> {
    private Vertex<T> v1;
    private Vertex<T> v2;
    private Integer weight = 1;
    private boolean isDirected = false;

    public Edge(Vertex<T> v1, Vertex<T> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Edge(Vertex<T> v1, Vertex<T> v2, boolean isDirected) {
        this.v1 = v1;
        this.v2 = v2;
        this.isDirected = isDirected;
    }

    public Edge(Vertex<T> v1, Vertex<T> v2, Integer weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public Edge(Vertex<T> v1, Vertex<T> v2, Integer weight, boolean isDirected) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
        this.isDirected = isDirected;
    }

    @Override
    public String toString() {
        return "{" + v1 + ", " + v2 + ", " + weight + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return weight == edge.weight &&
                isDirected == edge.isDirected &&
                v1.equals(edge.v1) &&
                v2.equals(edge.v2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, weight, isDirected);
    }

    public Vertex<T> getV1() {
        return v1;
    }

    public Vertex<T> getV2() {
        return v2;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isDirected() {
        return isDirected;
    }
}

