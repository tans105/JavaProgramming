package competitiveProgramming.geekforgeeks.mustdoquestions.hashing;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/*
https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1

Count distinct elements in every window

Given an array A[] of size N and an integer K. Your task is to complete the function countDistinct() which prints the count of distinct numbers in all windows of size k in the array A[].

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two integers N and K. Then in the next line are N space separated values of the array A[].

Output:
For each test case in a new line print the space separated values denoting counts of distinct numbers in all windows of size k in the array A[].

Constraints:
1 <= T <= 100
1 <= N <= K <= 105
1 <= A[i] <= 105 , for each valid i

Example(To be used only for expected output):
Input:
2
7 4
1 2 1 3 4 2 3
3 2
4 1 1

Output:
3 4 4 3
2 1
 */
public class CountDistinctElementInEveryWindow {
    public static void main(String[] args) {
        countDistinct(ArrayUtils.parseArray("1 2 1 3 4 2 3"), 4);
        countDistinct(ArrayUtils.parseArray("4 1 1"), 2);
    }

    private static void countDistinct(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                int count = countMap.getOrDefault(nums[i], 0);
                countMap.put(nums[i], count + 1);
            } else {
                System.out.print(countMap.size() + "\t");
                int indexToBeRemoved = i - k;

                if (countMap.get(nums[indexToBeRemoved]) == 1) countMap.remove((int) nums[indexToBeRemoved]);
                else countMap.put(nums[indexToBeRemoved], countMap.get(nums[indexToBeRemoved]) - 1);

                int count = countMap.getOrDefault(nums[i], 0);
                countMap.put(nums[i], count + 1);
            }
        }
        System.out.print(countMap.size() + "\t");
        System.out.println();
    }
}
