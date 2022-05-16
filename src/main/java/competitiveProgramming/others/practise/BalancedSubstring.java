package competitiveProgramming.others.practise;

import java.util.*;

/*
Given a string containing only R and L. Find the number of balanced substrings(equal number of L’s and R’s) you will encounter where you can traverse only in the left-right direction.

Example 1: RLRRLLRLRL  Answer: 4 (RL, RRLL, RL, RL)

Example 2: LLLLRRRR  Answer:1 (LLLLRRRR)

Example 3: RLLLLRRRLR  Answer:3 (RL, LLLRRR, LR)
 */

public class BalancedSubstring {
    public static void main(String[] args) {
        System.out.println(balancedSubstring("RLRRLLRLRL"));
        System.out.println(balancedSubstring("LLLLRRRR"));
        System.out.println(balancedSubstring("RLLLLRRRLR"));
    }

    public static int balancedSubstring(String str) {
        List<String> balancedString = new ArrayList<>();
        Map<Integer, List<Integer>> hash = new HashMap<>();
        int count = 0;

        hash.put(0, Arrays.asList(0));

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr == 'R') count++;
            else count--;

            if (hash.containsKey(count)) {
                List<Integer> indexes = hash.get(count);
                for (Integer index : indexes) {
                    balancedString.add(str.substring(index, i + 1));
                }
            }

        }

        return balancedString.size();
    }
}
