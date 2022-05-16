package competitiveProgramming.geekforgeeks.mustdoquestions.graph;

import utils.Graph;
import utils.pojo.Vertex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
DFS of Graph

https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

Given N nodes and E edges of a connected undirected graph. The task is to do depth first traversal of the graph.

Note: Use recursive approach.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines. Description of testcases is as follows: The First line of each test case contains two integers 'N' and 'E'  which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'E'  space separated pairs u and v denoting that there is a edge from u to v .

Output:
For each testcase, print the nodes while doing DFS starting from node 0.

Your task:
The task is to complete the function dfs() which should do the depth first traversal of given graph and prints the node in DFS order.

Constraints:
1 <= T <= 100
2 <= N <= 104
1 <= E <= (N*(N-1))/2
Graph doesn't contain multiple edges and self loops.

Example:
Input:
2
5 4
0 1 0 2 0 3 2 4
4 3
0 1 1 2 0 3

Output:
0 1 2 4 3
0 1 2 3

Explanation:
Testcase 1:
0 is connected to 1 , 2 , 3
1 is connected to 0
2 is connected to 0 and 4
3 is connected to 0
4 is connected to 2
so starting from 0 , dfs will be 0 1 2 4 3.
 */
public class GraphDFS {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 4);
        dfs(graph, new Vertex<>(0));

        graph = new Graph<>(false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        dfs(graph, new Vertex<>(0));
    }

    private static void dfs(Graph<Integer> graph, Vertex<Integer> root) {
        Set<Vertex<Integer>> found = new HashSet<>();
        found.add(root);
        System.out.print(root + "\t");
        dfs(graph, root, found);
        System.out.println();
    }

    private static void dfs(Graph<Integer> graph, Vertex<Integer> index, Set<Vertex<Integer>> found) {
        List<Vertex<Integer>> adj = graph.getAdjacent(index);
        for (Vertex<Integer> vertex : adj) {
            if (!found.contains(vertex)) {
                System.out.print(vertex + "\t");
                found.add(vertex);
                dfs(graph, vertex, found);
            }
        }
    }
}
