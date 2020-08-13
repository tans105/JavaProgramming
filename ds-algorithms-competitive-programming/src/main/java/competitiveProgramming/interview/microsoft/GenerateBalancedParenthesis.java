package competitiveProgramming.interview.microsoft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Exp: https://www.geeksforgeeks.org/microsoft-telephonic-interviews-for-software-engineer-2-year-experienced/

https://leetcode.com/problems/generate-parentheses/

22. Generate Parentheses

Share
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateBalancedParenthesis {
    public static void main(String[] args) {
        generate(3);
    }

    private static void generate(int n) {
        List<List<Character>> list = new ArrayList<>();
        List<Character> temp = new ArrayList<>();
        boolean[] used = new boolean[2 * n];

        String s = "((()))";

        generate(s, temp, list, used);

        list.removeIf(para -> !valid(para));

        System.out.println(list);
    }

    private static void generate(String s, List<Character> temp, List<List<Character>> list, boolean[] used) {
        if (temp.size() == s.length()) {
            list.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) continue;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && used[i - 1]) continue;

            used[i] = true;
            temp.add(s.charAt(i));
            generate(s, temp, list, used);
            used[i] = false;
            temp.remove(temp.size() - 1);

        }
    }

    private static boolean valid(List<Character> current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
