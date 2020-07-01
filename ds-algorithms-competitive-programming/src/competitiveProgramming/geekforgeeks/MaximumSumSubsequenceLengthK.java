package competitiveProgramming.geekforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/maximum-sum-subsequence-of-length-k/0

Maximum Sum Subsequence of length k

Given an array sequence [A1 , A2 ...An], the task is to find the maximum possible sum of increasing subsequence S of length K such that Si1<=Si2<=Si3.........<=Sin.

INPUT
The first line contains an integer 'T' denoting the number of testcases. Then 'T' test cases follows. Each test case consists of two line containing two space separated integers 'N' and 'K' denoting the size of the array and length of the subsequence.

OUTPUT
Print the maximum possible sum. If their is no subsequence of length K print "-1".

CONSTRAINTS
1 <= T <= 100
1 <= N <= 100
1 <= a[i] <= 10^5
1 <= k <=100

Example
Input
1
8 3
8 5 9 10 5 6 19 8

Output
38
 */
public class MaximumSumSubsequenceLengthK {
    public static void main(String[] args) {
        System.out.println(maximumSumLengthK(new int[]{8, 5, 9, 10, 5, 6, 19, 8}, 3));
    }

    public static int maximumSumLengthK(int[] arr, int k) {
        List<Track> tracks = new ArrayList<>();
        int maxSoFar = arr[0];
        Track track = new Track(arr[0], k);
        tracks.add(track);

        /*
        Keeping a track of k maximum sum for every index
        [[8, 0, 0], [5, 0, 0], [9, 17, 0], [10, 19, 27], [5, 0, 0], [6, 11, 0], [19, 29, 38], [8, 14, 19]]
         */
        for (int i = 1; i < arr.length; i++) {
            Track currentTrack = new Track(arr[i], k);
            maxSoFar = Math.max(maxSoFar, arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                //if the number is smaller than current
                if (arr[j] < arr[i]) {
                    Track refTrack = tracks.get(j);

                    //traversing through track for the number, setting the current track for the index if encounter a larger sum.
                    for (int a = 0; a + 1 < k && a < refTrack.size; a++) {
                        currentTrack.set(a + 1, Math.max(currentTrack.get(a + 1), refTrack.get(a) + arr[i]));
                        maxSoFar = Math.max(maxSoFar, currentTrack.get(a + 1));
                    }
                }
            }
            tracks.add(currentTrack);
        }

        return maxSoFar;
    }

    private static class Track {
        public int[] track;
        public int size;

        Track(int value, int k) {
            track = new int[k];
            track[0] = value;
            size = 1;
        }

        public void set(int idx, int value) {
            track[idx] = value;
            size++;
        }

        public int get(int idx) {
            if (idx < size) return track[idx];
            else return -1;
        }

        @Override
        public String toString() {
            return Arrays.toString(track);
        }
    }
}
