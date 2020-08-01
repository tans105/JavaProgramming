package competitiveProgramming.others.practise;

import java.util.*;

public class AndQueries {
    public static void main(String[] args) {
        System.out.println(andQueries(Arrays.asList(21, 29, 31, 15, 13, 5), Arrays.asList(Arrays.asList(4, 6, 2, 7))));
        System.out.println(andQueries(Arrays.asList(5, 2, 5, 4, 8, 3, 1, 4), Arrays.asList(Arrays.asList(2, 5, 2, 4))));

        System.out.println(andQueries(Arrays.asList(10, 53, 21, 23, 19, 17, 49, 57, 61, 57, 61, 3, 4),
                Arrays.asList(Arrays.asList(2, 5, 1, 9), Arrays.asList(7, 10, 3, 45), Arrays.asList(4, 10, 4, 28))));
    }

    public static List<Integer> andQueries(List<Integer> numbers, List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();

        for (List<Integer> query : queries) {
            computeQuery(numbers, query, result);
        }

        return result;
    }

    private static void computeQuery(List<Integer> numbers, List<Integer> query, List<Integer> result) {
        int start = query.get(0) - 1;
        int end = query.get(1) - 1;
        int k = query.get(2);
        int p = query.get(3);
        int queryCount = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = start; i <= end + 1; i++) {
            if (queue.size() < k) {
                queue.offer(numbers.get(i));
                continue;
            }

            if (queue.size() == k) {
                int andOutput = getAnd(queue, k);
                if (andOutput >= p) queryCount++;
                if (i <= end) {
                    queue.poll();
                    queue.offer(numbers.get(i));
                } else {
                    break;
                }
            }
        }

        result.add(queryCount);
    }

    private static int getAnd(Queue<Integer> queue, int k) {
        int and = queue.peek();
        queue.offer(queue.poll());
        for (int i = 1; i < k; i++) {
            and &= queue.peek();
            queue.offer(queue.poll());
        }
        return and;
    }
}
