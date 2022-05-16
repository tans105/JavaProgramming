package competitiveProgramming.interviewbit;

import utils.ArrayUtils;

import java.util.List;

/*
Max Sum Without Adjacent Elements
Asked in:  Epic systems

Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.

Input Format:

The first and the only argument of input contains a 2d matrix, A.
Output Format:

Return an integer, representing the maximum possible sum.
Constraints:

1 <= N <= 20000
1 <= A[i] <= 2000
Example:

Input 1:
    A = [   [1]
            [2]    ]

Output 1:
    2

Explanation 1:
    We will choose 2.

Input 2:
    A = [   [1, 2, 3, 4]
            [2, 3, 4, 5]    ]

Output 2:
    We will choose 3 and 5.
 */
public class MaxSumWithoutAdjacent {
    public static void main(String[] args) {
        System.out.println(adjacent(ArrayUtils.getNestedListFromString("[[1, 2, 3, 4],[2, 3, 4, 5]]")));
        System.out.println(adjacent(ArrayUtils.getNestedListFromString("[[1],[2]]")));
    }

    public static int adjacent(List<List<Integer>> A) {
        int prevSumA = A.get(0).get(0);
        int prevSumB = A.get(1).get(0);
        int currentSumA = 0;
        int currentSumB = 0;
        int prevPrevSum = 0;

        for (int i = 1; i < A.get(0).size(); i++) {
            currentSumA = A.get(0).get(i) + prevPrevSum;
            currentSumB = A.get(1).get(i) + prevPrevSum;

            prevPrevSum = Math.max(prevPrevSum, Math.max(prevSumA, prevSumB));
            prevSumA = currentSumA;
            prevSumB = currentSumB;
        }

        return Math.max(prevPrevSum, Math.max(prevSumA, prevSumB));
    }
}
