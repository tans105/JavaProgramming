package competitiveProgramming.others.practise;


import java.util.*;

public class MinSum {
    public static void main(String[] args) {
        System.out.println(minSum(Arrays.asList(10, 20, 7), 4));
        System.out.println(minSum(Arrays.asList(2), 1));
        System.out.println(minSum(Arrays.asList(2, 3), 1));
    }

    public static int minSum(List<Integer> num, int k) {
        if (num == null || num.size() == 0) return 0;

        Stack<Integer> stack = new Stack<>();

        for (Integer value : num) {
            stack.push(value);
        }

        Collections.sort(stack);

        for (int i = 0; i < k; i++) {
            int current = stack.pop();
            current = (current % 2 == 0) ? current / 2 : (current + 1) / 2;
            int next;
            Stack<Integer> aux = new Stack<>();

            while (!stack.isEmpty()) {
                next = stack.peek();
                if(next > current) {
                    aux.push(stack.pop());
                } else {
                    break;
                }
            }

            stack.push(current);

            while (!aux.isEmpty()) {
                stack.push(aux.pop());
            }
        }

        int sum = 0;

        for (Integer integer : stack) {
            sum += integer;
        }

        return sum;
    }
}
