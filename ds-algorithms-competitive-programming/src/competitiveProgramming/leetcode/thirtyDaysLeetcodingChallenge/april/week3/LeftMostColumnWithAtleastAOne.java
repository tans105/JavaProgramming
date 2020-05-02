package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.april.week3;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/

Leftmost Column with at Least a One
(This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.



Example 1:



Input: mat = [[0,0],[1,1]]
Output: 0
Example 2:



Input: mat = [[0,0],[0,1]]
Output: 1
Example 3:



Input: mat = [[0,0],[0,0]]
Output: -1
Example 4:



Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
Output: 1


Constraints:

1 <= mat.length, mat[i].length <= 100
mat[i][j] is either 0 or 1.
mat[i] is sorted in a non-decreasing way.
 */
public class LeftMostColumnWithAtleastAOne {
    public static void main(String[] args) {
        BinaryMatrix matrix;

        matrix = new BinaryMatrix("[[0,0,0,1],[0,0,1,1],[0,1,1,1]]");
        System.out.println(leftMostColumnWithOne(matrix)); //1

        matrix = new BinaryMatrix("[[0,0],[1,1]]");
        System.out.println(leftMostColumnWithOne(matrix)); //0

        matrix = new BinaryMatrix("[[0,0],[0,0]]");
        System.out.println(leftMostColumnWithOne(matrix)); //-1

        matrix = new BinaryMatrix("[[0,0],[0,1]]");
        System.out.println(leftMostColumnWithOne(matrix)); //1
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int i = 0;
        int j = dim.get(1);
        int rows = dim.get(0);
        boolean found = false;

        while (true) {
            if (i <= rows && j - 1 >= 0 && binaryMatrix.get(i, j - 1) == 1) {
                found = true;
                j--;
            } else if (i + 1 <= rows && binaryMatrix.get(i + 1, j) == 1) {
                found = true;
                i++;
            } else if (i <= rows && binaryMatrix.get(i, j) == 0) {
                i++;
            } else {
                break;
            }
        }

        return (found) ? j : -1;
    }

    private static class BinaryMatrix {
        private int[][] arr;
        private List<Integer> dimension;

        BinaryMatrix(String str) {
            arr = ArrayUtils.parse2DArray(str);
            dimension = new ArrayList<>();
            dimension.add(arr.length - 1);
            dimension.add(arr[0].length - 1);
        }

        private int get(int x, int y) {
            return arr[x][y];
        }

        private List<Integer> dimensions() {
            return dimension;
        }
    }
}



