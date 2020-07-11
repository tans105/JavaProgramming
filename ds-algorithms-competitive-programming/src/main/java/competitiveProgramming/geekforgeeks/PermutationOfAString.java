package competitiveProgramming.geekforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

Write a program to print all permutations of a given string

A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered list S into a one-to-one correspondence with S itself. A string of length n has n! permutation.
Source: Mathword(http://mathworld.wolfram.com/Permutation.html)

Below are the permutations of string ABC.
ABC ACB BAC BCA CBA CAB
 */
public class PermutationOfAString {
    public static void main(String[] args) {
        System.out.println(permute("ABC"));
        System.out.println(permute("AABC"));
    }

    //----------------------------Approach 1---------------------//
    private static List<List<Character>> permute(String str) {
        List<List<Character>> permuatations = new ArrayList<>();
        List<Character> temp = new ArrayList<>();
        char[] chars = str.toCharArray();
        boolean[] visited = new boolean[chars.length];

        Arrays.sort(chars); //condition to add to prevent duplicate
        permute(permuatations, temp, chars, visited);
        return permuatations;
    }

    private static void permute(List<List<Character>> permuatations, List<Character> temp, char[] chars, boolean[] visited) {
        if (temp.size() == chars.length) {
            permuatations.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && visited[i - 1]) continue; //condition to add to prevent duplicate
            visited[i] = true;
            temp.add(chars[i]);
            permute(permuatations, temp, chars, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
