package competitiveProgramming.random;

import java.util.Stack;

public class TimeToStack {
    public static void main(String[] args) {
        System.out.println(findTime(new int[]{3, 4, 1, 2}));
        System.out.println(findTime(new int[]{1, 1, 1, 1}));
    }

    private static int findTime(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        int operations = 0;
        int count = 0;
        int prev = -1;

        for (int i = nums.length - 1; i >= 0; i--) stack.push(nums[i]);

        while (count != nums.length) {
            int current = stack.pop();
            if (current >= prev) {
                aux.push(current);
                prev = current;
                count++;
            } else {
                while (!aux.isEmpty()) stack.push(aux.pop());

                stack.push(current);
                prev = -1;
                count = 0;
                operations++;
            }
        }

        return operations;
    }
}
