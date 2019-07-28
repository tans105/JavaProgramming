package competitiveProgramming.leetcode;

import utils.ArrayUtils;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(input));
    }

    public static int maxArea(int[] height) {
        ArrayUtils.printArray(height);
        int overallMax = 0;
        int maxAreaForIndex = 0;
        for (int i = 0; i < height.length; i++) {
            maxAreaForIndex = getMaxAreaForX(i, height);
            if (maxAreaForIndex > overallMax) {
                overallMax = maxAreaForIndex;
            }
        }
        return overallMax;
    }

    private static int getMaxAreaForX(int currentIndex, int[] height) {
        int currentIndexArea;
        int maxAreaForIndex = 0;
        int indexHeight = height[currentIndex];
        for (int i = currentIndex + 1; i < height.length; i++) {
            currentIndexArea = Math.min(height[i], indexHeight) * (i - currentIndex);
            if (currentIndexArea > maxAreaForIndex) {
                maxAreaForIndex = currentIndexArea;

            }
        }
        return maxAreaForIndex;
    }
}
