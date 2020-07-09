package competitiveProgramming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/
 * <p>
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 * <p>
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 */
public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        List<String> skip = Arrays.asList("..", ".", "");
        for (String s : path.split("/")) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }

            if (!skip.contains(s)) {
                stack.push(s);
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        for (String s : stack) {
            builder.append(s);
            builder.append("/");
        }


        return (builder.length() > 1) ? builder.deleteCharAt(builder.length() - 1).toString() : "/";
    }
}
