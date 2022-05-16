package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;

//https://leetcode.com/problems/remove-element/
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(removeElement(nums, 0));
        ArrayUtils.printArray(nums);
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int currentIndex = 0;
        //check if i=0 is val

        int startingCountsOfNum = 0;
        while (nums[currentIndex] == val) {
            startingCountsOfNum++;
            currentIndex++;
            if(startingCountsOfNum == nums.length) {
                return 0;
            }
        }

        currentIndex = 0;
        for (int i = startingCountsOfNum; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }

        return currentIndex;
    }
}
