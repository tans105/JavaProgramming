package competitiveProgramming.geekforgeeks.mustdoquestions.graph;

import utils.Graph;
import utils.LoggingUtil;
import utils.pojo.Edge;
import utils.pojo.Vertex;

import java.util.*;

public class DijkstraShortestPath {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 5, 3);
        graph.addEdge(5, 4, 2);
        graph.addEdge(5, 6, 5);
        graph.addEdge(4, 6, 1);
        findShortestPath(graph, 1);
        /**
         * Distance from 1 to 1 is 0
         * Distance from 2 to 1 is 2
         * Distance from 3 to 1 is 3
         * Distance from 4 to 1 is 8
         * Distance from 5 to 1 is 6
         * Distance from 6 to 1 is 9
         */

        System.out.println();
        graph = new Graph<>(false);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 43);
        graph.addEdge(1, 2, 6);
        findShortestPath(graph, 2);
        /**
         * Distance from 1 to 2 is 6
         * Distance from 2 to 2 is 0
         * Distance from 0 to 2 is 7
         */
    }

    private static void findShortestPath(Graph<Integer> graph, int source) {
        PriorityQueue<VertexMetadata> queue = new PriorityQueue<>();
        Map<Vertex<Integer>, VertexMetadata> vertexVertexMetadataMap = new HashMap<>();
        Set<Vertex<Integer>> seen = new HashSet<>();

        Vertex<Integer> sourceVertex = graph.getVertex(source);
        VertexMetadata meta = new VertexMetadata(sourceVertex, 0, null);
        vertexVertexMetadataMap.put(sourceVertex, meta);
        queue.offer(meta);

        while (!queue.isEmpty()) {
            VertexMetadata currentMetadata = queue.poll();
            Vertex<Integer> currentVertex;

            if (currentMetadata != null) {
                currentVertex = currentMetadata.v;
                if (!seen.contains(currentVertex)) {
                    List<Vertex<Integer>> adjacentVertices = currentVertex.getAdjacentVertices();

                    for (Vertex<Integer> adjVertex : adjacentVertices) {
                        VertexMetadata vertexMetadata;
                        int distance = graph.getDistanceBetweenVertex(currentVertex, adjVertex);

                        if (vertexVertexMetadataMap.containsKey(adjVertex)) {
                            //key is present => get min , update, add to queue
                            vertexMetadata = vertexVertexMetadataMap.get(adjVertex);
                            vertexMetadata.distance = Math.min(vertexMetadata.distance, currentMetadata.distance + distance);
                            vertexVertexMetadataMap.put(adjVertex, vertexMetadata);
                        } else {
                            //key is not present => add to the queue
                            vertexMetadata = new VertexMetadata(adjVertex, currentMetadata.distance + distance, currentMetadata);
                            queue.offer(vertexMetadata);
                            vertexVertexMetadataMap.put(adjVertex, vertexMetadata);
                        }
                    }

                    seen.add(currentVertex);
                }
            }
        }

        for (Map.Entry<Vertex<Integer>, VertexMetadata> entry : vertexVertexMetadataMap.entrySet()) {
            LoggingUtil.logNewLine("Distance from", entry.getKey(), "to", source, "is", entry.getValue().distance);
        }
    }

    static class VertexMetadata implements Comparable<VertexMetadata> {
        Vertex<Integer> v;
        int distance;
        VertexMetadata from;

        public VertexMetadata(Vertex<Integer> v, int distance, VertexMetadata from) {
            this.v = v;
            this.distance = distance;
            this.from = from;
        }

        @Override
        public int compareTo(VertexMetadata vertexMetadata) {
            return Integer.compare(this.distance, vertexMetadata.distance);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            return v.equals(o);
        }

        @Override
        public int hashCode() {
            return Objects.hash(v);
        }
    }


}
