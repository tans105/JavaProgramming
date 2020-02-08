package competitiveProgramming.geekforgeeks.mustdoquestions.strings;

/*
Reverse words in a given string
https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
https://leetcode.com/problems/reverse-words-in-a-string/

Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.

Output:
For each test case, in a new line, output a single line containing the reversed String.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr
 */
public class ReverseWordsInGivenString {
    public static void main(String[] args) {
        System.out.println(reverse("pqr.mno"));
    }

    private static String reverse(String s) {
        if (isNullOrEmpty(s.trim())) return s.trim();

        String[] arr = s.split("\\.");

        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!isNullOrEmpty(arr[i])) {
                builder.append(arr[i].trim());
                builder.append(".");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString().trim();
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }
}
