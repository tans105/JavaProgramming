package competitiveProgramming.leetcode.phase1;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if (strs == null || strs.length == 0) return list;
        HashMap<String, List<String>> anagramMap = fetchAnagramsMap(strs);
        for (Map.Entry entry : anagramMap.entrySet()) {
            list.add((List<String>) entry.getValue());
        }
        System.out.println(list);
        return list;
    }

    private static HashMap<String, List<String>> fetchAnagramsMap(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        char[] chars;
        String sortedS;
        for (String s: strs) {
            chars = s.toCharArray();
            Arrays.sort(chars);
            sortedS = String.valueOf(chars);
            List<String> l = new ArrayList();
            if(map.containsKey(sortedS)) {
                l = map.get(sortedS);
                l.add(s);
                map.put(sortedS, l);
            } else {
                l.add(s);
                map.put(sortedS, l);
            }
        }
        return map;
    }
}
