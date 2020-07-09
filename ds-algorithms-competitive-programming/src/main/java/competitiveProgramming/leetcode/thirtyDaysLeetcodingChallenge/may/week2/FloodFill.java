package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.may.week2;

import utils.ArrayUtils;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/

Flood Fill

An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:

Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.

Note:
The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class FloodFill {
    public static void main(String[] args) {
        ArrayUtils.print2DArray(floodFill(ArrayUtils.parse2DArray("[[1,1,1],[1,1,0],[1,0,1]]"), 1, 1, 2));
        ArrayUtils.print2DArray(floodFill(ArrayUtils.parse2DArray("[[0,0,0],[0,1,1]]"), 1, 1, 1));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        floodFillHelper(image, sr, sc, newColor, image.length, image[0].length, color);
        return image;
    }

    private static void floodFillHelper(int[][] image, int x, int y, int newColor, int R, int C, int srcColor) {
        if (x < 0 || y < 0 || x > R - 1 || y > C - 1 || image[x][y] == newColor ) return;

        if (image[x][y] == srcColor) {
            image[x][y] = newColor;
            floodFillHelper(image, x - 1, y, newColor, R, C, srcColor);
            floodFillHelper(image, x + 1, y, newColor, R, C, srcColor);
            floodFillHelper(image, x, y - 1, newColor, R, C, srcColor);
            floodFillHelper(image, x, y + 1, newColor, R, C, srcColor);
        }
    }
}
