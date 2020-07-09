package competitiveProgramming.leetcode;

import utils.ArrayUtils;

//https://leetcode.com/problems/zigzag-conversion/
public class ZigZagConversion {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int num = 2;
        convert(str, num);
    }

    private static String convert(String s, int numRows) {
        char[] arr = s.toCharArray();
        ArrayUtils.printArray(arr);
        char[][] index = new char[numRows][arr.length / 2]; //maximum number of columns will appear when numRows = 2
        int currentCharIndex = 0;
        int i = 0, j = 0;
        if (numRows == 1) {
            ArrayUtils.printArray(arr);
            return s;
        }
        breakpoint:
        while (currentCharIndex < arr.length) {
            if (i == 0) {
                for (int k = 0; k < numRows; k++) {
                    index[k][j] = arr[currentCharIndex];
                    currentCharIndex++;
                    if (checkBreakpoint(currentCharIndex, arr.length)) break breakpoint;
                }
                i += numRows - 1;
            } else {
                for (int k = numRows - 2; k > 0; k--) {
                    j++;
                    index[k][j] = arr[currentCharIndex];
                    currentCharIndex++;
                    if (checkBreakpoint(currentCharIndex, arr.length)) break breakpoint;
                }
                j++;
                i = 0;
            }
        }
        ArrayUtils.print2DArray(index);
        return s;
    }

    private static boolean checkBreakpoint(int currentCharIndex, int capacity) {
        return currentCharIndex >= capacity;
    }
}
