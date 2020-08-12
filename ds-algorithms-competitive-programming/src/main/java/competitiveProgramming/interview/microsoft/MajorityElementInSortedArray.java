package competitiveProgramming.interview.microsoft;

/*

Exp: https://www.geeksforgeeks.org/microsoft-interview-experience-for-sde-1/

Original Problem: https://www.geeksforgeeks.org/check-for-majority-element-in-a-sorted-array/

Check for Majority Element in a sorted array

Question: Write a C function to find if a given integer x appears more than n/2 times in a sorted array of n integers.

Basically, we need to write a function say isMajority() that takes an array (arr[] ), array’s size (n) and a number to be searched (x) as parameters and returns true if x is a majority element (present more than n/2 times).

Examples:

Input: arr[] = {1, 2, 3, 3, 3, 3, 10}, x = 3
Output: True (x appears more than n/2 times in the given array)

Input: arr[] = {1, 1, 2, 4, 4, 4, 6, 6}, x = 4
Output: False (x doesn't appear more than n/2 times in the given array)

Input: arr[] = {1, 1, 1, 2, 2}, x = 1
Output: True (x appears more than n/2 times in the given array)


 */
public class MajorityElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(isMajority(new int[]{1, 2, 3, 3, 3, 3, 10}, 3));
        System.out.println(isMajority(new int[]{1, 1, 2, 4, 4, 4, 6, 6}, 4));
        System.out.println(isMajority(new int[]{1, 1, 1, 2, 2}, 1));
    }

    private static boolean isMajority(int[] arr, int x) {
        int len = arr.length;
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int targetIndex = (len % 2 == 0) ? len / 2 : (len - 1) / 2;

        return (low + targetIndex) < len && arr[low + targetIndex] == x;
    }

}
