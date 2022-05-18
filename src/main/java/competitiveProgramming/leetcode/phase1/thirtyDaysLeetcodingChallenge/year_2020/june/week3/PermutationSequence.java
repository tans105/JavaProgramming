package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.june.week3;

import utils.ArrayUtils;

/*
Permutation Sequence
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 */
public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));

    }

    public static String getPermutation(int n, int k) {
        Integer[] arr = ArrayUtils.generateArray(n, false);

        for (int i = 0; i < k - 1; i++) {
            //Get the next greater element for k-1 times
            getNextGreater(arr);
        }

        StringBuilder response = new StringBuilder();

        for (Integer integer : arr) {
            response.append(integer);
        }

        return response.toString();
    }

    private static void getNextGreater(Integer[] arr) {
        int swap1 = -1;
        int swap2 = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                swap1 = i - 1;
                break;
            }
        }

        for (int i = swap1 + 1; i < arr.length; i++) {
            if (arr[swap1] > arr[i]) {
                swap2 = i - 1;
                break;
            }
        }

        if (swap2 == -1) {
            swap(arr, swap1, arr.length - 1);
            reverse(arr, swap1 + 1);
        } else {
            swap(arr, swap1, swap2);
            reverse(arr, swap1 + 1);
        }
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void reverse(Integer[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}
