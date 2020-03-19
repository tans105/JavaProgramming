package competitiveProgramming.geekforgeeks.mustdoquestions.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/*
https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0

Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case contains a single integer N denoting the size of array and the size of subarray K. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum for every subarray of size k.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ K ≤ N
0 ≤ A[i] <= 107

Example:
Input:
2
9 3
1 2 3 1 4 5 2 3 6
10 4
8 5 10 7 9 4 15 12 90 13

Output:
3 3 4 5 5 5 6
10 10 10 15 15 90 90

Explanation:
 */
public class MaximumOfAllSubarrayOfSizeK {
    public static void main(String[] args) {
//        maximumSubarrayOfSizeK(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3);
        maximumSubarrayOfSizeK(new int[]{9, 6, 11, 8, 10, 5, 4, 13, 93, 14}, 4);
    }

    private static void maximumSubarrayOfSizeK(int[] arr, int k) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;
        while (count != arr.length + 1) {
            if (count < k) {
                //check the deque to keep relevant values
                while (!queue.isEmpty() && arr[queue.peekLast()] < arr[count]) {
                    queue.pop();
                }
                queue.addLast(count);
            } else {
                while (!queue.isEmpty() && queue.peekFirst() < count - k) {
                    queue.pop();
                }
                //start printing values

                System.out.println(arr[queue.peekFirst()]);

                //check the deque to keep relevant values
                while (count < arr.length && !queue.isEmpty() && arr[queue.peekLast()] < arr[count]) {
                    queue.removeLast();
                }
                queue.addLast(count);
            }
            count++;
        }
    }
}
