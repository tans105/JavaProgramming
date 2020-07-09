package competitiveProgramming.geekforgeeks;

/*
https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/?ref=lbp

Partition a set into two subsets such that the difference of subset sums is minimum
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:



Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
 */
public class PartitionSetForMinimumDifferenceOfSum {
    public static void main(String[] args) {
        //test case 1
        int[] arr1 = new int[]{1, 6, 11, 5};
        System.out.println(minDiff(arr1, arr1.length - 1, 0, 0));

        //test case 2
        arr1 = new int[]{10, 20, 15, 5, 25};
        System.out.println(minDiff(arr1, arr1.length - 1, 0, 0));
    }

    private static int minDiff(int[] arr, int index, int s1, int s2) {
        if (index < 0) return Math.abs(s1 - s2);

        int incl = minDiff(arr, index - 1, s1 + arr[index], s2);
        int excl = minDiff(arr, index - 1, s1, s2 + arr[index]);

        return Math.min(incl, excl);
    }
}
