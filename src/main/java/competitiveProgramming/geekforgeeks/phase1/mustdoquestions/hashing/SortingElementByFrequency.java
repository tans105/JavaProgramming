package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.hashing;

import java.util.*;


/*
https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0

Sorting Elements of an Array by Frequency

Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space.

Constraints:
1 ≤ T ≤ 70
30 ≤ N ≤ 130
1 ≤ Ai ≤ 60

Example:
Input:
2
5
5 5 4 6 4
5
9 9 9 2 5

Output:
4 4 5 5 6
9 9 9 2 5

Explanation:
Testcase1: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are same then smaller element comes first. So 4 4 comes first then comes 5 5. Finally comes 6.
The output is 4 4 5 5 6.

Testcase2: The highest frequency here is 3. The element 9 has the highest frequency. So 9 9 9 comes first. Now both 2 and 5 have same frequency. So we print smaller element first.
The output is 9 9 9 2 5.
 */
public class SortingElementByFrequency {
    public static void main(String[] args) {
        System.out.println(sort(new int[]{2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}));
    }

    private static List<Integer> sort(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int value : arr) {
            map.put(value, map.getOrDefault(value, 0) + 1);
            list.add(value);
        }

        SortComparator comparator = new SortComparator(map);
        list.sort(comparator);

        return list;
    }


    static class SortComparator implements Comparator<Integer> {
        Map<Integer, Integer> freqMap;

        SortComparator(Map<Integer, Integer> freqMap) {
            this.freqMap = freqMap;
        }

        @Override
        public int compare(Integer t1, Integer t2) {
            int freqComp = freqMap.get(t2).compareTo(freqMap.get(t1));
            int valComp = t2.compareTo(t2);

            if (freqComp == 0) {
                return valComp;
            } else {
                return freqComp;
            }
        }
    }

}
