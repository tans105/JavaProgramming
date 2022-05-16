package competitiveProgramming.interview.Microsoft;

import java.util.Arrays;
import java.util.Comparator;

/*
https://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/

Consider a big party where a log register for guest’s entry and exit times is maintained. Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.
Example :

Input: arrl[] = {1, 2, 9, 5, 5}
       exit[] = {4, 5, 12, 9, 12}
First guest in array arrives at 1 and leaves at 4,
second guest arrives at 2 and leaves at 5, and so on.

Output: 5
There are maximum 3 guests at time 5.
 */
public class PointMaximumIntervalOverlap {
    public static void main(String[] args) {
        int[][] timings = new int[][]{{1, 4}, {2, 5}, {9, 12}, {5, 9}, {5, 12}};
        System.out.println(maxGuest(timings));
    }

    private static int maxGuest(int[][] timings) {
        int maxGuest = 0;

        Arrays.sort(timings, Comparator.comparingInt(t -> t[0]));

        int i = 0;
        int j = 1;
        int currentGuest = 1;

        while (j != timings.length && i != timings.length) {
            int[] g1 = timings[i];
            int[] g2 = timings[j];

            if (g1[1] >= g2[0]) { //departure of previous guest is more than arrival of next
                currentGuest++;
                j++;
                maxGuest = Math.max(currentGuest, maxGuest);
            } else {
                i++;
                currentGuest--;
            }
        }

        return maxGuest;
    }
}
