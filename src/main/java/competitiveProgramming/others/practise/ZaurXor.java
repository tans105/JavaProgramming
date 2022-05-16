package competitiveProgramming.others.practise;

import java.util.LinkedList;
import java.util.Queue;

public class ZaurXor {
    public static void main(String[] args) {
        System.out.println(zaurXor(2, 1, new int[]{1, 2, 3, 4}));
        System.out.println(zaurXor(1, 0, new int[]{4, 5, 6}));
    }

    private static int zaurXor(int K, int M, int[] nums) {
        int operations = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int num : nums) {
            queue.offer(num);
        }

        queue.offer(null);

        while (operations < K) {
            while (queue.peek() != null) {
                int current = queue.poll();
                if (queue.peek() == null) break;
                int next = queue.peek();

                queue.offer(current ^ next);
            }

            queue.poll();
            queue.offer(null);
            operations++;
        }

        for (int i = 0; i < M; i++) {
            queue.poll();
        }

        return (queue.size() > 0) ? queue.poll() : 0;
    }

}
