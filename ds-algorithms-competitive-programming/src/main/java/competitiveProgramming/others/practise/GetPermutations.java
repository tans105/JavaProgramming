package competitiveProgramming.others.practise;

import java.util.ArrayList;
import java.util.List;

public class GetPermutations {
    public static void main(String[] args) {
        System.out.println(getPermutations("askitrightik", "kit", 1));
    }

    private static List<String> getPermutations(String word, String p, int x) {
        List<String> permutations = new ArrayList<String>();

        int[] reference = new int[26];
        int[] dictionary = new int[26];
        int expectedCount = p.length() - x;

        for (int i = 0; i < p.length(); i++) {
            reference[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            dictionary[word.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = p.length() - 1;

        while (i < word.length()) {

            int count = compareWindow(reference, dictionary);
            if (count >= expectedCount) {
                permutations.add(word.substring(i, j + 1));
            }

            i++;
            j++;
            if (j >= word.length()) break;
            generateWindow(dictionary, i - 1, j, word);

        }

        return permutations;
    }

    private static void generateWindow(int[] dictionary, int i, int j, String word) {
        dictionary[word.charAt(i) - 'a']--;
        dictionary[word.charAt(j) - 'a']++;
    }

    private static int compareWindow(int[] reference, int[] dictionary) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (dictionary[i] >= reference[i]) {
                count += reference[i];
            }
        }

        return count;
    }


}

