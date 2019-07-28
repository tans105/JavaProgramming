package competitiveProgramming.leetcode;

//https://leetcode.com/problems/palindrome-number/
class PalindromeNumber {

    public static void main(String[] args) {
        int num = 123;
        System.out.println(isPalindrome(num));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }
        int original = x;
        int rev_num = 0;
        while (x > 0) {
            rev_num = rev_num * 10 + x % 10;
            x = x / 10;
        }

        return original == rev_num;
    }
}