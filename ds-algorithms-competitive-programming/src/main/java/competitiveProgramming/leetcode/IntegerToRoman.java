package competitiveProgramming.leetcode;

//https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman {

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));

    }

    private static String intToRoman(int num) {
        StringBuilder val = new StringBuilder();

        while (num != 0) {
            if (num >= 1000) {
                num = num - 1000;
                val.append("M");
            } else if (num >= 900) {
                num = num - 900;
                val.append("CM");
            } else if (num >= 500) {
                num = num - 500;
                val.append("D");
            } else if (num >= 400) {
                num = num - 400;
                val.append("CD");
            } else if (num >= 100) {
                num = num - 100;
                val.append("C");
            } else if (num >= 90) {
                num = num - 90;
                val.append("XC");
            } else if (num >= 50) {
                num = num - 50;
                val.append("L");
            } else if (num >= 40) {
                num = num - 40;
                val.append("XL");
            } else if (num >= 10) {
                num = num - 10;
                val.append("X");
            } else if (num >= 9) {
                num = num - 9;
                val.append("IX");
            } else if (num >= 5) {
                num = num - 5;
                val.append("V");
            } else if (num >= 4) {
                num = num - 4;
                val.append("IV");
            } else {
                num = num - 1;
                val.append("I");
            }
        }
        return val.toString();
    }
}
