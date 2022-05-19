package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.august.week2;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3421/

Pascal's Triangle II

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]

Follow up:

Could you optimize your algorithm to use only O(k) extra space?

 */
public class PascalTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
        System.out.println(getRow(5));
    }

    public static List<Integer> getRow(int rowIndex) {
        int[][] pascalTriangle = new int[rowIndex + 1][rowIndex + 1];
        pascalTriangle[0][0] = 1;

        for (int i = 1; i < pascalTriangle.length; i++) {
            for (int j = 0; j < pascalTriangle[i].length; j++) {
                if (j - 1 < 0) {
                    pascalTriangle[i][j] = pascalTriangle[i - 1][j];
                } else {
                    pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
                }

            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < pascalTriangle[rowIndex].length; i++) {
            result.add(pascalTriangle[rowIndex][i]);
        }

        return result;
    }
}
