package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;
import utils.LoggingUtil;

import java.util.HashMap;
import java.util.Map;

/*
136. Single Number

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(ArrayUtils.parseArray("[2,2,1]")));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int num = -1;
        for (int value : nums) {
            if (map.containsKey(value)) {
                int count = map.get(value);
                map.put(value, count + 1);
            } else {
                map.put(value, 1);
            }
        }

        for(Map.Entry e: map.entrySet()) {
            if(Integer.parseInt(e.getValue().toString()) == 1) {
                return Integer.parseInt(e.getKey().toString());
            }
        }
        return 0;
    }
}
