package competitiveProgramming.mustdoquestions.arrays;

/*
Last index of One
https://practice.geeksforgeeks.org/problems/last-index-of-1/0

Given a string S consisting only '0's and '1's,  print the last index of the '1' present in it.

Input:
First line of the input contains the number of test cases T, T lines follow each containing a stream of characters.

Output:
Corresponding to every test case, output the last index of 1. If 1 is not present, print "-1" (without quotes).

Constraints:
1 <= T <= 110
1 <= |S| <= 106

Example:
Input:
2
00001
0
Output:
4
-1

Explanation:
Testcase 1: Last index of  1 in given string is 4.
Testcase 2: Since, 1 is not present, so output is -1.
 */
public class LastIndexOfOne {
    public static void main(String[] args) {
        System.out.println(firstOccurance("00001"));
    }

    private static int firstOccurance(String s) {
        char[] arr = s.toCharArray();
        int low = 0;
        int high = s.length() - 1;
        boolean hasOne = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == '1') {
                hasOne = true;
                high = mid - 1;
            }

            if (arr[mid] == '0') {
                low = mid + 1;
            }
        }

        return (hasOne) ? low : -1;
    }
}
