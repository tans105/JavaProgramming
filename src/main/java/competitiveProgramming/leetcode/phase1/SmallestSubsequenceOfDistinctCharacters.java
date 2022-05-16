package competitiveProgramming.leetcode.phase1;

import java.util.*;

/*
1081. Smallest Subsequence of Distinct Characters

Return the lexicographically smallest subsequence of text that contains all the distinct characters of text exactly once.

Example 1:

Input: "cdadabcc"
Output: "adbc"
Example 2:

Input: "abcd"
Output: "abcd"
Example 3:

Input: "ecbacba"
Output: "eacb"
Example 4:

Input: "leetcode"
Output: "letcod"


Note:

1 <= text.length <= 1000
text consists of lowercase English letters.
 */
public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(smallestSubsequence("cdadabcc"));
    }

    public static String smallestSubsequence(String text) {
        char[] arr = text.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        Set<Character> seen = new HashSet<>();

        //creating the map of character - number of appearence of the character
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Stack<Character> stack = new Stack<>();

        for (char c : arr) {

            //character has already been considered and can proceed. But the count needs to be reduced
            if (seen.contains(c)) {
                map.put(c, map.get(c) - 1);
                continue;
            }
            // if the top char is larger than current char, we should remove it
            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 1) {
                char temp = stack.pop();
                map.put(temp, map.get(temp) - 1);
                seen.remove(temp);
            }
            stack.push(c);
            seen.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
