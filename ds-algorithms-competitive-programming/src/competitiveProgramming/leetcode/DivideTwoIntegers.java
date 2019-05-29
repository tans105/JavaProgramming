package competitiveProgramming.leetcode;

import Utils.LoggingUtil;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide2(7, 3));
    }

    private static int divide(int dividend, int divisor) {
        long quotient = 0;
        boolean negativeDivident = false;
        boolean negativeDivisor = false;
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);

        if (dividendLong < 0) {
            dividendLong = dividendLong * -1;
            negativeDivident = true;
        }
        if (divisorLong < 0) {
            divisorLong = divisorLong * -1;
            negativeDivisor = true;
        }

        while (dividendLong >= divisorLong) {
            quotient++;
            dividendLong = dividendLong - divisorLong;
        }

        if (quotient > Integer.MAX_VALUE) {
            return 2147483647;
        }

        if (quotient < Integer.MIN_VALUE) {
            return 2147483647;
        }

        if (negativeDivident && negativeDivisor) {
            return (int) quotient;
        }

        return (int) ((negativeDivident || negativeDivisor) ? quotient * -1 : quotient);
    }

    /*Solution ....*/
    public static int divide2(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE) { //Handle overflow.
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private static long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        LoggingUtil.logNewLine("Multiple" , multiple);
        LoggingUtil.logNewLine("Sum", sum);
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
