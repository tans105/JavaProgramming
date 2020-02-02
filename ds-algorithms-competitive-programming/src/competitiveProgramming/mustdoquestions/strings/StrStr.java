package competitiveProgramming.mustdoquestions.strings;

/*
Your task is to implement the function strstr. The function takes two strings as arguments (s,x) and  locates the occurrence of the string x in the string s. The function returns and integer denoting the first occurrence of the string x in s.

Input Format:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. The first line of each test case contains two strings s and x.

Output Format:
For each test case, in a new line, output will be an integer denoting the first occurrence of the x in the string s. Return -1 if no match found.

Your Task:
Since this is a function problem, you don't have to take any input. Just complete the strstr() function. The function returns -1 if no match if found else it returns an integer denoting the first occurrence of the x in the string s.

Constraints:
1 <= T <= 200
1<= |s|,|x| <= 1000

Example:
Input
2
GeeksForGeeks Fr
GeeksForGeeks For
Output
-1
5

Explanation:
Testcase 1: Fr is not present in the string GeeksForGeeks as substring.
Testcase 2: For is present as substring in GeeksForGeeks from index 5.
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("a", ""));
    }

    public static int strStr(String s1, String s2) {
        if (s1 == null || s2 == null) return -1;

        int index = -1;
        int i = 0, j = 0;

        while (i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                while (i < s1.length() && j < s2.length()) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        j = 0;
                        break;
                    }
                }
                if (j != 0) {
                    index = i - s2.length();
                    break;
                }
            } else {
                i++;
            }
        }

        return index;
    }
}
