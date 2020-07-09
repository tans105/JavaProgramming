package competitiveProgramming.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
187. Repeated DNA Sequences

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class RepeatedDNASequences {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();

        if(s== null || s.length() < 10) return list;

        Set<String> set = new HashSet<>(list);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append(s.charAt(i));
        }

        for (int i = 1; i < s.length() - 9; i++) {
            String toCheck = builder.toString();
            String remaining = s.substring(i);
            if (remaining.contains(toCheck)) {
                set.add(builder.toString());
            }
            builder.deleteCharAt(0);
            builder.append(s.charAt(i + 9));
        }


        return new ArrayList<>(set);
    }
}
