package algorithms.recursion;

import utils.ArrayUtils;

public class NBitArray {
    private static int[] array = new int[3];

    public static void main(String[] args) {
        Binary(array.length);
    }

    private static void Binary(int i) {
        if (i < 1) {
            ArrayUtils.printArray(array);
        } else {
            array[i - 1] = 0;
            Binary(i - 1);
            array[i - 1] = 1;
            Binary(i - 1);
        }
    }


}
