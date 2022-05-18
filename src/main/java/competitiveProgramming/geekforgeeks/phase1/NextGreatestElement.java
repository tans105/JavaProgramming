package competitiveProgramming.geekforgeeks.phase1;

import utils.ArrayUtils;

/*
https://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/

Replace every element with the greatest element on right side

Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array. Since there is no element next to the last element, replace it with -1. For example, if the array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}.
 */
public class NextGreatestElement {
    public static void main(String[] args) {
        ArrayUtils.printArray(getNextGreaterElement(new int[]{16, 17, 4, 3, 5, 2}));
    }

    private static int[] getNextGreaterElement(int[] arr) {
        int currentMax = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > currentMax) {
                currentMax = arr[i];
            } else {
                arr[i] = currentMax;
            }
        }

        return arr;
    }
}
