package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.may.week2;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/

Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.



Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10



Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8})); //2
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11})); //10
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7})); //7
        System.out.println(singleNonDuplicate(new int[]{3, 7, 7})); //3
        System.out.println(singleNonDuplicate(new int[]{3})); //3
        System.out.println(singleNonDuplicate(new int[]{1, 2, 2, 3, 3})); //1
    }

    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        //logic : If every element in the sorted array were to appear exactly twice, they would occur in pairs at indices i, i+1 for all even i.
        while (low < high) {
            int mid = (low + high) / 2; // length of array will always be odd.

            if (mid > 0 && nums[mid] != nums[mid - 1] && mid < nums.length - 1 && nums[mid] != nums[mid + 1] //normal case
                    || (mid == 0 && nums[mid] != nums[mid + 1]) //if the element is the first one
                    || (mid == nums.length - 1 && nums[mid] != nums[mid - 1]))  //if the element is the last one
                return nums[mid];


            if ((mid % 2 == 0 && nums[mid] != nums[mid - 1]) || (mid % 2 != 0 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
}
