package competitiveProgramming.interview.GroupOn;

import java.util.PriorityQueue;
import java.util.Queue;

/*
2.Stream of number you need to find minimum no till this point .we can increase or decrease any number.
 */
public class FindMinimumWithInsertAndRemove {
    public static void main(String[] args) {
        String[][] stream = new String[][]{
                {"I", "5"},
                {"S", ""},
                {"I", "6"},
                {"S", ""},
                {"R", "5"},
                {"S", ""},
                {"I", "3"},
                {"S", ""},
                {"I", "1"},
                {"S", ""},
                {"I", "2"},
                {"S", ""},
                {"I", "7"},
                {"S", ""},
                {"I", "9"},
                {"S", ""},
                {"I", "8"},
                {"S", ""},
                {"R", "8"},
                {"S", ""},
                {"I", "1"},
                {"S", ""},
                {"I", "5"},
        };

        perform(stream);
    }

    private static void perform(String[][] stream) {
        for (String[] operation : stream) {
            switch (operation[0]) {
                case "S": {
                    getMin();
                    break;
                }
                case "I": {
                    insert(operation[1]);
                    break;
                }
                case "R": {
                    remove(operation[1]);
                    break;
                }
            }
        }
    }

    static Queue<Integer> queue = new PriorityQueue<>();

    private static void remove(String s) {
        queue.remove(Integer.parseInt(s));
    }

    private static void insert(String s) {
        queue.add(Integer.parseInt(s));
    }

    private static void getMin() {
        System.out.println(queue.peek());
    }


}
