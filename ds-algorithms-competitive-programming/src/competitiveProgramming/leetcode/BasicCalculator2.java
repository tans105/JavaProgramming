package competitiveProgramming.leetcode;

import Utils.LoggingUtil;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator-ii/
public class BasicCalculator2 {
    public static void main(String[] args) {
        System.out.println(calculate2(" 4+3+55/44 + 2"));
        System.out.println(calculate(" 4+3+55/44 + 2"));
    }

    private static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim();

        long prevNum = 0;
        int sum = 0;
        char prevOp = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                int val = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    val = val * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                if (prevOp == '+') {
                    sum += prevNum;
                    prevNum = val;
                } else if (prevOp == '-') {
                    sum += prevNum;
                    prevNum = -val;
                } else if (prevOp == '*') {
                    prevNum = prevNum * val;
                } else if (prevOp == '/') {
                    prevNum = prevNum / val;
                }
            } else {
                prevOp = c;
            }
        }

        sum += prevNum;
        return sum;
    }


    private static int calculate2(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;

    }
}
