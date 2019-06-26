package competitiveProgramming.Hackerrank;

import java.util.*;

public class ShrinkingNumberLine {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-100000);
        list.add(100000);
//        list.add(-7);
        System.out.println(minimize(list, 100000));
    }

    public static int minimize(List<Integer> point, int k) {
        List<Integer> newList = new ArrayList<>();

        for (Integer p : point) {
            if (p < 0) {
                newList.add(p + k);
            } else {
                newList.add(p - k);
            }
        }

        int length = newList.size() - 1;
        Collections.sort(newList);
        return newList.get(length) - newList.get(0);
    }

}
