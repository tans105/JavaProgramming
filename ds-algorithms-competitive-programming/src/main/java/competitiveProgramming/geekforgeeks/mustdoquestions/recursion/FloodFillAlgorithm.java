package competitiveProgramming.geekforgeeks.mustdoquestions.recursion;

import utils.ArrayUtils;

/*
https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/

Flood fill Algorithm – how to implement fill() in paint?

In MS-Paint, when we take the brush to a pixel and click, the color of the region of that pixel is replaced with a new selected color. Following is the problem statement to do this task.
Given a 2D screen, location of a pixel in the screen and a color, replace color of the given pixel and all adjacent same colored pixels with the given color.

Example:

Input:
       screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 2, 2, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 2, 2, 0},
                      {1, 1, 1, 1, 1, 2, 1, 1},
                      {1, 1, 1, 1, 1, 2, 2, 1},
                      };
    x = 4, y = 4, newColor = 3
The values in the given 2D screen indicate colors of the pixels.
x and y are coordinates of the brush, newColor is the color that
should replace the previous color on screen[x][y] and all surrounding
pixels with same color.

Output:
Screen should be changed to following.
       screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 3, 3, 3, 3, 0, 1, 0},
                      {1, 1, 1, 3, 3, 0, 1, 0},
                      {1, 1, 1, 3, 3, 3, 3, 0},
                      {1, 1, 1, 1, 1, 3, 1, 1},
                      {1, 1, 1, 1, 1, 3, 3, 1},
                      };
 */
public class FloodFillAlgorithm {
    public static void main(String[] args) {
        int[][] screen = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };

        ArrayUtils.print2DArray(fill(screen, 4, 4, 3));
    }

    private static int[][] fill(int[][] screen, int x, int y, int newColor) {
        int oldColor = screen[x][y];
        int X = screen.length - 1;
        int Y = screen[0].length - 1;
        screenHelper(screen, x, y, oldColor, newColor, X, Y);
        return screen;
    }

    private static void screenHelper(int[][] screen, int x, int y, int oldColor, int newColor, int X, int Y) {
        if (x < 0 || x > X || y < 0 || y > Y) {
            return;
        }

        if (screen[x][y] == oldColor) {
            screen[x][y] = newColor;
            screenHelper(screen, x - 1, y, oldColor, newColor, X, Y);
            screenHelper(screen, x, y - 1, oldColor, newColor, X, Y);
            screenHelper(screen, x + 1, y, oldColor, newColor, X, Y);
            screenHelper(screen, x, y + 1, oldColor, newColor, X, Y);
        }
    }
}
