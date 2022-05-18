package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week5;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/

Course Schedule
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.


Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] arr;

        arr = ArrayUtils.parse2DArray("[[1,0],[0,1],[0,2]]");
        System.out.println(canFinish(3, arr));

        arr = ArrayUtils.parse2DArray("[[1,0]]");
        System.out.println(canFinish(2, arr));

        arr = ArrayUtils.parse2DArray("[[1,0],[0,1]]");
        System.out.println(canFinish(2, arr));

        arr = ArrayUtils.parse2DArray("[[2,0],[1,0],[3,1],[3,2],[1,3]]");
        System.out.println(canFinish(4, arr));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
        int[] visited = new int[numCourses];
        List<List<Integer>> courses = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }

        for (int[] prerequisite : prerequisites) {
            courses.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (checkRecursive(courses, visited, i)) return false;
        }

        return true;
    }

    private static boolean checkRecursive(List<List<Integer>> courses, int[] visited, int course) {
        visited[course] = 1;
        List<Integer> eligibleCourses = courses.get(course);

        for (int eligibleCourse : eligibleCourses) {
            if (visited[eligibleCourse] == 1) return true;
            if (visited[eligibleCourse] == 0) {
                if (checkRecursive(courses, visited, eligibleCourse)) return true;
            }

        }

        visited[course] = 2;
        return false;
    }
}
