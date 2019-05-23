package competitiveProgramming.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
        System.out.println(generateParenthesis2(n));
    }

    private static List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        char[] arr = new char[n * 2];
        generate(n * 2, arr, l);
        return l;
    }

    private static void generate(int n, char[] arr, List<String> l) {
        if (n < 1) {
            String b = new String(arr);
            if (valid(b.toCharArray())) {
                l.add(b);
            }
        } else {
            arr[n - 1] = '(';
            generate(n - 1, arr, l);
            arr[n - 1] = ')';
            generate(n - 1, arr, l);
        }
    }

    private static boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    //------------------------ Method 2 -----------------------------//

    /*
     * Instead of adding '(' or ')' every time as in Approach 1, let's only add them when we know it will remain a valid sequence.
     * We can do this by keeping track of the number of opening and closing brackets we have placed so far.
     * We can start an opening bracket if we still have one (of n) left to place. And we can start a closing bracket if it would not exceed the number of opening brackets.
     * */

    public static List<String> generateParenthesis2(int n) {
        ArrayList ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private static void backtrack(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }
}
