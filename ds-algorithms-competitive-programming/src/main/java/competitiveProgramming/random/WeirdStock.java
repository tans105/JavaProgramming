package competitiveProgramming.random;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Given an initial stock value. With every day, the stock can

- Either reduce by 1$
- Gets double the current value.

Find the minimum numbers days we can reach the end number of stocks

Company - Arcesium
 */
public class WeirdStock {
    public static void main(String[] args) {
        System.out.println(getDays(3, 7));
        System.out.println(getDays(3, 4));
        System.out.println(getDays(11, 40));
    }

    private static int getDays(int initial, int end) {
        int[] arr = new int[1000000];
        Arrays.fill(arr, -1);
        arr[initial] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(initial);
        queue.offer(null);
        int days = 1;

        while (arr[end] == -1) {
            Integer index = queue.poll();

            if (index == null) {
                days++;
                queue.offer(null);
            } else {
                if (2 * index < arr.length - 1 && arr[2 * index] == -1) {
                    arr[2 * index] = days;
                    queue.offer(2 * index);
                }

                if (index - 1 >= 0 && arr[index - 1] == -1) {
                    arr[index - 1] = days;
                    queue.offer(index - 1);
                }
            }
        }

        return arr[end];
    }
}
