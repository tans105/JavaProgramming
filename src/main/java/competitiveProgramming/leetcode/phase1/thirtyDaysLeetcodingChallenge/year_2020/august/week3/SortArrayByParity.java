package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.august.week3;

import utils.ArrayUtils;

/*
Sort Array By Parity

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.



Note:

    1 <= A.length <= 5000
    0 <= A[i] <= 5000


 */
public class SortArrayByParity {
    public static void main(String[] args) {
        ArrayUtils.printArray(sortArrayByParity(new int[]{3, 1, 2, 4}));
        ArrayUtils.printArray(sortArrayByParity(new int[]{}));
        ArrayUtils.printArray(sortArrayByParity(null));
    }

    public static int[] sortArrayByParity(int[] A) {
        if (A == null) return A;

        int[] aux = new int[A.length];
        int i = 0;
        int j = A.length - 1;
        int index = 0;

        while (index != A.length) {
            if (A[index] % 2 == 0) {
                aux[i] = A[index];
                i++;
            } else {
                aux[j] = A[index];
                j--;
            }

            index++;
        }

        return aux;
    }
}
