package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.october.week1;

import java.util.*;

public class KDiffPairInArray {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 0));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 1}, 0));
    }

    public static int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int num : nums) {
            set.add(num);
            int c = map.getOrDefault(num, 0);
            map.put(num, c + 1);
        }

        if (k == 0) {
            for (Integer num : set) {
                if (map.get(num) > 1) count++;
            }
        } else {
            for (Integer num : set) {
                if (set.contains(num - k)) count++;
            }
        }

        return count;
    }
}
