package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.september.week4;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int prod = 1, ans = 0, i = 0;
        for (int j = 0; j < nums.length; j++) {
            prod *= nums[j];

            while (prod >= k) {
                prod /= nums[i];
                i++;
            }
            ans += j - i + 1;
        }

        return ans;
    }
}
