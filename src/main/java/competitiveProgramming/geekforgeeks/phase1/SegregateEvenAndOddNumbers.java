package competitiveProgramming.geekforgeeks.phase1;

import utils.ArrayUtils;

/*
https://www.geeksforgeeks.org/segregate-even-and-odd-numbers/

Segregate Even and Odd numbers
Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers first, and then odd numbers.
Example:

Input  = {12, 34, 45, 9, 8, 90, 3}
Output = {12, 34, 8, 90, 45, 9, 3}
In the output, the order of numbers can be changed, i.e., in the above example, 34 can come before 12 and 3 can come before 9.
 */
public class SegregateEvenAndOddNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 34, 45, 9, 8, 90, 3};
        ArrayUtils.printArray(segregate(arr));
    }

    private static int[] segregate(int[] arr) {
        int i = 0; //even
        int j = arr.length - 1; //odd

        while (i <= j) {
            while( arr[j] % 2 != 0) {
                j--;
            }

            while( arr[i] % 2 == 0) {
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return arr;
    }
}
