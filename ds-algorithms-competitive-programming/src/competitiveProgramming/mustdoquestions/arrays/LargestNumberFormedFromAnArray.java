package competitiveProgramming.mustdoquestions.arrays;

import java.util.*;

public class LargestNumberFormedFromAnArray {
    public static void main(String[] args) {
        System.out.println(largestNumber(Arrays.asList(54, 546, 548, 60)));
    }

    private static String largestNumber(List<Integer> list) {
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int t1 = Integer.parseInt(i1 + "" + i2);
                int t2 = Integer.parseInt(i2 + "" + i1);

                return (t1 > t2) ? -1 : 1;
            }
        });

        StringBuilder strbul = new StringBuilder();

        for (Integer integer : list) {
            strbul.append(integer);
        }
        return strbul.toString();
    }
}
