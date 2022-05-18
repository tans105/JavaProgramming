package competitiveProgramming.geekforgeeks.phase1;


import java.util.Arrays;

/*
https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/

Resource -> https://www.youtube.com/watch?v=GTJr8OvyEVQ
 */
public class KMPPatternMatchingAlgorithm {
    public static void main(String[] args) {
        String txt = "AABAACAADAABAABA";
        String pat = "AABA";
        System.out.println(KMPSearch(pat, txt));
    }

    private static boolean KMPSearch(String pat, String txt) {
        int[] arr = generatePrefixArray(pat);
        boolean found = false;
        int j = 0;
        int i = 0;
        int index = 0;
        boolean checking = false;

        while (i < txt.length()) {
            if (txt.charAt(i) == pat.charAt(j)) {
                if (!checking) {
                    index = i - j;
                }
                checking = true;
                i++;
                j++;
                if (j == pat.length()) {
                    found = true;
                    break;
                }
            } else if (txt.charAt(i) != pat.charAt(j) && j == 0) {
                checking = false;
                i++;
            } else {
                checking = false;
                j = arr[j - 1];
            }
        }
        System.out.println(index);
        return found;
    }

    private static int[] generatePrefixArray(String pat) {
        int[] arr = new int[pat.length()];
        arr[0] = 0;
        int j = 0;
        int i = 1;

        while (i < arr.length) {
            if (pat.charAt(i) != pat.charAt(j)) {
                if (j - 1 < 0) {
                    //if we cannot further bring down the value of j, it will be assigned as 0
                    arr[i] = 0;
                    i++;
                } else {
                    //keep lowering the value of j till the point it gets a matching pattern
                    j = arr[j - 1];
                }
            } else {
                //if pattern matches increment both i and j
                arr[i] = j + 1;
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }


}
