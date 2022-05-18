package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.july.week1;

import utils.ArrayUtils;

import java.util.*;

/*
https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3379/

Prison Cells After N Days
There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)



Example 1:

Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation:
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:

Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]
 */
public class PrisonCellAfterNDays {
    public static void main(String[] args) {
        ArrayUtils.printArray(prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7));
        ArrayUtils.printArray(prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) return cells;

        Set<String> cellHash = new HashSet<>();
        boolean hasCycle = false;
        int cycle = 0;

        for (int i = 0; i < N; i++) {
            int[] next = getNext(cells);
            if (cellHash.contains(Arrays.toString(next))) {
                hasCycle = true;
                break;
            } else {
                cellHash.add(Arrays.toString(cells));
                cycle++;
            }

            cells = next;

        }

        if (hasCycle) {
            N = N % cycle;
            for (int i = 0; i < N; i++) {
                cells = getNext(cells);
            }
        }
        return cells;
    }

    private static int[] getNext(int[] cells) {
        int[] temp = new int[cells.length];
        for (int j = 0; j < cells.length; j++) {
            if (j == 0) {
                if (cells[j] == 1 && cells[j + 1] == 0) temp[j] = 0;
            } else if (j == cells.length - 1) {
                if (cells[j] == 1 && cells[j - 1] == 0) temp[j] = 0;
            } else {
                if (cells[j - 1] == 0 && cells[j + 1] == 0) temp[j] = 1;
                else if (cells[j - 1] == 1 && cells[j + 1] == 1) temp[j] = 1;
                else temp[j] = 0;
            }
        }

        return temp;
    }
}
