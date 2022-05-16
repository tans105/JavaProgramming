package competitiveProgramming.leetcode.phase1;

import java.math.BigInteger;

//https://leetcode.com/problems/string-to-integer-atoi/
public class StringToIntegerATOI {
    public static void main(String[] args) {
        String s = "   - 321";
        System.out.println(myAtoi(s));
    }

    private static int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }

        char[] arr = str.toCharArray();

        try {
            Integer.parseInt(String.valueOf(arr[0]));
        } catch (Exception e) {
            if (arr[0] == ' ') {

            } else if ((arr[0] == '+' || arr[0] == '-') && arr.length > 1) {
                char c = arr[1];
                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {

                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }

        boolean foundInt = false;
        boolean isNegative = false;
        Character prev = '+';
        StringBuilder builder = new StringBuilder();
        for (char c : arr)

        {
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                if (!isNegative && prev == '-') {
                    isNegative = true;
                }
                foundInt = true;
                builder.append(c);
            } else if (foundInt) {
                break;
            }
            prev = c;
        }

        if (builder.length() == 0) {
            return 0;
        }

        String finalValue = (isNegative) ? "-" + builder.toString() : builder.toString();
        BigInteger finalLongValue = new BigInteger(finalValue);
        if (finalLongValue.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            return Integer.MAX_VALUE;
        }

        if (finalLongValue.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            return Integer.MIN_VALUE;
        }

        return Integer.parseInt(finalValue);
    }
}
