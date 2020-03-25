package competitiveProgramming.geekforgeeks.mustdoquestions.recursion;

import java.util.ArrayList;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/combination-sum-part-2/0

Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B.

ach number in A may only be used once in the combination.

Note:
   All numbers will be positive integers.
   Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
   The combinations themselves must be sorted in ascending order.
   If there is no combination possible the print "Empty" (without qoutes).
Example,
Given A = 10,1,2,7,6,1,5 and B(sum) 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]

Input:
First is T , no of test cases. 1<=T<=500
Every test case has three lines.
First line is N, size of array. 1<=N<=12
Second line contains N space seperated integers(x). 1<=x<=9.
Third line is the sum B. 1<=B<=30.

Output:
One line per test case, every subset enclosed in () and in every set intergers should be space seperated.(See example)

Example:
Input:
2
7
10 1 2 7 6 1 5
8
5
8 1 8 6 8
12

Output:
(1 1 6)(1 2 5)(1 7)(2 6)
Empty
 */
public class CombinationSumPart1 { // no duplicates in the input
    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 2, 7, 6, 5};
        System.out.println(getCombination(arr, 8));
    }

    private static List<List<Integer>> getCombination(int[] arr, int val) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(temp, result, arr, val, 0, 0);
        return result;
    }

    private static void backtrack(List<Integer> temp, List<List<Integer>> result, int[] arr, int val, int sum, int start) {
        if (sum == val) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (sum > val) {
            return;
        }

        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            backtrack(temp, result, arr, val, sum + arr[i], i);
            temp.remove(temp.size() - 1);
        }

    }
}
