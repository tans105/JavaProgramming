package competitiveProgramming.geekforgeeks.phase1;

import utils.ArrayUtils;

/*
https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

Cutting a Rod | DP-13
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 1   5   8   9  10  17  17  20
And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
 */
public class CuttheRod {
    public static void main(String[] args) {
        int[] wt = new int[]{1, 2, 3, 4};
        int[] val = new int[]{2, 5, 7, 8};
        System.out.println(cut(wt, val, 5));
    }

    private static int cut(int[] wt, int[] val, int len) {
        int[][] arr = new int[wt.length][len + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                int rem = j - wt[i];
                if (rem >= 0) {
                    if (i - 1 >= 0) {
                        arr[i][j] = Math.max(arr[i - 1][j], val[i] + arr[i][rem]);
                    } else {
                        arr[i][j] = val[i] + arr[i][rem];
                    }
                } else {
                    arr[i][j] = arr[i - 1][j];
                }

            }
        }

//        ArrayUtils.print2DArray(arr);

        return arr[arr.length - 1][arr[0].length - 1];
    }

}
