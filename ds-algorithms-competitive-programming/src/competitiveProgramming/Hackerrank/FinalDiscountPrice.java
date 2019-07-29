package competitiveProgramming.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalDiscountPrice {
    public static void main(String[] args) {
        List l = Arrays.asList(new Integer[]{2,3,1,2,4,2});
        finalPrice(l);
    }

    public static void finalPrice(List<Integer> prices) {
        if (prices == null || prices.size() == 0) {
            System.out.println(0);
        }
        List<Integer> noDiscount = new ArrayList<>();
        int currentDiscount = 0;
        int nextLower = -1;
        for (int i = 0; i < prices.size(); i++) {
            nextLower = findNextLowest(prices, i + 1, prices.get(i));
            if (nextLower == -1) {
                currentDiscount += prices.get(i);
                noDiscount.add(i);
            } else {
                currentDiscount += (prices.get(i) - nextLower);
            }
        }
        System.out.println(currentDiscount);

        for(Integer j: noDiscount) {
            System.out.print(j + " ");
        }

    }

    public static int findNextLowest(List<Integer> prices, Integer start, Integer current) {
        for (int i = start; i < prices.size(); i++) {
            if (prices.get(i) <= current) {
                return prices.get(i);
            }
        }
        return -1;
    }
}
