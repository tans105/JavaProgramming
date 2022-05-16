package competitiveProgramming.leetcode.phase1;

import java.util.ArrayList;
import java.util.List;

/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0}, {0, 1}, {0, 2}};
        System.out.println(canFinish(3, arr));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; //??

        // create the array lists to represent the courses
        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }

        // create the dependency graph
        for (int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];
        
        // dfs visit each course
        for (int i = 0; i < numCourses; i++) {
            if (!checkRecursive(courses, visited, i)) return false;
        }

        return true;
    }

    private static boolean checkRecursive(List<List<Integer>> courses, int[] visited, int course) {

        visited[course] = 1; // mark it being visited

        List<Integer> eligibleCourses = courses.get(course); // get its children

        // dfs its children
        for (int i = 0; i < eligibleCourses.size(); i++) {
            int eligibleCourse = eligibleCourses.get(i);

            if (visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
            if (visited[eligibleCourse] == 0) { // not visited
                if (!checkRecursive(courses, visited, eligibleCourse)) return false;
            }

        }

        visited[course] = 2; // mark it done visiting
        return true;
    }
}
