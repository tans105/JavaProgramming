package competitiveProgramming.hackerrank;

import java.util.Arrays;
import java.util.List;

public class PlusMultArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19});
        System.out.println(plusMult(list));
    }

    public static String plusMult(List<Integer> A) {
        double odd = rOdd(A) % 2;
        double even = rEven(A) % 2;
        if (odd > even) {
            return "ODD";
        } else if (even > odd) {
            return "EVEN";
        }
        return "NEUTRAL";
    }

    public static double rOdd(List<Integer> list) {
        boolean toggle = false;
        int count = 3;
        double value = list.get(1);
        while (count < list.size()) {
            if (toggle) { //add
                value += list.get(count);

            } else { // multiply
                value *= list.get(count);
            }
            count += 2;
            toggle = !toggle;
        }

        return value;
    }

    public static double rEven(List<Integer> list) {
        boolean toggle = false;
        int count = 2;
        double value = list.get(0);
        while (count < list.size()) {
            if (toggle) { //add
                value += list.get(count);

            } else { // multiply
                value *= list.get(count);
            }
            count += 2;
            toggle = !toggle;
        }

        return value;
    }
}
