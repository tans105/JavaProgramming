package competitiveProgramming.geekforgeeks.phase1;

import utils.ArrayUtils;

import java.util.Arrays;

/*
There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n)).
 */
public class MedianOfTwoSortedArraySameSize {
    public static void main(String[] args) {
        System.out.println(median(new int[]{1, 2, 15, 26, 38, 40}, new int[]{2, 13, 17, 30, 45, 50}));
    }

    public static int median(int[] arr1, int[] arr2) {
        while (true) {
            int len = arr1.length;
            int index = len / 2;

            int m1 = arr1[len / 2];
            int m2 = arr2[len / 2];


            if (m1 > m2) {
                //1st half of 1 & 2nd half of 2
                arr1 = Arrays.copyOfRange(arr1, 0, (len % 2 == 0) ? index : index + 1);
                arr2 = Arrays.copyOfRange(arr2, len / 2, len);
            }

            if (m2 > m1) {
                //2nd half of 1 & 1st half 1
                arr1 = Arrays.copyOfRange(arr1, len / 2, len);
                arr2 = Arrays.copyOfRange(arr2, 0, (len % 2 == 0) ? index : index + 1);
            }

            if (arr1.length == 2) {
                break;
            }
        }

        ArrayUtils.printArray(arr1);
        ArrayUtils.printArray(arr2);


        return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) / 2;
    }
}
