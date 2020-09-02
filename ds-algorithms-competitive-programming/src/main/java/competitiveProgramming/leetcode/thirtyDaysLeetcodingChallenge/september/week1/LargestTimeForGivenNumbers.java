package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.september.week1;

import java.util.ArrayList;
import java.util.List;

public class LargestTimeForGivenNumbers {
    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    }

    public static String largestTimeFromDigits(int[] A) {
        List<String> permutations = permutations(A);
        String res = "";
        for (String p : permutations) {
            String HH = p.substring(0, 2);
            String MM = p.substring(2);
            if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(HH + ":" + MM) < 0)
                res = HH + ":" + MM;
        }

        return res;
    }

    private static List<String> permutations(int[] A) {
        StringBuilder s = new StringBuilder();
        for (int a : A)
            s.append(a);
        List<String> list = new ArrayList<>();
        permutations(s.toString(), "", list);
        return list;
    }

    private static void permutations(String s, String sofar, List<String> list) {
        if (s.isEmpty()) list.add(sofar);

        for (int i = 0; i < s.length(); i++) {
            permutations(s.substring(0, i) + s.substring(i + 1), sofar + s.charAt(i), list);
        }
    }
}
