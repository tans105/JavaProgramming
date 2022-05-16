package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] m = {0, 0, 0, 0, 0};
        int[] n = {2, 5, 6, 7, 9};
        merge(m, 3, n, 3);
        ArrayUtils.printArray(m);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == 0) {
                nums3[k] = nums2[j];
                k++;
                j++;
                continue;
            }
            if (j <= nums2.length - 1 && nums1[i] <= nums2[j]) {
                nums3[k] = nums1[i];
                i++;
                k++;
            }
            if (nums1[i] > nums2[j]) {
                nums3[k] = nums2[j];
                j++;
                k++;
            }
        }

        System.arraycopy(nums3, 0, nums1, 0, nums3.length);
    }
}
