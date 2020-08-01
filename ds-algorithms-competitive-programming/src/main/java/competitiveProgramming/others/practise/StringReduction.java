package competitiveProgramming.others.practise;

import java.util.*;

public class StringReduction {
    public static void main(String[] args) {
        System.out.println(stringReduction(1, "baca"));
        System.out.println(stringReduction(1, "zyxedcba"));
        System.out.println(stringReduction(2, "rim"));
    }

    public static String stringReduction(int k, String s) {
        Map<Character, Queue<Integer>> charPositionMap = new HashMap<>();
        Set<Integer> removedIndices = new HashSet<>();
        char[] letters = s.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            Queue<Integer> positions = charPositionMap.getOrDefault(letters[i], new LinkedList<>());
            positions.offer(i);
            charPositionMap.put(letters[i], positions);
        }

        int removed = 0;


        outerloop:
        for (int i = 1; i <= 26; i++) {
            Character current = ((char) (i + 96));
            if (charPositionMap.containsKey(current)) {
                Queue<Integer> positions = charPositionMap.get(current);
                while (!positions.isEmpty()) {
                    removedIndices.add(positions.poll());
                    removed++;

                    if (removed == k) break outerloop;
                }
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < letters.length; i++) {
            if(!removedIndices.contains(i)) {
                builder.append(letters[i]);
            }
        }


        return builder.toString();
    }
}
