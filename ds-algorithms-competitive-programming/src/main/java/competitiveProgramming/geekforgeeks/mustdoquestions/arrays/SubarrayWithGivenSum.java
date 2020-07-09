package competitiveProgramming.geekforgeeks.mustdoquestions.arrays;

import utils.ArrayUtils;

/*
https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:
Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5
 */
public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 7, 5};
//        ArrayUtils.printArray(subarrayWithGivenSum(arr, 15));
        ArrayUtils.printArray(subarrayWithGivenSum2(arr, 12));
    }

    private static int[] subarrayWithGivenSum(int[] arr, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    return answer;
                }
            }
        }

        return answer;
    }

    private static int[] subarrayWithGivenSum2(int[] arr, int target) {
        int i = 0, j = 0;
        int[] answer = new int[2];
        int currentSum = arr[i];

        while (i < arr.length) {

            while (currentSum < target) {
                currentSum += arr[++j];
            }

            while (i < arr.length && i < j && currentSum > target) {
                currentSum -= arr[i];
                i++;
            }

            if (currentSum == target) {
                answer[0] = i + 1;
                answer[1] = j + 1;
                return answer;
            }
        }

        return answer;
    }

}
