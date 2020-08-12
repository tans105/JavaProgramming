package competitiveProgramming.interview.microsoft;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
https://www.geeksforgeeks.org/microsoft-interview-experience-idc-bangalore-3-years-exp-january-2020/

There is a source number and a destination number. You can keep on doing any of the following operations: *2, /2, +2 on the source.
You have to come up with a Yes or No if the destination is achievable
 */
public class CanReachDestination {
    public static void main(String[] args) {
        System.out.println(canReach(2, 5));
    }

    public static int canReach(int from, int to) {
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int days = 0;

        queue.offer(from);
        queue.offer(null);

        while (!queue.isEmpty()) {
            Integer next = queue.poll();

            if (next == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.offer(null);
                    days++;
                    continue;
                }
            }

            if(next == to) {
                break;
            }

            //add
            if (!seen.contains(next + 2)) {
                queue.offer(next + 2);
                queue.add(next + 2);
            }

            //multiple
            if (!seen.contains(next * 2)) {
                queue.offer(next * 2);
                seen.add(next * 2);
            }

            //divide
            if (next % 2 == 0 && !seen.contains(next / 2)) {
                queue.add(next / 2);
                seen.add(next / 2);
            }
        }

        return days;
    }
}
