package competitiveProgramming.geekforgeeks.mustdoquestions.graph;

import utils.Graph;
import utils.pojo.Vertex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/

Given a undirected graph, the task is to complete the method isCyclic() to detect if there is a cycle in the undirected graph or not.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' testcases follow. Each testcase consists of two lines. Description of testcases are as follows: The First line of each testcase contains two integers 'N' and 'M' which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'M'  space separated pairs u and v denoting that there is a bidirectional  edge from u to v .

Output:
The method should return 1 if there is a cycle else it should return 0.

User task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function isCyclic.

Constraints:
1 <= T <= 100
2 <= N <= 104
1 <= M <= (N*(N-1))/2
0 <= u, v <=  N-1
Graph doesn't contain multiple edges and self loops.

Example:
Input:
3
2 1
0 1
4 3
0 1 1 2 2 3
5 4
0 1 2 3 3 4 4 2

Output:
0
0
1

Explanation:
Testcase 1: There is a graph with 2 vertices and 1 edge from 0 to 1. So there is no cycle.
Testcase 2: There is a graph with 3 vertices and 3 edges from 0 to 1, 1 to 2 and 2 to 3.
Testcase 3: There is a cycle in the given graph formed by vertices 2, 3 and 4.
 */
public class DetectLoopDirectedGraph {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>(true);
        graph.addEdge(0,1);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,2);
        System.out.println(hasLoop(graph));
    }

    private static boolean hasLoop(Graph<Integer> graph) {
        List<Vertex<Integer>> vertices = graph.getVertices();
        Set<Vertex<Integer>> found;

        for (Vertex<Integer> vertex : vertices) {
            found = new HashSet<>();
            found.add(vertex);
            if (hasLoop(graph, vertex, found)) return true;
        }

        return false;
    }

    private static boolean hasLoop(Graph<Integer> graph, Vertex<Integer> vertex, Set<Vertex<Integer>> found) {
        List<Vertex<Integer>> adjs = graph.getAdjacent(vertex);

        for (Vertex<Integer> adjacent : adjs) {
            if(found.contains(adjacent)) return true;
            else {
                found.add(adjacent);
                return hasLoop(graph,adjacent, found);
            }
        }

        return false;
    }
}
