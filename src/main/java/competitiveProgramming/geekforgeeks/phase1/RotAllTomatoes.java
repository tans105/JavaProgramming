package competitiveProgramming.geekforgeeks.phase1;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
public class RotAllTomatoes {
    private static final String STRINGDELIMITER = ",";

    static class Tomato {
        int x;
        int y;

        Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "("+x + STRINGDELIMITER  + y +")";
        }
    }

    private static int C;
    private static int R;

    public static void main(String[] args) {
        int arr[][] = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };
        R = arr.length;
        C = arr[0].length;

        int ans = rotOranges(arr);
        if (ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }

    static boolean isValid(int i, int j) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    static boolean isDelim(Tomato temp) {
        return (temp.x == -1 && temp.y == -1);
    }

    private static int rotOranges(int[][] arr) {
        Queue<Tomato> q = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 2) {
                    q.add(new Tomato(i, j));
                }
            }
        }
        q.add(new Tomato(-1, -1)); //adding delimiter

        boolean rottenCreated = false;
        int iteration = 0;
        while (!q.isEmpty()) {
            while (!isDelim(q.peek())) {//checking for a tomato point
                Tomato temp = q.peek();
                int x = temp.x;
                int y = temp.y;

                //bottom
                if (isValid(x + 1, y) && arr[x + 1][y] == 1) {
                    if (!rottenCreated) {
                        rottenCreated = true;
                        iteration++;
                    }

                    arr[x + 1][y] = 2;
                    q.add(new Tomato(x + 1, y));
                }

                //top
                if (isValid(x - 1, y) && arr[x - 1][y] == 1) {
                    if (!rottenCreated) {
                        rottenCreated = true;
                        iteration++;
                    }
                    arr[x - 1][y] = 2;
                    q.add(new Tomato(x - 1, y));
                }

                //left
                if (isValid(x, y - 1) && arr[x][y - 1] == 1) {
                    if (!rottenCreated) {
                        rottenCreated = true;
                        iteration++;
                    }
                    arr[x][y - 1] = 2;
                    q.add(new Tomato(x, y - 1));
                }

                //right
                if (isValid(x, y + 1) && arr[x][y + 1] == 1) {
                    if (!rottenCreated) {
                        rottenCreated = true;
                        iteration++;
                    }
                    arr[x][y + 1] = 2;
                    q.add(new Tomato(x, y + 1));
                }
                q.remove();
            }
            q.remove(); //remove delimiter
            rottenCreated = false;

            if (!q.isEmpty()) {
                q.add(new Tomato(-1, -1));
            }
        }

        return iteration;
    }
}
