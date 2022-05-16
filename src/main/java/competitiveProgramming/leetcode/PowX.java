package competitiveProgramming.leetcode;


/*
https://leetcode.com/problems/powx-n/

50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class PowX {

    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }


    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = n * -1;
        }
        return myPowHelper(x, n);
    }

    public static double myPowHelper(double x, int n) {
        if (n == 0) return 1;
        double temp = myPowHelper(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) { //if n = 3 => int of 3/2 = 1 so add x to compensate
            return x * temp * temp;
            } else {
                return (temp * temp) / x; //
            }
        }
    }

}
