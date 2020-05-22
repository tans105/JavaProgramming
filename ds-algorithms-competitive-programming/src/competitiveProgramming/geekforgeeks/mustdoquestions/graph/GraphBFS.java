package competitiveProgramming.geekforgeeks.mustdoquestions.graph;

import utils.Graph;
import utils.LoggingUtil;
import utils.pojo.Vertex;

import java.util.*;

/*
https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

BFS of graph

Given N and E, the number of nodes and edges in a directed graph. The task is to do Breadth First Search of this graph.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines. Description of testcases is as follows: The First line of each test case contains two integers 'N' and 'E'  which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'E'  space separated pairs u and v denoting that there is a edge from u to v .

Output:
For each testcase, print the BFS of the graph starting from 0.

Note: The expected output button always produces BFS starting from node 0.

User Task:
Since, this is a functional problem, your task is to complete the function bfs() which do BFS of the given graph starting from node 0 and prints the nodes in BFS order.

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
3 2
0 1 0 2

Output:
0 1 2 3 4    // BFS from node 0
0 1 2

Explanation:
Testcase 1:
0 is connected to 1 , 2 , 3
2 is connected to 4
so starting from 0 , bfs will be 0 1 2 3 4.
 */
public class GraphBFS {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 4);
        bfs(graph);
        System.out.println();


        graph = new Graph<>(false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        bfs(graph);
    }

    private static void bfs(Graph<Integer> graph) {
        Queue<Vertex<Integer>> queue = new LinkedList<>();
        Set<Vertex<Integer>> found = new HashSet<>();
        LoggingUtil.logTabSeparated(0);
        queue.add(new Vertex<>(0));
        found.add(new Vertex<>(0));
        queue.add(null);

        while (!queue.isEmpty()) {
            Vertex<Integer> ele = queue.poll();
            if (ele == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.offer(null);
                    continue;
                }
            }

            List<Vertex<Integer>> adjacent = graph.getAdjacent(ele);
            for (Vertex<Integer> integer : adjacent) {
                if (!found.contains(integer)) {
                    found.add(integer);
                    queue.offer(integer);
                    LoggingUtil.logTabSeparated(integer);
                }
            }
        }
    }
}
