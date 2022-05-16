package competitiveProgramming.leetcode.phase1;

/**
 * https://leetcode.com/problems/add-binary/
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("10", "11"));
    }

    private static String addBinary(String a, String b) {
        boolean carry = false;
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < a1.length; i++) {
            if (i == b1.length) {
                break;
            }
            if (a1[i] == '1' && b1[i] == '1') {
                if (carry) {
                    builder.append('1');
                    carry = true;
                } else {
                    builder.append('0');
                    carry = true;
                }
            }

            if ((a1[i] == '1' && b1[i] == '0') || (a1[i] == '0' && b1[i] == '1')) {
                if (carry) {
                    builder.append('0');
                    carry = true;
                } else {
                    builder.append('1');
                    carry = false;
                }
            }

            if (a1[i] == '0' && b1[i] == '0') {
                if (carry) {
                    builder.append('1');
                    carry = false;
                } else {
                    builder.append('0');
                    carry = false;
                }
            }
        }

        if (carry) {
            builder.append('1');
        }

        return builder.reverse().toString();
    }
}
