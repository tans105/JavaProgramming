package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.july.week3;

import utils.ArrayUtils;
import utils.LoggingUtil;

import java.util.*;

/*
Course Schedule II
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        ArrayUtils.printArray(findOrder2(4, ArrayUtils.parse2DArray("[[1,0],[2,0],[3,1],[3,2]]")));
//        ArrayUtils.printArray(findOrder2(2, ArrayUtils.parse2DArray("[[1,0]]")));
//        ArrayUtils.printArray(findOrder2(2, ArrayUtils.parse2DArray("[[0,1]]")));
//        ArrayUtils.printArray(findOrder2(2, ArrayUtils.parse2DArray("[[0,1],[1,0]]")));
//        ArrayUtils.printArray(findOrder2(3, ArrayUtils.parse2DArray("[[0,1],[0,2],[1,2]]")));
    }

    //Approach 1 - BFS
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> seenNodes = new HashSet<>();
        List<List<Integer>> adjacents = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacents.add(new ArrayList<>());
        }
        getAdjacencies(prerequisites, adjacents);
        int currentNode = 0;


        while (currentPath.size() != numCourses) {
            if (seenNodes.contains(currentNode)) {
                currentNode++;
                if (currentNode == numCourses) currentNode = 0;
            }

            seenNodes.add(currentNode);
            currentPath.add(currentNode);
            boolean possible = search(currentNode, adjacents, seenNodes, currentPath);
            if (!possible) {
                currentPath.remove(currentPath.size() - 1);
                seenNodes.remove(currentNode);
            }

            currentNode++;
            if (currentNode == numCourses) currentNode = 0;
        }

        int[] result = new int[currentPath.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = currentPath.get(i);
        }

        return result;
    }

    private static boolean search(int current, List<List<Integer>> adjacents, Set<Integer> seenNodes, List<Integer> path) {
        List<Integer> neighbours = adjacents.get(current); //fetching its adjacent

        if (neighbours.size() == 0) return true;
        else {
            for (int thisNode : neighbours) {
                if (!seenNodes.contains(thisNode)) { //pre-requisite not explored => reject
                    return false;
                }
            }
        }

        return true;
    }

    private static void getAdjacencies(int[][] prerequisites, List<List<Integer>> adjcies) {
        for (int[] prerequisite : prerequisites) {
            List<Integer> adjacents = new ArrayList<>();
            if (adjcies.get(prerequisite[0]).size() != 0) adjacents = adjcies.get(prerequisite[0]);
            adjacents.add(prerequisite[1]);
            adjcies.set(prerequisite[0], adjacents);
        }
    }


    //Approach 2
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        // Indegree - how many prerequisites are needed.
        for (int[] ints : prerequisites) indegree[ints[0]]++;

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }

        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int[] ints : prerequisites) {
                if (ints[1] == prerequisite) {
                    indegree[ints[0]]--;
                    if (indegree[ints[0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = ints[0];
                        queue.offer(ints[0]);
                    }
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }
}
