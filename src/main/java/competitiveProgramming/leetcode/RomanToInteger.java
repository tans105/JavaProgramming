package competitiveProgramming.leetcode;

public class RomanToInteger {
    public static void main(String[] args) {
        String roman = "MCMXCIV";
        System.out.println(romanToInteger(roman));
    }

    private static int romanToInteger(String roman) {
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
        char[] val = roman.toCharArray();
        char prev = 0;
        int total = 0;
        for (char c : val) {
            if (c == 'M' & prev != 'C') {
                total += 1000;
            }
            if (c == 'M' && prev == 'C') {
                total -= 100;
                total += 900;
            }

            if (c == 'D' & prev != 'C') {
                total += 500;
            }
            if (c == 'D' && prev == 'C') {
                total -= 100;
                total += 400;
            }

            if (c == 'C' & prev != 'X') {
                total += 100;
            }
            if (c == 'C' && prev == 'X') {
                total -= 10;
                total += 90;
            }

            if (c == 'L' & prev != 'X') {
                total += 50;
            }
            if (c == 'L' && prev == 'X') {
                total -= 10;
                total += 40;
            }

            if (c == 'X' & prev != 'I') {
                total += 10;
            }
            if (c == 'X' && prev == 'I') {
                total -= 1;
                total += 9;
            }

            if (c == 'V' & prev != 'I') {
                total += 5;
            }
            if (c == 'V' && prev == 'I') {
                total -= 1;
                total += 4;
            }

            if (c == 'I') {
                total += 1;
            }

            prev = c;
        }
        return total;
    }
}
