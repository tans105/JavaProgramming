package competitiveProgramming.geekforgeeks.phase1;

import utils.ArrayUtils;
import utils.LoggingUtil;

public class MaximumSumOfLIS {
    private static int maxSumIs(int arr[], int n) {

        int msis[] = new int[n];
        System.arraycopy(arr, 0, msis, 0, n);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    msis[i] += arr[j];
                }
            }
        }

        return ArrayUtils.getMax(msis);
    }

    public static void main(String args[]) {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        LoggingUtil.log("Sum of maximum sum increasing subsequence is ", maxSumIs(arr, n));
    }
}
