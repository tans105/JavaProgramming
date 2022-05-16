package competitiveProgramming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
    Company : Uber
*/
public class PairWithEqualSum {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 4, 3, 1, 7, 12};
        pairSum(arr);
    }

    private static void pairSum(int[] arr) {
        HashMap pairMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && i > j) {
                    int sum = arr[i] + arr[j];
                    Integer[] spam = new Integer[]{arr[i], arr[j]};
                    if (pairMap.containsKey(sum)) {
                        ArrayList list = (ArrayList) pairMap.get(sum);
                        list.add(Arrays.asList(spam));
                        pairMap.put(sum, list);
                    } else {
                        ArrayList list = new ArrayList<>();
                        list.add(Arrays.asList(spam));
                        pairMap.put(sum, list);
                    }
                }
            }
        }

        System.out.println(pairMap);
    }
}
