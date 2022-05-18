package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.july.week4;

import java.util.*;

/*
https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3404/

Task Scheduler

You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks.



Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation:
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.

Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.

Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation:
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A



Constraints:

    The number of tasks is in the range [1, 10000].
    The integer n is in the range [0, 100].


 */
public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'B', 'A', 'A', 'A'}, 2));
        System.out.println(leastInterval(new char[]{'A', 'A', 'B', 'B'}, 2));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B'}, 2));
        System.out.println(leastInterval(new char[]{'A', 'A', 'B', 'B', 'C'}, 3));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'C'}, 0));
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'C'}, 1));
    }

    //Solution 1
    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        Map<Character, Integer> taskToCount = new HashMap<>();
        for (char c : tasks) {
            taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (char c : taskToCount.keySet()) queue.offer(taskToCount.get(c));

        Map<Integer, Integer> coolDown = new HashMap<>(); // If the current element is allocated the position, it is put into the cooldown map till it is again eligible for scheduling
        int currTime = 0;
        while (!queue.isEmpty() || !coolDown.isEmpty()) {
            if (coolDown.containsKey(currTime - n - 1)) { // If a cooldown element is eligible for scheduling, bring it out and put it in the queue.
                queue.offer(coolDown.remove(currTime - n - 1));
            }
            if (!queue.isEmpty()) { // Bring out the next scheduled element and put it into the cooldown map with one count less.
                int left = queue.poll() - 1;
                if (left != 0) coolDown.put(currTime, left);
            }
            currTime++;
        }

        return currTime;
    }


    //Solution 2 - My solution (Not working )
    public static int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> lastPositionMap = new HashMap<>();
        List<Character> myList = new ArrayList<>();

        for (char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
            if (!myList.contains(task)) {
                myList.add(task);
                lastPositionMap.put(task, -1);
            }
        }

        TaskComparator<Character> comparator = new TaskComparator<>(countMap);
        myList.sort(comparator);

        int count = 0;
        int nextIndex = 0;
        int currentPosition = 0;
        Character[] arr = new Character[10000];

        while (count < tasks.length) {
            char eligibleTask = myList.get(nextIndex);
            int lastKnownPosition = lastPositionMap.get(eligibleTask);

            if (lastKnownPosition == -1) {
                arr[currentPosition] = eligibleTask;
                lastPositionMap.put(eligibleTask, currentPosition);
                currentPosition++;
                count++;

                if (countMap.get(eligibleTask) == 1) {
                    myList.remove(nextIndex);
                } else {
                    countMap.put(eligibleTask, countMap.get(eligibleTask) - 1);
                }

                nextIndex++;
            } else if (currentPosition - lastKnownPosition > n) { //can insert
                arr[currentPosition] = eligibleTask;
                lastPositionMap.put(eligibleTask, currentPosition);
                currentPosition++;
                count++;

                if (countMap.get(eligibleTask) == 1) {
                    myList.remove(nextIndex);
                } else {
                    countMap.put(eligibleTask, countMap.get(eligibleTask) - 1);
                }

                nextIndex++;
            } else {
                arr[currentPosition] = '#';
                currentPosition++;
            }


            if (nextIndex >= myList.size()) {
                nextIndex = 0;
            }
        }

        return currentPosition;
    }

    private static class TaskComparator<Character> implements Comparator<Character> {
        Map<Character, Integer> countMap;

        TaskComparator(Map<Character, Integer> countMap) {
            this.countMap = countMap;
        }


        @Override
        public int compare(Character t, Character t1) {
            if (countMap.get(t) > countMap.get(t1)) return -1;
            else if (countMap.get(t).equals(countMap.get(t1))) return 0;
            else return 1;
        }
    }
}
