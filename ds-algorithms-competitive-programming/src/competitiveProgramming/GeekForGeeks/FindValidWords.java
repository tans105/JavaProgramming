package competitiveProgramming.GeekForGeeks;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/print-valid-words-possible-using-characters-array/
 * Given a dictionary and a character array, print all valid words that are possible using characters from the array.
 * <p>
 * Examples:
 * <p>
 * Input : Dict - {"go","bat","me","eat","goal",
 * "boy", "run"}
 * arr[] = {'e','o','b', 'a','m','g', 'l'}
 * Output : go, me, goal.
 */
public class FindValidWords {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("go", "baat", "me", "eat", "goal", "boy", "run");
        char[] letters = {'e', 'o', 'b', 'a', 'm', 'g', 'l', 'a', 't'};

        System.out.println(findValidWords(dict, letters));
    }

    static List<String> findValidWords(List<String> dict, char letters[]) {
        int[] avail = new int[26];
        for (char c : letters) {
            int index = c - 'a';
            avail[index]++;
        }
        ArrayUtils.printArray(avail);
        List<String> result = new ArrayList();
        for (String word : dict) {
            int[] count = new int[26];
            boolean ok = true;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                count[index]++;
                if (count[index] > avail[index]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                result.add(word);
            }
        }
        return result;
    }
}
