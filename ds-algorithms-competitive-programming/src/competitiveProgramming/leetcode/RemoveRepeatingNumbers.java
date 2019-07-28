package competitiveProgramming.leetcode;

import utils.ArrayUtils;

import java.util.ArrayList;

//https://leetcode.com/discuss/interview-question/309064/google-phone-interview-remove-repeating-numbers
public class RemoveRepeatingNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 2, 2, 1, 1, 1, 2, 2, 3, 1, 1, 2, 2, 2, 1, 1, 1, 2, 3};
        ArrayUtils.printArray(removeDuplicateOrderN(arr));
    }

    private static Object[] removeDuplicateOrderN(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return null;
        }
        int prev = -1;
        int next = -1;
        int curr = -1;
        boolean checking = false;
        for (int i = 0; i < arr.length - 1; i++) {
            next = arr[i + 1];
            curr = arr[i];
            if (prev != arr[i]) {
                if (arr[i] != next) {
                    list.add(curr);
                }
            }
            prev = arr[i];
        }

        if (next != curr) {
            list.add(next);
        }

        return list.toArray();
    }
}
