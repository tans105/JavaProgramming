package competitiveProgramming.others.practise;

import utils.ArrayUtils;

import java.util.Arrays;

public class Sort2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {3, 4}, {1, 2}, {1, 5}, {2, 4}
        };
        sort2DArray(arr);
    }

    private static void sort2DArray(int[][] arr) {
        Arrays.sort(arr, (a1, a2) -> a1[0] - a2[0]);

//        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        ArrayUtils.print2DArray(arr);
    }
}
