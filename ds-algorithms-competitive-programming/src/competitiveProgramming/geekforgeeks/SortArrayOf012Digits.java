package competitiveProgramming.geekforgeeks;

import utils.ArrayUtils;

import java.util.Arrays;

public class SortArrayOf012Digits {
    public static void main(String[] args) {
//        Method 1
        int[] arr = new int[]{0, 1, 0, 1, 2};
        Arrays.sort(arr);
        ArrayUtils.printArray(arr);

//        Method 2
        arr = new int[]{0, 1, 0, 1, 2};
        int ones = 0;
        int twos = 0;
        int zeros = 0;
        for (int arrVal : arr) {
            if (arrVal == 0) {
                zeros++;
            }
            if (arrVal == 1) {
                ones++;
            }
            if (arrVal == 2) {
                twos++;
            }
        }
        System.out.println();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < zeros; i++) {
            builder.append("0\t");
        }
        for (int i = 0; i < ones; i++) {
            builder.append("1\t");
        }
        for (int i = 0; i < twos; i++) {
            builder.append("2\t");
        }
        System.out.println(builder.toString());
    }


}
