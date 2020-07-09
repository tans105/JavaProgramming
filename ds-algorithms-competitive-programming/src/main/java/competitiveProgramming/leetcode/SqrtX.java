package competitiveProgramming.leetcode;

/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

    private static int mySqrt(int x) {
        return mySqrtHelper(x, 0, x / 2);
    }

    private static int mySqrtHelper(int x, int low, int high) {
        if (low > high) {
            return 0;
        }
        int mid = low + high / 2;

        if (mid * mid > x) {
            return mySqrtHelper(x, mid + 1, high);
        } else {
            return mySqrtHelper(x, low, mid - 1);
        }
    }
}
