package competitiveProgramming.leetcode;

import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
166. Fraction to Recurring Decimal

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
 */
public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-50, 8));
    }

    public static String fractionToDecimal(int divident, int divisor) {
        boolean isNegative = false;
        if (divident < 0) {
            isNegative = true;
            divident *= -1;
        }
        if (divisor < 0) {
            isNegative = true;
            divisor *= -1;
        }

        StringBuilder quotient = new StringBuilder();
        int r = divident % divisor;
        int q = (divident - r) / divisor;

        quotient.append(q);
        if (r == 0) {
            return quotient.toString();
        }

        Map<Integer, Integer> remainders = new HashMap<>();
        quotient.append(".");
        divident = r * 10;
        int index = 0;
        while (r != 0) {

            if (remainders.containsKey(r)) {
                int startIndex = remainders.get(r);
                quotient.insert(quotient.indexOf(".") + startIndex + 1, "(");
                quotient.append(")");
                break;
            }

            remainders.put(r, index);
            index++;
            r = divident % divisor;
            q = (divident - r) / divisor;
            quotient.append(q);
            divident = r * 10;
        }

        if (isNegative) quotient.insert(0, "-");

        return quotient.toString();
    }
}

