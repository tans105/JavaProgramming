package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a matrix mat[][] of size M*N. Traverse and print the matrix in spiral form.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test cases follow. Each testcase has 2 lines. First line contains M and N respectively separated by a space. Second line contains M*N values separated by spaces.

Output:
Elements when travelled in Spiral form, will be displayed in a single line.

Constraints:
1 <= T <= 100
2 <= M,N <= 10
0 <= Ai <= 100

Example:
Input:
2
4 4
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
3 4
1 2 3 4 5 6 7 8 9 10 11 12

Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
1 2 3 4 8 12 11 10 9 5 6 7
 */
public class SpirallyTraversingMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(spiralTraversal(arr));
    }

    private static List<Integer> spiralTraversal(int[][] arr) {
        List<Integer> ans = new ArrayList<>();

        if (arr == null || arr.length == 0) return ans;

        Set<String> hash = new HashSet<>();

        int rows = arr.length;
        int cols = arr[0].length;
        int iteration = 0;

        while (hash.size() != rows * cols) {
            int xmin = iteration;
            int ymin = iteration;
            int xmax = cols - iteration - 1;
            int ymax = rows - iteration - 1;

            for (int i = iteration; i < cols - iteration; i++) { //increasing
                if (hash.add(xmin + "" + i)) {
                    ans.add(arr[xmin][i]);
                }
            }

            for (int i = iteration; i < rows - iteration; i++) { //increasing
                if (hash.add(i + "" + (xmax))) {
                    ans.add(arr[i][xmax]);
                }
            }

            for (int i = cols - iteration - 1; i >= iteration; i--) { //decreasing
                if (hash.add((ymax) + "" + i)) {
                    ans.add(arr[ymax][i]);
                }
            }

            for (int i = rows - iteration - 1; i >= iteration; i--) { //decreasing
                if (hash.add(i + "" + ymin)) {
                    ans.add(arr[i][ymin]);
                }
            }

            iteration++;
        }

        return ans;
    }

}
