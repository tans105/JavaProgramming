package competitiveProgramming.interview.microsoft;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/snakes-and-ladders/

909. Snakes and Ladders

On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom left of the board, and alternating direction each row.  For example, for a 6 x 6 board, the numbers are written as follows:


You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:

You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
(This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations, regardless of the size of the board.)
If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].

Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.)

Return the least number of moves required to reach square N*N.  If it is not possible, return -1.

Example 1:

Input: [
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,35,-1,-1,13,-1],
[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation:
At the beginning, you start at square 1 [at row 5, column 0].
You decide to move to square 2, and must take the ladder to square 15.
You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
You then decide to move to square 14, and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.
Note:

2 <= board.length = board[0].length <= 20
board[i][j] is between 1 and N*N or is equal to -1.
The board square with number 1 has no snake or ladder.
The board square with number N*N has no snake or ladder.
 */
public class SnakesAndLadder {
    public static void main(String[] args) {
        int[][] board;

        board = ArrayUtils.parse2DArray("" +
                "[[-1,-1,-1,-1,-1,-1],\n" +
                "[-1,-1,-1,-1,-1,-1],\n" +
                "[-1,15,-1,-1,-1,-1]]");

        System.out.println(snakesAndLadders(board));

        board = ArrayUtils.parse2DArray("" +
                "[[-1,-1],\n" +
                "[-1,-1]]\n");

        System.out.println(snakesAndLadders(board));
    }


    //Not working !
    public static int snakesAndLadders(int[][] board) {
        Map<Integer, List<Square>> adjacencies = new HashMap<>();
        List<Square> squares = new ArrayList<>();
        int total = board.length * board.length;
        int rows = board.length;
        int cols = board[0].length;
        int square = 1;

        squares.add(new Square(0, -1));
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                squares.add(new Square(square, (board[i][j] == -1) ? 0 : board[i][j]));
                square++;
            }

        }

        squares.get(1).minVal = 0;
        getAdjacents(adjacencies, squares);


        for (int i = 1; i < total; i++) {
            int count = squares.get(i).minVal;
            explore(squares.get(i), adjacencies, count, total, squares);
        }
        return squares.get(total).minVal;
    }

    private static void getAdjacents(Map<Integer, List<Square>> adjacencies, List<Square> squares) {
        for (int i = 1; i < squares.size(); i++) {
            List<Square> paths = new ArrayList<>();
            for (int j = 1; j <= 6; j++) {
                if (i + j >= squares.size()) continue;
                Square destinationSquare = squares.get(i + j);
                if (destinationSquare.val == 0) {
                    paths.add(destinationSquare);
                } else {
                    paths.add(squares.get(destinationSquare.val));
                }
            }
            adjacencies.put(i, paths);
        }
    }

    private static void explore(Square square, Map<Integer, List<Square>> adjacencies, int count, int total, List<Square> squares) {
        List<Square> adjacents = adjacencies.get(square.id);

        if (square.id == total) {
            squares.get(total).minVal = Math.min(squares.get(total).minVal, count + 1);
        }

        for (Square current : adjacents) {
            current.minVal = Math.min(current.minVal, count + 1);
            explore(current, adjacencies, current.minVal, total, squares);
        }
    }


    static class Square {
        int minVal;
        final int id;
        final int val;

        Square(int id, int val) {
            this.val = val;
            this.id = id;
            this.minVal = Integer.MAX_VALUE;
        }

        @Override
        public String toString() {
            return "Square{" +
                    "id=" + id +
                    ", val=" + val +
                    '}';
        }
    }
}
