package competitiveProgramming.interview.Microsoft;

/*
Find the largest Alphabetic character present in the string

Given a string str, our task is to find the Largest Alphabetic Character, whose both uppercase and lowercase are present in the string. The uppercase character should be returned. If there is no such character then return -1 otherwise print the uppercase letter of the character.

Examples:

    Input: str = “admeDCAB”
    Output: D
    Explanation:
    Both the uppercase and lowercase characters for letter D is present in the string and it is also the largest alphabetical character, hence our output is D.

    Input: str = “dAeB”
    Output: -1
    Explanation:
    Althogh the largest character is d in the string but the uppercase version is not present hence the output is -1.
 */

public class LargestAlphabeticCharacterInAString {
    public static void main(String[] args) {
        System.out.println(largest("admeDCAB"));
        System.out.println(largest("dAeB"));
        System.out.println(largest("aaaa"));
        System.out.println(largest("BBBB"));
        System.out.println(largest("aBA"));
    }

    private static String largest(String str) {
        int[] arr = new int[26];

        for (char c : str.toCharArray()) {
            if (c - 'A' < 26) {
                if (arr[c - 'A'] != 1) arr[c - 'A'] = arr[c - 'A'] + 1;
            } else if (c - 'a' < 26) {
                if (arr[c - 'a'] != 2) arr[c - 'a'] = arr[c - 'a'] + 2;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if(arr[i] == 3) return String.valueOf(i);
        }

        return "-1";
    }
}
