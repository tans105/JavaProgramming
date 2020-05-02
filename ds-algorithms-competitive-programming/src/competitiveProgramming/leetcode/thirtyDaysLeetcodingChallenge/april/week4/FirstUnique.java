package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.april.week4;

import utils.ArrayUtils;

import java.util.*;

public class FirstUnique {
    private Queue<Integer> uniqueElements;
    private Set<Integer> foundElements;

    public FirstUnique(int[] nums) {
        uniqueElements = new LinkedList<>();
        foundElements = new HashSet<>();

        for (int num : nums) {
            if (!foundElements.contains(num)) {
                foundElements.add(num);
                uniqueElements.add(num);
            } else {
                uniqueElements.remove(num);
            }
        }
    }

    public int showFirstUnique() {
        return (uniqueElements.size() > 0) ? uniqueElements.peek() : -1;
    }

    public void add(int value) {
        if (foundElements.contains(value)) {
            uniqueElements.remove(value);
            foundElements.add(value);
        } else {
            foundElements.add(value);
            uniqueElements.add(value);
        }
    }

    public static void main(String[] args) {
        String[] operations;
        int[][] values;

        operations = new String[]{"FirstUnique", "showFirstUnique", "add", "showFirstUnique", "add", "showFirstUnique", "add", "showFirstUnique"};
        values = new int[][]{{2, 3, 5}, {}, {5}, {}, {2}, {}, {3}, {}};
        apply(operations, values);

        operations = new String[]{"FirstUnique", "showFirstUnique", "add", "add", "add", "add", "add", "showFirstUnique"};
        values = new int[][]{{7, 7, 7, 7, 7, 7}, {}, {7}, {3}, {3}, {7}, {17}, {}};
        apply(operations, values);

        operations = new String[]{"FirstUnique", "showFirstUnique", "add", "showFirstUnique"};
        values = new int[][]{{809}, {}, {809}, {}};
        apply(operations, values);
    }

    private static void apply(String[] operations, int[][] values) {
        FirstUnique unique = null;
        Object[] response = new Object[operations.length];
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "FirstUnique": {
                    response[i] = null;
                    unique = new FirstUnique(values[i]);
                    continue;
                }
                case "showFirstUnique": {
                    response[i] = unique.showFirstUnique();
                    break;
                }

                case "add": {
                    unique.add(values[i][0]);
                    break;
                }
            }
        }

        ArrayUtils.printArray(response);
    }
}
