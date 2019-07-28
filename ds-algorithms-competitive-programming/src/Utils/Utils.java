package utils;

import java.util.Stack;

public class Utils {

    public static Stack<Character> populateStack(String s1) {
        Stack<Character> s = new Stack<>();
        int len = s1.length();
        for (int i = len - 1; i >= 0; i--) {
            s.push(s1.charAt(i));
        }
        return s;
    }
}
