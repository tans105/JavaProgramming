package competitiveProgramming.geekforgeeks;

import utils.ArrayUtils;

import java.util.*;

/*
https://practice.geeksforgeeks.org/problems/four-elements/0

Given an array A of N integers, find a combination of four elements in the array whose sum is equal to a given value X.

Input:
First line consists of T test cases. First line of every test case consists of an integer N, denoting the number of elements in an array. Second line consists of N spaced array elements. Third line of every test case X.

Output:
Single line output, print 1 if combination is found else 0.

Constraints:
1 <= T <= 100
1 <= N <= 106

Example:
Input:
1
6
1 5 1 0 6 0
7
Output:
1

Explantion:
Testcase 1: 1, 5, 1, 0 are the four elements which makes sum 7.
 */
public class FourElements {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.parseArray("[1,5,1,0,6,0]");
        int target = 6;
        System.out.println(getFourElementsSum(arr, target));
    }

    private static int getFourElementsSum(int[] arr, int target) {
        List<Pair> twoSum = generateTwoSumFromArray(arr);
        Collections.sort(twoSum);

        int min = 0, max = twoSum.size() - 1;
        while (min < max) {
            int sum = twoSum.get(min).value + twoSum.get(max).value;
            if (twoSum.get(min).i == twoSum.get(max).i || twoSum.get(min).i == twoSum.get(max).j || twoSum.get(min).j == twoSum.get(max).i || twoSum.get(min).j == twoSum.get(max).j) {
                min++;
                continue;
            }

            if (sum > target) {
                max--;
            } else if (sum < target) {
                min++;
            } else {
                return 1;
            }
        }
        return 0;
    }


    private static List<Pair> generateTwoSumFromArray(int[] arr) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                list.add(new Pair(i, j, arr[i] + arr[j]));
            }
        }
        return list;
    }
}

class Pair implements Comparable {
    public int i;
    public int j;
    public int value;

    Pair(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        Pair p = (Pair) o;
        return this.value > p.value ? 1 : -1;
    }

    public String toString() {
        return "[" + i + "][" + j + "]-" + value;
    }
}
