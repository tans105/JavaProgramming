package competitiveProgramming.geekforgeeks;

/*
https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/

Number of flips to make binary string alternate | Set 1
Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate characters by flipping some of the bits, our goal is to minimize the number of bits to be flipped.
Examples :

Input : str = “001”
Output : 1
Minimum number of flips required = 1
We can flip 1st bit from 0 to 1

Input : str = “0001010111”
Output : 2
Minimum number of flips required = 2
We can flip 2nd bit from 0 to 1 and 9th
bit from 1 to 0 to make alternate
string “0101010101”.
Expected time complexity : O(n) where n is length of input string.
 */
public class NumberOfFlipsToMakeBinaryStringAlternate {
    public static void main(String[] args) {
        System.out.println(getMinimumNumberOfFlip("101000101"));
    }

    private static int getMinimumNumberOfFlip(String s) {
        int flipZeroCost = getFlippedStringStartingFrom(s, "0");
        int flipOneCost = getFlippedStringStartingFrom(s, "1");
        return Math.min(flipOneCost, flipZeroCost);
    }

    private static int getFlippedStringStartingFrom(String s, String startsFrom) {
        char one = startsFrom.equals("0") ? '0' : '1';
        char two = startsFrom.equals("0") ? '1' : '0';
        boolean toggle = true;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if(toggle) {
                if(s.charAt(i) != one) count++;
            } else {
                if(s.charAt(i) != two) count++;
            }

            toggle = !toggle;
        }

        return count;
    }
}
