package competitiveProgramming.geekforgeeks.mustdoquestions.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://practice.geeksforgeeks.org/problems/minimum-platforms/0

Minimum Platforms

Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.

Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times will not be same for a train, but we can have arrival time of one train equal to departure of the other.

In such cases, we need different platforms, i.e at any given instance of time, same platform can not be used for both departure of a train and arrival of another.

Input:
The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N, the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
Note: Time intervals are in the 24-hour format(hhmm),  of the for HHMM , where the first two charcters represent hour (between 00 to 23 ) and last two characters represent minutes (between 00 to 59).

Output:
For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= A[i] < D[i] <= 2359

Example:
Input:
2
6
0900  0940 0950  1100 1500 1800
0910 1200 1120 1130 1900 2000
3
0900 1100 1235
1000 1200 1240

Output:
3
1

Explanation:
Testcase 1: Minimum 3 platforms are required to safely arrive and depart all trains.
 */
public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] dep = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(minimumNumber(arr, dep));
    }

    private static int minimumNumber(int[] arr, int[] dep) {

        List<Train> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Train(arr[i], dep[i]));
        }

        Stack<Train> stack = new Stack<>();
        int currentIndex = 0;
        int count = 1;
        int maxCount = Integer.MIN_VALUE;
        while (currentIndex < list.size()) {
            if (stack.size() == 0) {
                stack.push(list.get(currentIndex));
            } else {
                Train prev = stack.pop();
                Train current = list.get(currentIndex);
                /**
                 1. disjoint
                 2. Overlapping
                 3. combined
                 **/
                if (current.arrival > prev.departure) { //disjoint
                    count = 1;
                    stack.push(prev);
                    stack.push(current);
                } else if (current.arrival > prev.arrival && current.departure < prev.departure) { //overlapping
                    count++;
                    stack.push(prev);
                } else if (current.arrival > prev.arrival && current.departure > prev.departure) { //combined
                    count++;
                    stack.push(new Train(prev.arrival, current.departure));
                }
            }

            maxCount = Math.max(count, maxCount);
            currentIndex++;
        }


        return maxCount;
    }
}

class Train {
    public int arrival;
    public int departure;

    Train(int arrival, int departure) {
        this.arrival = arrival;
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "Train{" +
                "arrival=" + arrival +
                ", departure=" + departure +
                '}';
    }
}
