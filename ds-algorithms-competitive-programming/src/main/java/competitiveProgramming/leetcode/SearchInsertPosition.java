package competitiveProgramming.leetcode;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert(arr, target));
    }

    private static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            }

            if (nums[i] > target) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            index = nums.length;
        }
        return index;
    }
}
