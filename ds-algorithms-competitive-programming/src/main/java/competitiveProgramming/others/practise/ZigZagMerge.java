package competitiveProgramming.others.practise;

import utils.ArrayUtils;

/*
Given an array containing a1,a2,....an,b1,b2,....bn. Without using extra space , convert the array into a1,b1,a2,b2....an,bn.

input {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
expected: {1, 101, 2, 102, 3, 103, 4, 104, 5, 105 6, 106 7, 107, 8, 108, 9, 109, 10, 110};

 */
public class ZigZagMerge {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110};

        customize(arr);
        ArrayUtils.printArray(arr);
    }

    private static void customize(int[] arr) {
        int length = arr.length;
        int offset = length / 2;
        int counter = 1;
        while (counter < length) {
            int temp = arr[counter];
            arr[counter] = arr[offset];
            int currentIndex = counter + 1;
            while (currentIndex <= offset) {
                int temp1 = arr[currentIndex];
                arr[currentIndex] = temp;
                temp = temp1;
                currentIndex++;
            }
            offset++;
            counter = counter + 2;
        }
    }
}
