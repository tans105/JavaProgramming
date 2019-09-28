package competitiveProgramming.random;

import java.util.ArrayList;
import java.util.List;

public class MaximalDifference {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(maximalDifference(list));
    }

    static int maximalDifference(List<Integer> a) {
        int maxDifference = -1;
        int rightMax = a.get(a.size() - 1);
        for (int i = a.size() - 2; i >= 0; i--) {
            if (a.get(i) > rightMax)
                rightMax = a.get(i);
            else {
                int diff = rightMax - a.get(i);
                if (diff > maxDifference) {
                    maxDifference = diff;
                }
            }
        }
        return maxDifference;
    }
}
