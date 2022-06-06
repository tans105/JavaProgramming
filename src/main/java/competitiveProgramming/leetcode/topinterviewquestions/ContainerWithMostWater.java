package competitiveProgramming.leetcode.topinterviewquestions;

/*
11. Container With Most Water

Share
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length == 0) {return 0;}
        int result = 0;

        for (int i = 0; i < height.length - 1; i++) {
            int start = height[i];
            int j = i + 1;
            int localMax = -1;

            while (j < height.length) {
                localMax = Math.max(localMax, Math.min(start, height[j]) * (j - i));
                j++;
            }

            result = Math.max(result, localMax);
        }

        return result;
    }
}
