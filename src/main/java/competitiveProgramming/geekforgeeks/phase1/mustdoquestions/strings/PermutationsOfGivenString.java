package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.strings;

import java.util.*;

/*
https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0

Permutations of a given string

Given a string S. The task is to print all permutations of a given string.

Input:
The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.

Output:
For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.

Constraints:
1 ≤ T ≤ 10
1 ≤ size of string ≤ 5

Example:
Input:
2
ABC
ABSG

Output:
ABC ACB BAC BCA CAB CBA
ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA

Explanation:
Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .
 */
public class PermutationsOfGivenString {
    public static void main(String[] args) {
        System.out.println(permuteDuplicates("AAB"));
    }


    private static List<List<Character>> permuteDuplicates(String str) {
        List<List<Character>> finalList = new ArrayList<>();
        List<Character> tempList = new ArrayList<>();
        boolean[] used = new boolean[str.length()];
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        backtrackDuplicates(finalList, tempList, arr, used);
        return finalList;
    }

    private static void backtrackDuplicates(List<List<Character>> finalList, List<Character> tempList, char[] arr, boolean[] used) {
        if (tempList.size() == arr.length) {
            finalList.add(new ArrayList<>(tempList));
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && used[i - 1]) continue;
            tempList.add(arr[i]);
            used[i] = true;
            backtrackDuplicates(finalList, tempList, arr, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);

            // OR
//            while (i + 1 < arr.length && arr[i] == arr[i + 1]) {  //  not considering the same elements again
//                i++;
//            }
        }
    }


}
