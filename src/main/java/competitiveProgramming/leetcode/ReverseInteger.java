package competitiveProgramming.leetcode;

//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

    public static void main(String[] args) {
        int num = -1231231429;
        System.out.println(reverse(num));
    }

    private static int reverse(int x) {
        Long num1 = (long) x;
        boolean isNegative = false;
        if (num1 < 0) {
            num1 = num1 * -1;
            isNegative = true;
        }
        StringBuilder builder = new StringBuilder(num1.toString());
        Long reverseNum = Long.parseLong(builder.reverse().toString());
        if (reverseNum >= Integer.MAX_VALUE) return 0;
        return (isNegative) ? (Integer.parseInt(builder.toString()) * -1) : Integer.parseInt(builder.toString());
    }

}
