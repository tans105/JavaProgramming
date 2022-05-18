package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.june.week1;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/

Queue Reconstruction by Height
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 */
public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] arr;

        arr = ArrayUtils.parse2DArray("[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]");
        ArrayUtils.print2DArray(reconstructQueue(arr));

    }

    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];

        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        ArrayList<int[]> list = new ArrayList<>();

        for (int[] person : people) {
            list.add(person[1], new int[]{person[0], person[1]});
        }

        return list.toArray(new int[list.size()][]);
    }
}
