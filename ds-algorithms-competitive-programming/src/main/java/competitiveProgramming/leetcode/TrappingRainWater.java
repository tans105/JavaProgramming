package competitiveProgramming.leetcode;

/*
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trappedWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    private static int trappedWater(int[] arr) {
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];


        left[0] = arr[0];
        right[len - 1] = arr[len - 1];

        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += Math.min(left[i], right[i]) - arr[i];
        }

        return sum;
    }
}
