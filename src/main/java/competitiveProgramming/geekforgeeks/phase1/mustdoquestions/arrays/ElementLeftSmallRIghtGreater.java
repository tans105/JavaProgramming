package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.arrays;

/*
https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/

Find the element before which all the elements are smaller than it, and after which all are greater
Given an array, find an element before which all elements are smaller than it, and after which all are greater than it. Return the index of the element if there is such an element, otherwise, return -1.
Examples:

Input: arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
Output: 4
Explanation: All elements on left of arr[4] are smaller than it
and all elements on right are greater.



Input: arr[] = {5, 1, 4, 4};
Output: -1
Explanation : No such index exits.
 */
public class ElementLeftSmallRIghtGreater {
    public static void main(String[] args) {
        System.out.println(getElement(new int[]{4, 2, 5, 7}));
    }

    private static int getElement(int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];


        leftMax[0] = Integer.MAX_VALUE;
        leftMax[1] = arr[0];
        for (int i = 2; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMin[arr.length - 1] = Integer.MIN_VALUE;
        rightMin[arr.length - 2] = arr[arr.length - 2];
        for (int i = arr.length - 3; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

//        System.out.println(Arrays.toString(leftMax));
//        System.out.println(Arrays.toString(rightMin));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= leftMax[i] && arr[i] <= rightMin[i]) return arr[i];
        }

        return -1;
    }
}
