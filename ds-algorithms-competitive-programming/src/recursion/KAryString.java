package recursion;

import Utils.ArrayUtils;

public class KAryString {
    private static int[] array = new int[5];

    public static void main(String[] args) {
        KString(array.length, 4);
    }

    private static void KString(int n, int k) {
        if (n < 1) {
            ArrayUtils.printArray(array);
        } else {
            for (int i = 0; i < k; i++) {
                array[n - 1] = i;
                KString(n - 1, k);
            }
        }
    }
}
