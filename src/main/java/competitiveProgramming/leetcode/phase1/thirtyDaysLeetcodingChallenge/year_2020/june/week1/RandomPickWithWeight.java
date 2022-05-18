package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.june.week1;

import java.util.Random;
import java.util.TreeMap;

/*
https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3351/

Random Pick with Weight

Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input:
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input:
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class RandomPickWithWeight {
    Random random;
    TreeMap<Integer, Integer> map;
    private int cnt = 0;

    public RandomPickWithWeight(int[] w) {
        random = new Random();
        map = new TreeMap<>();

        for (int i = 0; i < w.length; i++) {
            cnt += w[i];
            map.put(i, cnt);
        }

        System.out.println(map);
    }

    public int pickIndex() {
        int key = map.higherKey(random.nextInt(cnt));
        return map.get(key);
    }

    public static void main(String[] args) {
        RandomPickWithWeight wt = new RandomPickWithWeight(new int[]{1, 2, 3});
        System.out.println(wt.pickIndex());
        System.out.println(wt.pickIndex());
        System.out.println(wt.pickIndex());
    }
}
