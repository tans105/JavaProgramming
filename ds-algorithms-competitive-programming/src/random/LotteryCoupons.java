package random;

import utils.ArrayUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LotteryCoupons {
    public static void main(String[] args) {
        System.out.println(getCount(22));
    }

    public static int getCount(int n) {
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (i > 9) {
                arr[i - 1] = getFaceValue(i);
            } else {
                arr[i - 1] = i;
            }

            if (map.containsKey(arr[i - 1])) {
                map.put(arr[i - 1], map.get(arr[i - 1]) + 1);
            } else {
                map.put(arr[i - 1], 1);
            }
        }

        int count = 0;
        int standard = map.get(1);

        for (int i = 1; i < map.size() + 1; i++) {
            if (map.get(i) != standard) {
                break;
            }
            count++;
        }

        return count;
    }

    public static int getFaceValue(int num) {
        int k = num;
        int sum = 0;
        while (k != 0) {
            sum += k % 10;
            k = k / 10;
        }
        String sumStr = String.valueOf(sum);

        if(sumStr.length() > 1) {
            return getFaceValue(sum);
        } else {
            return sum;
        }

    }
}
