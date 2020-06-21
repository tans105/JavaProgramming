package competitiveProgramming.interviewbit;

import java.util.*;

/*
https://www.interviewbit.com/problems/largest-area-of-rectangle-with-permutations/

Largest area of rectangle with permutations
Asked in:  Directi

Problem Description

Given a binary grid A of size N x M consisting of 0's and 1's, find the area of the largest rectangle inside the grid such that all the cells inside the chosen rectangle should have 1 in them.

You are allowed to permutate the columns matrix i.e. you can arrange each of the column in any order in the final grid.

Please follow the sample input and explanation for more clarity.



Problem Constraints
1 <= N, M <= 103



Input Format
First and only argument is an 2D binary array A.



Output Format
Return a single integer denoting the area of the largest rectangle inside the grid such that all the cells inside the chosen rectangle should have 1 in them.



Example Input
Input 1:

 A = [  [1, 0, 1]
        [0, 1 ,0]
        [1, 0, 0]
    ]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

    1 0 1
    0 1 0
    1 0 0


At present we can see that max rectangle satisfying the criteria mentioned in the problem is of 1 * 1 = 1 area
 i.e either of the 4 cells which contain 1 in it.
 Now since we are allowed to permutate the columns of the given matrix, we can take column 1 and column 3 and make them neighbours.
 One of the possible configuration of the grid can be:



1 1 0
0 0 1
1 0 0


Now In this grid, first column is column 1, second column is column 3 and third column is column 2 from the original given
 grid. Now, we can see that if we calculate the max area rectangle, we get max area as 1 * 2 = 2 which is bigger
 than the earlier case. Hence 2 will be the answer in this case.


 */
public class LargestRectangleAreaWithPermutations {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 0, 1));
        matrix.add(Arrays.asList(0, 1, 0));
        matrix.add(Arrays.asList(1, 0, 0));
        System.out.println(solve(matrix));
    }

    public static int solve(List<List<Integer>> A) {
        int[][] hist = new int[A.size()][A.get(0).size()];
        int rows = hist.length;
        int cols = hist[0].length;

        for (int i = 0; i < A.size(); i++) {
            hist[0][i] = A.get(0).get(i);
        }

        /*
        Original
        1 0 1
        1 1 0
        0 1 0
         */
        for (int i = 0; i < A.get(0).size(); i++) { //cols
            for (int j = 1; j < A.size(); j++) { //rows
                int current = A.get(j).get(i);
                if (current != 0) hist[j][i] = hist[j - 1][i] + current;
            }
        }
        /*
        Create Histogram ( this will give the maximum rectangle area for a column )
        1 0 1
        2 1 0
        0 2 0
         */

        for (int i = 0; i < rows; i++) {
            int[] count = new int[rows + 1];
            for (int j = 0; j < cols; j++) {
                count[hist[i][j]]++;
            }
            int col = 0;
            for (int k = rows; k >= 0; k--) {
                while (count[k] > 0) {
                    hist[i][col++] = k;
                    count[k]--;
                }
            }
        }

        /*
        Sort by rows (this is equivalent to swapping column )
        1 1 0
        2 1 0
        2 0 0
         */

        /*  Now since the histograms are arranged in decreasing heights, for a given count[i][j] with height H,
            there will always be a histogram of at least height H before it.
            This means that the rectangular area under the histograms for count[i][j] will be -

            Area = base * min_height_till_now_for_current_row
            (j + 1) * count[i][j]
         */

        /*  Think of every cell as a histogram of height hist[i][j]. Since rows are sorted, for every cell the cells to the left will always greater than or equal to its value
            so the current cell contribution would be = (value) * (distance from origin)
            i.e (j + 1) * count[i][j]
        */

        int currArea, maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < hist[i].length; j++) {
                currArea = (j + 1) * hist[i][j];
                if (currArea > maxArea) {
                    maxArea = currArea;
                }
            }
        }
        return maxArea;
    }
}
