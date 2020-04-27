package competitiveProgramming.geekforgeeks.mustdoquestions.hashing;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
https://practice.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal/0

Swapping pairs make sum equal

Given two arrays of integers, write a program to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.

Input:
First line of input contains a single integer T which denotes the number of test cases. T test cases follows. First line of each test case contains two space separated integers N and M. Second line of each test case contains N space separated integers denoting the elements of first array. Third line of each test case contains M space separated integers denoting the elements of second array.

Output:
For each test case, print 1 if there exists any such pair otherwise print -1.

Constraints:
1 <= T <= 100
1 <= N <= 104
1 <= M <= 104
0 <= elements <= 104

Example:
Input:
2
6 4
4 1 2 1 1 2
3 6 3 3
4 4
5 7 4 6
1 2 3 8

Output:
1
1

Explanation:
Testcase 1: 1 and 3 are two such values one from first array other from second one, if we swap these two values then we will get both arrays sum as equal.
 */
public class SwappingPairsToMakeSumEqual {
    public static void main(String[] args) {
        System.out.println(swapPairs(ArrayUtils.parseArray("4 1 2 1 1 2"), ArrayUtils.parseArray("3 6 3 3"))); //1
        System.out.println(swapPairs(ArrayUtils.parseArray("5 7 4 6"), ArrayUtils.parseArray("1 2 3 8"))); //1
        System.out.println(swapPairs(ArrayUtils.parseArray("5 7"), ArrayUtils.parseArray("1 3"))); //1
        System.out.println(swapPairs(ArrayUtils.parseArray("5 7"), ArrayUtils.parseArray("1 5"))); //0
    }

    /*  Logic
            sum1 - x + y = sum2 - y + x
            2(y - x) = sum2 - sum1
            2(y - x) = diff
            y = x + diff/2

            diff should be divisible by 2
            checking the values should be done one the larger array
         */
    private static int swapPairs(int[] arr1, int[] arr2) {
        int sum1 = 0, sum2 = 0, diff;

        for (int value : arr1) sum1 += value;
        for (int value : arr2) sum2 += value;

        diff = (sum1 - sum2);

        if (diff % 2 != 0) return 0;
        return (diff < 0) ? swapPairs(arr2, arr1, (diff * -1) / 2) : swapPairs(arr1, arr2, diff / 2);
    }

    private static int swapPairs(int[] arr1, int[] arr2, int diff) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr1) set.add(num);

        for (int num : arr2) {
            if (set.contains(diff + num)) return 1;
        }

        return 0;
    }
}
