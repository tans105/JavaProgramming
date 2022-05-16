package competitiveProgramming.interviewbit;

import java.util.Arrays;
import java.util.List;

/*
https://www.interviewbit.com/problems/max-product-subarray/

Max Product Subarray
Asked in: Amazon, LinkedIn, Microsoft
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
Return an integer corresponding to the maximum product possible.

Example :

Input : [2, 3, -2, 4]
Return : 6

Possible with [2, 3]
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(Arrays.asList(2, 3, -2, 4)));
        System.out.println(maxProduct(Arrays.asList(-1, 2, 3, -4)));
        System.out.println(maxProduct(Arrays.asList(-1, 1)));
        System.out.println(maxProduct(Arrays.asList(-1, 1, 0)));
        System.out.println(maxProduct(Arrays.asList(2, 3, 0, -4)));
        System.out.println(maxProduct(Arrays.asList(2, 3, 0 , 8, -4)));
        System.out.println(maxProduct(Arrays.asList(-4)));
        System.out.println(maxProduct(Arrays.asList(0, -4, 0, -8)));
    }

    public static int maxProduct(final List<Integer> A) {
        if (A == null || A.size() == 0) return 0;

        if (A.size() == 1) return A.get(0);

        int maxOverall = 0;
        int minSoFar = A.get(0);
        int maxSoFar = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            int current = A.get(i);
            int tempMin = minSoFar * current;
            int tempMax = maxSoFar * current;

            minSoFar = Math.min(current, Math.min(tempMax, tempMin));
            maxSoFar = Math.max(current, Math.max(tempMax, tempMin));
            maxOverall = Math.max(maxOverall, maxSoFar);
        }

        return maxOverall;
    }
}
