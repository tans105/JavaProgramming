package competitiveProgramming.interview.Microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.hackerearth.com/problem/algorithm/palindrome-check-2-1/

A String is called Palindrome if it reads the same backwards as well as forwards. For example, the String  can be read the same backwards as well as forwards.
Now, a Permutation of a String S is some String K where S and K contain the same set of characters, however, these characters need not necessarily have the same positions. For Example, consider the String . Here, the Strings :

are all permutations of it.

Now, given a String S consisting of lowercase English alphabets, you need to find out whether any permutation of this given String is a Palindrome. If yes, print "YES" (Without quotes) else, print "NO" without quotes.
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(canFormPermutation("aabb"));
    }

    private static List<List<Character>> canFormPermutation(String s) {
        List<List<Character>> permutations = new ArrayList<>();
        List<Character> permute = new ArrayList<>();
        boolean[] seen = new boolean[s.length()];

        backtrack(s, permute, permutations, seen);

        return permutations;
    }

    private static void backtrack(String s, List<Character> permute, List<List<Character>> permutations, boolean[] seen) {
        if (permute.size() == s.length()) {
            if (isPalindrome(permute)) {
                permutations.add(new ArrayList<>(permute));
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (seen[i]) continue;
            if (i > 0 && s.charAt(i - 1) == s.charAt(i) && seen[i - 1]) continue;
            seen[i] = true;
            permute.add(s.charAt(i));
            backtrack(s, permute, permutations, seen);
            seen[i] = false;
            permute.remove(permute.size() - 1);
        }
    }

    private static boolean isPalindrome(List<Character> permute) {
        int i = 0, j = permute.size() - 1;

        while (i <= j) {
            if (permute.get(i) != permute.get(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
