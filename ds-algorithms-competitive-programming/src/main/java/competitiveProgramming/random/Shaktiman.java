package competitiveProgramming.random;

import java.util.Arrays;
import java.util.List;

public class Shaktiman {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{-5, 4, -2, 3, 1, -1, -6, -1, 0, -5};
        System.out.println(shaktimaan(Arrays.asList(nums)));
    }

    static int shaktimaan(List<Integer> power) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (Integer p : power) {
            sum += p;
            if (sum < min) {
                min = sum;
            }
        }
        return min * -1 + 1;
    }
}
