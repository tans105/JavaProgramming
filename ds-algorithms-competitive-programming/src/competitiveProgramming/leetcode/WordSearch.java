package competitiveProgramming.leetcode;

public class WordSearch {
    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(arr, "abcd"));
    }

    private static boolean exist(char[][] board, String word) {
        int[] alphabetArray = new int[100];
        int[] wordAlphabetArray = new int[100];

        for (char[] chars : board) {
            formulateAlphabetArray(chars, alphabetArray);
        }
        formulateAlphabetArray(word.toCharArray(), wordAlphabetArray);
        return checkFeasibility(wordAlphabetArray, alphabetArray);
    }

    private static boolean checkFeasibility(int[] wordAlphabetArray, int[] alphabetArray) {
        for (int i = 0; i < alphabetArray.length; i++) {
            if (alphabetArray[i] - wordAlphabetArray[i] < 0) {
                return false;
            }
        }
        return true;
    }

    private static void formulateAlphabetArray(char[] chars, int[] alphabetArray) {
        for (char aChar : chars) {
            alphabetArray[aChar - 'A'] = ++alphabetArray[aChar - 'A'];
        }
    }
}
