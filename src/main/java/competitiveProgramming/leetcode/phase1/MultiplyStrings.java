package competitiveProgramming.leetcode.phase1;

import java.util.ArrayList;

//https://leetcode.com/problems/multiply-strings/

//Tag: Not complete but working
public class MultiplyStrings {

    /**
     *
     *
     */
    public static void main(String[] args) {
        System.out.println(multiply("12", "456"));
    }

    public static String multiply(String num1, String num2) {
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        Integer sum = 0;
        ArrayList<StringBuilder> levels = new ArrayList<>();
        StringBuilder level;

        int carry = 0;
        int zeros = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            level = new StringBuilder();
//            System.out.println("<-----------------" + i + "-------------------->");
            for (int j = num2.length() - 1; j >= 0; j--) {
                sum = (num1Char[i] - '0') * (num2Char[j] - '0') + carry;
                if (sum > 10) {
                    carry = sum / 10;
                    level.append(sum % 10);
                } else {
                    level.append(sum);
                    carry = 0;
                }
//                LoggingUtil.logNewLine(num1Char[i], num2Char[j]);
            }
            if (carry > 0) {
                level.append(carry);
                carry = 0;
            }
            appendZeros(level.reverse(), zeros);
            zeros++;
            levels.add(level);
        }
//        System.out.println(levels);
        return computeSum(levels);
    }

    private static String computeSum(ArrayList<StringBuilder> levels) {
        Integer sum = 0;
        for (StringBuilder level : levels) {
            sum += Integer.parseInt(level.toString());
        }

        return sum.toString();
    }

    private static StringBuilder appendZeros(StringBuilder level, int j) {
        for (int i = 0; i < j; i++) {
            level.append(0);
        }
        return level;
    }

}
