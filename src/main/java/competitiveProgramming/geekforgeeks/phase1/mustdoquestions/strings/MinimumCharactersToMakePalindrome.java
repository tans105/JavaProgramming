package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.strings;

/**
 * Given a string str we need to tell minimum characters to be added at front of string to make string palindrome.
 * <p>
 * Examples:
 * <p>
 * Input  : str = "ABC"
 * Output : 2
 * We can make above string palindrome as "CBABC"
 * by adding 'B' and 'C' at front.
 * <p>
 * Input  : str = "AACECAAAA";
 * Output : 2
 * We can make above string palindrome as AAAACECAAAA
 * by adding two A's at front of string.
 */
public class MinimumCharactersToMakePalindrome {
    public static void main(String[] args) {
        String s = "AAB";
        int cnt = 0;
        int flag = 0;

        while (s.length() > 0) {
            // if string becomes palindrome then break
            if (isPalindrome(s)) {
                flag = 1;
                break;
            } else {
                cnt++;

                // erase the last element of the string
                s = s.substring(0, s.length() - 1);
            }
        }

        // print the number of insertion at front
        if (flag == 1) {
            System.out.println(cnt);
        }
    }


    private static boolean isPalindrome(String s) {
        int l = s.length();

        for (int i = 0, j = l - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
