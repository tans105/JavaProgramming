package competitiveProgramming.mustdoquestions.arrays;

/*
Kth smallest element
https://practice.geeksforgeeks.org/problems/kth-smallest-element/0

Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Expected Time Complexity: O(n)

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

Output:
Corresponding to each test case, print the kth smallest element in a new line.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N

Example:
Input:
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4

Output:
7
15

Explanation:
Testcase 1: 3rd smallest element in the given array is 7.
 */
public class KthSmallestElement {
    public static void main(String[] args) {
        System.out.println(kthSmallestElement(new int[]{7, 10, 4, 20, 15}, 4));
    }

    private static int kthSmallestElement(int[] arr, int k) {
        kthSmallestElement(arr, k, 0, arr.length - 1);
        return arr[k - 1];
    }

    private static void kthSmallestElement(int[] arr, int k, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            if (pivot == k) {
                return;
            }
            kthSmallestElement(arr, k, low, pivot - 1);
            kthSmallestElement(arr, k, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = 0;
        int j = high - 1;

        while (i <= j) {
            if (arr[i] < pivot) {
                i++;
            } else if (arr[i] > pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }

        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i;
    }


}
