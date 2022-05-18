package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.stackqueue;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/

Find the first non-repeating character from a stream of characters
Given a stream of characters, find the first non-repeating character from stream. You need to tell the first non-repeating character in O(1) time at any moment.
If we follow the first approach discussed here, then we need to store the stream so that we can traverse it one more time to find the first non-repeating character at any moment. If we use extended approach discussed in the same post, we need to go through the count array every time first non-repeating element is queried. We can find the first non-repeating character from stream at any moment without traversing any array.
 */
public class FirstNonRepeatingCharacterInAStream {
    public static void main(String[] args) {
        String stream = "geeksforgeeksandgeeksquizfor";
        firstNonRepeatingCharacter(stream);
    }

    private static void firstNonRepeatingCharacter(String s) {
        List<Character> dictionary = new ArrayList<>();
        boolean[] repeated = new boolean[26];
        char[] stream = s.toCharArray();

        for (char c : stream) {
            int charIndex = c - 'a';

            if (!repeated[charIndex]) {
                if (!dictionary.contains(c)) {
                    dictionary.add(c);
                } else {
                    dictionary.remove((Character) c);
                    repeated[charIndex] = true;
                }
            }

            if (dictionary.size() > 0) {
                System.out.println("First Non Repeating Character - " + dictionary.get(0));
            }
        }
    }
}
