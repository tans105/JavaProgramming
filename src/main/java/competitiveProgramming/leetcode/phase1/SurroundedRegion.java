package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/*
130. Surrounded Regions

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegion {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
//                {'O', 'O', 'O', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}

                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        solve(arr);
    }

    public static void solve(char[][] board) {
        List<Point> zeroList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && (i == board.length - 1 || i == 0 || j == board[i].length - 1 || j == 0)) {
                    zeroList.add(new Point(i, j));
                }
            }
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[i].length - 1; j++) {
                boolean flip = true;

                Point p = new Point(i - 1, j);
                if (zeroList.contains(p)) flip = false;

                p = new Point(i + 1, j);
                if (zeroList.contains(p)) flip = false;

                p = new Point(i, j - 1);
                if (zeroList.contains(p)) flip = false;

                p = new Point(i, j + 1);
                if (zeroList.contains(p)) flip = false;

                if (flip) board[i][j] = 'X';
            }
        }
        ArrayUtils.print2DArray(board);
    }
}

class Point {
    public int i;
    public int j;

    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String toString() {
        return "[" + this.i + "," + this.j + "]";
    }

    public boolean equals(Object p) {

        if (!(p instanceof Point)) return false;
        if (p == this) return true;
        Point point = (Point) p;
        return this.i == point.i && this.j == point.j;
    }

    public int hashCode() {
        return i * 10 + j * 20;
    }
}
