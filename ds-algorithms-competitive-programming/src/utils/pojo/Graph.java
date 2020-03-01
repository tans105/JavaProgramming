package utils.pojo;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    public int v;
    public LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Graph{" + "adj=" + Arrays.toString(adj) + '}';
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public LinkedList<Integer> getAdjacent(int val) {
        return this.adj[val];
    }
}
