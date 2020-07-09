package competitiveProgramming.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("2345"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }

        char[] charArray = digits.toCharArray();

        if (charArray.length == 1) {
            for (char c : charBook(charArray[0])) {
                list.add(String.valueOf(c));
            }
        } else {
            for (char c : charBook(charArray[0])) {
                list.add(String.valueOf(c));
            }
            for (int i = 1; i < charArray.length; i++) {
                list = merge(list, charBook(charArray[i]));
            }
        }
        return list;
    }

    private static List<String> merge(List<String> list, char[] chars) {
        List<String> list1 = new ArrayList<>();
        for (String aList : list) {
            for (char aChar : chars) {
                list1.add(aList + aChar);
            }
        }
        return list1;
    }


    public static char[] charBook(char digit) {
        if (digit == '2') {
            return new char[]{'a', 'b', 'c'};
        } else if (digit == '3') {
            return new char[]{'d', 'e', 'f'};
        } else if (digit == '4') {
            return new char[]{'g', 'h', 'i'};
        } else if (digit == '5') {
            return new char[]{'j', 'k', 'l'};
        } else if (digit == '6') {
            return new char[]{'m', 'n', 'o'};
        } else if (digit == '7') {
            return new char[]{'p', 'q', 'r', 's'};
        } else if (digit == '8') {
            return new char[]{'t', 'u', 'v'};
        } else if (digit == '9') {
            return new char[]{'w', 'x', 'y', 'z'};
        } else {
            return new char[0];
        }
    }
}
