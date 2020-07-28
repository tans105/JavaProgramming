package competitiveProgramming.others.practise;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiskSpaceAnalysis {

    public static void main(String[] args) {
        System.out.println(segment(3, Arrays.asList(2, 5, 4, 6, 8)));
        System.out.println(segment(2, Arrays.asList(1, 1, 1)));
        System.out.println(segment(1, Arrays.asList(1, 2, 3, 1, 2)));
        System.out.println(segment(2, Arrays.asList(8, 2, 4)));
    }

    public static int segment(int x, List<Integer> space) {
        if(x == 0) return 0;
        if(space == null || space.size() == 0) return 0;

        List<Integer> result = new ArrayList<>();
        List<Integer> segment = new ArrayList<>();
        int segMin = Integer.MAX_VALUE;

        for (int i = 0; i < x; i++) {
            if (space.get(i) < segMin) {
                segMin = space.get(i);
            }
            segment.add(space.get(i));
        }

        result.add(segMin);


        for (int i = x; i < space.size(); i++) {
            segment.remove(0);
            segment.add(space.get(i));
            int min = getMin(segment);
            result.add(min);
        }


        return getMax(result);
    }

    private static int getMin(List<Integer> segment) {
        int min = Integer.MAX_VALUE;
        for (Integer integer : segment) {
            min = Math.min(min, integer);
        }

        return min;
    }

    private static int getMax(List<Integer> segment) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : segment) {
            max = Math.max(max, integer);
        }

        return max;
    }
}
