package competitiveProgramming.geekforgeeks.phase1;

//https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/

import utils.ArrayUtils;

/**
 * You are given an array of 0s and 1s in competitiveProgramming.random order. Segregate 0s on left side and 1s on right side of the array. Traverse array only once.
 * Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 * Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 */
public class SortArrayOfOneAndZero {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        ArrayUtils.printArray(sortArray(arr));
    }

    public static int[] sortArray(int[] arr) {
        int zeroPtr = 0;
        int onePtr = arr.length - 1;
        while (zeroPtr < onePtr) {
            if (arr[zeroPtr] == 1 && arr[onePtr] == 0) {
                swap(arr, zeroPtr, onePtr);
                zeroPtr++;
                onePtr--;
            }

            if (arr[zeroPtr] == 0) {
                zeroPtr++;
            }

            if(arr[onePtr] == 1) {
                onePtr--;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
