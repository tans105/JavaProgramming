package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.arrays;

import java.util.*;

/*
https://practice.geeksforgeeks.org/problems/pythagorean-triplet/0
Pythagorean Triplet

Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.

Input:
The first line contains T, denoting the number of testcases. Then follows description of testcases. Each case begins with a single positive integer N denoting the size of array. The second line contains the N space separated positive integers denoting the elements of array A.

Output:
For each testcase, print "Yes" or  "No" whether it is Pythagorean Triplet or not (without quotes).

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= A[i] <= 1000

Example:
Input:
1
5
3 2 4 6 5

Output:
Yes

Explanation:
Testcase 1: a=3, b=4, and c=5 forms a pythagorean triplet, so we print "Yes"
 */
public class PythagoreanTriplet {
    public static void main(String[] args) {
        System.out.println(isTripletPresent(new int[]{1, 2, 3}));
    }

    private static boolean isTripletPresent(int[] arr) {
        boolean isPresent = false;
        int[] sqArr = new int[arr.length];
        Set<Integer> list = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            sqArr[i] = arr[i] * arr[i];
            list.add(sqArr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (list.contains(sqArr[i] + sqArr[j])) return true;
            }
        }


        return false;
    }
}
