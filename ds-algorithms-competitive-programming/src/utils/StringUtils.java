package utils;

import java.util.Stack;

public class StringUtils {

    public static Stack<Character> populateStackFromString(String s1) {
        Stack<Character> s = new Stack<>();
        int len = s1.length();
        for (int i = len - 1; i >= 0; i--) {
            s.push(s1.charAt(i));
        }
        return s;
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
