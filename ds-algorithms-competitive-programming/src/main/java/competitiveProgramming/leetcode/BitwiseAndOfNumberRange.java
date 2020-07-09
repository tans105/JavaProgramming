package competitiveProgramming.leetcode;

/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
 */
public class BitwiseAndOfNumberRange {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(1, 1));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int value = m;
        for (int i = m+1; i <= n; i++) {
            value = value & i;
        }
        return value;
    }
}
