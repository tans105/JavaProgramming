package competitiveProgramming.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
228. Summary Ranges

Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges sum = new SummaryRanges();
        System.out.println(sum.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int i = 1;

        while (i < nums.length + 1) {
            int count = 0;
            int j = i;
            int start = nums[j - 1];
            while (j < nums.length && nums[j] == nums[j - 1] + 1) {
                count++;
                j++;
            }
            if (count == 0) {
                result.add(String.valueOf(nums[j - 1]));
                i++;
            } else {
                result.add(start + "->" + nums[j - 1]);
                i = j + 1;
            }
        }


        return result;
    }
}
