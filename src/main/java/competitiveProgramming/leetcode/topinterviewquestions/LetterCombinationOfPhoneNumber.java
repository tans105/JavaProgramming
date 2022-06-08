package competitiveProgramming.leetcode.topinterviewquestions;

import java.util.ArrayList;
import java.util.List;

/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();

        if (digits == null) {return combinations;}
        char[] digits_ = digits.toCharArray();

        for (char c : digits_) {
            permute(c, combinations);
        }

        return combinations;
    }

    private static void permute(char c, List<String> combinations) {
        char[] mappings = getMappings(c);

        if (combinations.size() == 0) {
            for (char mapping : mappings) {
                combinations.add(String.valueOf(mapping));
            }
        }
        else {
            List<String> copy = new ArrayList<>(combinations);
            for (String current : copy) {
                combinations.remove(current);

                for (char mapping : mappings) {
                    combinations.add(current + mapping);
                }
            }
        }
    }


    public static char[] getMappings(char c) {
        char[] mappings = new char[]{};
        switch (c) {
            case '2': {
                mappings = new char[]{'a', 'b', 'c'};
                break;
            }
            case '3': {
                mappings = new char[]{'d', 'e', 'f'};
                break;
            }
            case '4': {
                mappings = new char[]{'g', 'h', 'i'};
                break;
            }
            case '5': {
                mappings = new char[]{'j', 'k', 'l'};
                break;
            }
            case '6': {
                mappings = new char[]{'m', 'n', 'o'};
                break;
            }
            case '7': {
                mappings = new char[]{'p', 'q', 'r', 's'};
                break;
            }
            case '8': {
                mappings = new char[]{'t', 'u', 'v'};
                break;
            }
            case '9': {
                mappings = new char[]{'w', 'x', 'y', 'z'};
                break;
            }
        }

        return mappings;
    }
}
