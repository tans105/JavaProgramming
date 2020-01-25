package competitiveProgramming.leetcode;

import utils.ArrayUtils;

import java.util.Stack;

/*
84. Largest Rectangle in Histogram

Example:

Input: [2,1,5,6,2,3]
Output: 10
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(ArrayUtils.parseArray("[1,2,4]")));
    }

    public static int largestRectangleArea(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int index = 1;
        int maxArea = arr[0];
        stack.push(0);

        while (index < arr.length) {
            int top = stack.peek();

            while (index <= arr.length - 1 && arr[index] >= arr[top]) {
                top = stack.peek();
                stack.push(index);
                index++;
            }

            int area = 0;

            while (index <= arr.length - 1 && stack.size() >= 1 && arr[index] <= arr[top]) {
                top = stack.pop();
                area = (stack.size() == 0) ? arr[top] * index : arr[top] * (index - top);
                maxArea = Math.max(area, maxArea);
            }


            stack.push(index++);

        }

        return maxArea;
    }
}
