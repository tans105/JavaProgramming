package competitiveProgramming.leetcode.phase1;

import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.List;

/*
120. Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(2);
        result.add(l);
        l = new ArrayList<>();

        l.add(3);
        l.add(4);
        result.add(l);
        l = new ArrayList<>();

        l.add(6);
        l.add(5);
        l.add(7);
        result.add(l);
        l = new ArrayList<>();

        l.add(4);
        l.add(1);
        l.add(8);
        l.add(3);
        result.add(l);

        System.out.println(minimumTotal(result));
    }

    private static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        minimumTotalHelper(triangle, 1, 0, 1, triangle.get(0).get(0));
        return minSum;
    }

    private static int minSum = Integer.MAX_VALUE;

    private static void minimumTotalHelper(List<List<Integer>> triangle, int currentRow, int startIndex, int endIndex, int sum) {
        if (currentRow == triangle.size()) {
            if (sum < minSum) {
                minSum = sum;
            }
        } else {
            List<Integer> list = triangle.get(currentRow);
            for (int i = startIndex; i <= endIndex; i++) {
                minimumTotalHelper(triangle, currentRow + 1, startIndex, startIndex + 1, sum + list.get(i));
            }
        }
    }
}
