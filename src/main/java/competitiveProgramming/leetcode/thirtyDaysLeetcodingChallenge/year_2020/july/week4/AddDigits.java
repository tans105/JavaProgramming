package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.july.week4;

/*
Add Digits

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
             Since 2 has only one digit, return it.
Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
    public static void main(String[] args) {
        AddDigits digits = new AddDigits();
        System.out.println(digits.addDigits(9));
    }

    public int addDigits(int num) {
        //Look for pattern, it gets repeated after 9 numbers
        if(num == 0) return 0;
        return (num % 9 == 0) ? 9 : num % 9;
    }
}
