package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.september.week4;

import java.util.Stack;

/*
https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3473/

Teemo Attacking

In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in poisoned condition.

You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.

Example 1:

Input: [1,4], 2
Output: 4
Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
This poisoned status will last 2 seconds until the end of time point 2.
And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
So you finally need to output 4.



Example 2:

Input: [1,2], 2
Output: 3
Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned.
This poisoned status will last 2 seconds until the end of time point 2.
However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status.
Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2, it will stop at the end of time point 3.
So you finally need to output 3.



Note:

    You may assume the length of given time series array won't exceed 10000.
    You may assume the numbers in the Teemo's attacking time series and his poisoning time duration per attacking are non-negative integers, which won't exceed 10,000,000.

 */
public class TeemoAttack {
    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0) return 0;

        int[][] durations = new int[timeSeries.length][2];

        for (int i = 0; i < timeSeries.length; i++) {
            durations[i][0] = timeSeries[i];
            durations[i][1] = timeSeries[i] + duration;
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(durations[0]);

        for (int i = 1; i < durations.length; i++) {
            int[] prev = stack.peek();
            int[] current = durations[i];

            if (prev[1] < current[0]) { //disjoint
                stack.push(current);
            } else if (prev[0] < current[0] && prev[1] > current[1]) { //Complete overlap
            } else { //Partial Overlapping
                stack.pop();
                stack.push(new int[]{prev[0], current[1]});
            }
        }

        int killTime = 0;

        for (int[] st : stack) {
            killTime += st[1] - st[0];
        }

        return killTime;
    }
}
