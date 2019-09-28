package competitiveProgramming.random;

import java.util.*;

public class Potluck {
    public static void main(String[] args) {
        List<String> votes = new ArrayList<>();
        votes.add("C");
        votes.add("C");
        votes.add("A");
        votes.add("B");
        votes.add("B");
        votes.add("A");
        System.out.println(whichSweetShouldIBring(votes));
    }

    public static String whichSweetShouldIBring(List<String> votes) {
        if(votes == null || votes.size() == 0) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        int maxValue = Integer.MIN_VALUE;
        for (String vote : votes) {
            if (map.containsKey(vote)) {
                map.put(vote, map.get(vote) + 1);
                if (map.get(vote) > maxValue) {
                    maxValue = map.get(vote);
                }
            } else {
                map.put(vote, 1);
            }
        }

        List<String> list = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (Integer.parseInt(entry.getValue().toString()) == maxValue) {
                list.add(entry.getKey().toString());
            }
        }

        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
