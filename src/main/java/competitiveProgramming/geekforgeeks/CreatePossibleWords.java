package competitiveProgramming.geekforgeeks;

import java.util.ArrayList;
import java.util.List;

/*
Suppose a String s = “kite”. We can represent it as “119205” by considering the position of each alphabet as it comes in A-Z(like 1 for A, 2 for B, …….., 11 for K and so on). But it is also possible that the string “119205” can be formed by the word “aaite” and “aste”.
So given a string of integer we have to find how many such words are possible.



Sample Input: "2112"
Output: 5
Explanation:

2112 can be represented as:
(2)(1)(1)(2) ->baab
(2)(1)(12) ->bal
(2)(11)(2)->bkb
(21)(1)(2)->uab
(21)(12)->ul
 */
public class CreatePossibleWords {

    public static void main(String[] args) {
        getCombinations("2112");
    }

    private static void getCombinations(String number) {
        char[] arr = number.toCharArray();
        List<List<Integer>> points = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        getCombinations(points, temp, arr, 0);
        System.out.println(points);
    }

    private static void getCombinations(List<List<Integer>> points, List<Integer> temp, char[] arr, int index) {
        if (index >= arr.length - 1) {
            points.add(temp);
            return;
        }

        int current = Integer.parseInt(String.valueOf(arr[index]));
        int next = Integer.parseInt(String.valueOf(arr[index + 1]));

        int combinedValue = current * 10 + next;

        if (combinedValue < 26) {
            List<Integer> temp1 = new ArrayList<>(temp);

            if (index + 1 <= arr.length) {
                temp.add(current);
                getCombinations(points, temp, arr, index + 1);
            }

            if (index + 2 <= arr.length) {
                temp1.add(combinedValue);
                getCombinations(points, temp1, arr, index + 2);
            }
        } else {
            if (index + 1 <= arr.length) {
                temp.add(current);
                getCombinations(points, temp, arr, index + 1);
            }
        }

    }

}
