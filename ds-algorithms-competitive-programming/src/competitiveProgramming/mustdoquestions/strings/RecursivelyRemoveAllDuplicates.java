package competitiveProgramming.mustdoquestions.strings;

import java.util.Stack;

/*
https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0

Recursively remove all adjacent duplicates

Given a string s, recursively remove adjacent duplicate characters from the string s. The output string should not have any adjacent duplicates.


Input:
The first line of input contains an integer T, denoting the no of test cases. Then T test cases follow. Each test case contains a string str.

Output:
For each test case, print a new line containing the resulting string.

Constraints:
1<=T<=100
1<=Length of string<=50

Example:
Input:
2
geeksforgeek
acaaabbbacdddd

Output:
gksforgk
acac
 */
public class RecursivelyRemoveAllDuplicates {
    public static void main(String[] args) {
        System.out.println(removeRecursive("aaaaaa"));
    }

    private static String removeRecursive(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int i = 0;

        while (i < arr.length) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                i++;
                continue;
            }

            char temp = stack.pop();
            boolean isSame = false;

            while (i < arr.length && temp == arr[i]) {
                isSame = true;
                i++;
            }

            if (!isSame) {
                stack.push(temp);
                stack.push(arr[i]);
                i++;
            }
        }

        StringBuilder builder = new StringBuilder();

        for (Character c : stack) {
            builder.append(c);
        }

        return builder.toString();
    }

}
