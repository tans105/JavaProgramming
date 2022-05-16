package competitiveProgramming.others.practise;

import java.util.ArrayList;
import java.util.List;

/*
Given the numbers in the array, find the maximum length of subarray who gives a positive product

Company - Arcesium
 */
public class PositiveProduct {
    public static void main(String[] args) {
        System.out.println(positiveProduct(new int[]{5, 1, 6, 2, -1, 4, 5, 6}));
    }

    private static int positiveProduct(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        List<Integer> negativeIndices = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) negativeIndices.add(i);
        }

        int value1 = 0, value2 = 0;
        if (negativeIndices.size() > 0 && negativeIndices.size() % 2 != 0) {
            value1 = negativeIndices.get(negativeIndices.size() - 1);
            value2 = arr.length - negativeIndices.get(0) - 1;
        } else {
            value1 = arr.length;
        }

        return Math.max(value1, value2);
    }
}
