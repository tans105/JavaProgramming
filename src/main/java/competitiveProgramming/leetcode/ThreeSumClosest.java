package competitiveProgramming.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    /*
        Given array nums = [-1, 2, 1, -4], and target = 1.
        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    */
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest2(nums, target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MIN_VALUE;
        int diff;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    diff = target - (nums[i] + nums[j] + nums[k]);
                    if (Math.abs(diff) < Math.abs(minDiff)) {
                        minDiff = diff;
                        closestSum = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return closestSum;
    }

    private static int threeSumClosest2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int minimumDistance = Integer.MAX_VALUE;
        int sum = 0;

        Arrays.sort(nums);

        // a + b + c = Target
        // a + b = Target - c
        // let's call (Target - c) as the variable newTarget below
        for (int c = 0; c < nums.length; c++) {
            int a = 0;//place "pointers" on both ends of the array
            int b = nums.length - 1;

            while (a < b) {
                if (a == c) {//let' skip over index c (since we're already considering it in the "final" sum
                    a++;
                    continue;
                } else if (b == c) {
                    b--;
                    continue;
                }

                int currSum = nums[a] + nums[b];
                int newTarget = target - nums[c];

                int currentDistance = Math.abs(newTarget - currSum);
                if (currentDistance == 0) {
                    return target;
                }
                if (currentDistance < minimumDistance) {
                    minimumDistance = currentDistance;
                    sum = currSum + nums[c];//we want to return a+b+c at the end of this problem
                }

                if (currSum >= newTarget) b--;
                else a++;
            }
        }
        return sum;
    }
}
