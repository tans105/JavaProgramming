package competitiveProgramming.leetcode.topinterviewquestions;

public class Atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("  4193 with words"));
        System.out.println(myAtoi("  -4193 with words"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi(null));
        System.out.println(myAtoi(Integer.toString(Integer.MAX_VALUE)));
        System.out.println(myAtoi(Integer.toString(Integer.MIN_VALUE)));
    }

    public static int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;

        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean numberStarts = false;
        boolean isNegative = false;

        for (char c : chars) {
            int intValue = c - '0';

            if (intValue == -3) { // negative number
                isNegative = true;
            }

            if (intValue >= 0 && intValue <= 9) {
                builder.append(intValue);
                numberStarts = true;
            }

            if (builder.isEmpty() && numberStarts) break;
        }

        long result = Long.parseLong(builder.toString());
        return (int) (isNegative ? result * -1 : result);
    }
}
