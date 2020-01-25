package competitiveProgramming.leetcode;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Stack;

/*
84. Largest Rectangle in Histogram

Example:

Input: [2,1,5,6,2,3]
Output: 10
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(ArrayUtils.parseArray("[4,2,0,3,2,5]")));
    }

    public static int largestRectangleArea(int[] arr) {
        int len = arr.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int current = (i == len ? 0 : arr[i]);
            if (s.isEmpty() || current >= arr[s.peek()]) { // keep adding elements to the stack if increasing
                s.push(i);
            } else {
                int top = s.pop();
                int area = arr[top] * (s.isEmpty() ? i : i - 1 - s.peek());
                maxArea = Math.max(maxArea, area);
                i--;
            }
        }
        return maxArea;
    }
}
