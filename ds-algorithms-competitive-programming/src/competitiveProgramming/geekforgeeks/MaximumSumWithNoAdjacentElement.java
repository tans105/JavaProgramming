package competitiveProgramming.geekforgeeks;

/*
https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/

Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.

Examples :

Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {1, 2, 3}
Output : 4

Input : arr[] = {1, 20, 3}
Output : 20
 */
public class MaximumSumWithNoAdjacentElement {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(findMaxSum(arr));
    }


    private static int findMaxSum(int[] arr) {
        int incl = arr[0];
        int excl = 0;
        int prevIncl = 0;
        int prevExcl = 0;
        for (int i = 1; i < arr.length; i++) {
            incl = prevExcl + arr[i];
            excl = Math.max(prevExcl, prevIncl);
            prevIncl = incl;
            prevExcl = excl;
        }
        return Math.max(incl, excl);
    }
}

