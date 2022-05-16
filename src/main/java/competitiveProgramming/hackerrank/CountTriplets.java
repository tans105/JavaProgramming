package competitiveProgramming.hackerrank;

import java.util.*;

/*
https://www.hackerrank.com/challenges/count-triplets-1/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

Count Triplets

You are given an array and you need to find number of tripets of indices
such that the elements at those indices are in geometric progression for a given common ratio and

.

For example,
. If , we have and at indices and

.

Function Description

Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric progression for a given

as an integer.

countTriplets has the following parameter(s):

    arr: an array of integers
    r: an integer, the common ratio

Input Format

The first line contains two space-separated integers
and , the size of and the common ratio.
The next line contains space-seperated integers

.

Constraints

Output Format

Return the count of triplets that form a geometric progression.
 */
public class CountTriplets {
    public static void main(String[] args) {
        System.out.println(countTriplets(Arrays.asList(1, 4, 16, 64)));
        System.out.println(countTriplets(Arrays.asList(1, 2, 2, 4)));
        System.out.println(countTriplets(Arrays.asList(1, 5, 5, 25, 125)));
        System.out.println(countTriplets(Arrays.asList(1, 3, 3, 9, 27, 81)));
    }

    private static int countTriplets(List<Integer> list) {
        if (list == null) return 0;

        Collections.sort(list);

        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            List<Integer> indexes = indexMap.getOrDefault(list.get(i), new ArrayList<>());
            indexes.add(i);
            indexMap.put(list.get(i), indexes);
        }

        int count = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int r = list.get(i) / list.get(j);
                int toFind = list.get(j) / r;
                if (indexMap.containsKey(toFind)) {
                    List<Integer> indexes = indexMap.get(toFind);
                    for (int index : indexes) {
                        if (index < j) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
