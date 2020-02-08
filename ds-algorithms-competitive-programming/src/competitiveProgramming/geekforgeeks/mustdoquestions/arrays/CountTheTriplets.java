package competitiveProgramming.geekforgeeks.mustdoquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/count-the-triplets/0

Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5
 */
public class CountTheTriplets {
    public static void main(String[] args) {
        System.out.println(countTheTriplets(new int[]{1, 5, 3, 4, 2}));
    }

    private static List<List<Integer>> countTheTriplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = twoSum(arr, arr[i], i);
            if (temp.size() != 0) {
                result.add(temp);
            }
        }
        return result;
    }

    private static List<Integer> twoSum(int[] arr, int target, int currentIndex) {
        List<Integer> temp = new ArrayList<>();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            if (i == currentIndex) {
                i++;
                continue;
            }

            if (j == currentIndex) {
                j--;
                continue;
            }


            int sum = arr[i] + arr[j];

            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                temp.add(arr[i]);
                temp.add(arr[j]);
                temp.add(sum);
                break;
            }
        }
        return temp;
    }
}
