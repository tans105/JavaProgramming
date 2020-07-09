package competitiveProgramming.leetcode;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
118. Pascal's Triangle

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) {
            return result;
        }

        List<Integer> prev = Arrays.asList(0, 1, 0);
        result.add(Collections.singletonList(1));
        for (int i = 0; i < numRows-1; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(0);
            for (int j = 0; j < prev.size() - 1; j++) {
                current.add(prev.get(j) + prev.get(j + 1));
            }
            current.add(0);
            List<Integer> backup = new ArrayList<>(current);
            backup.remove(0);
            backup.remove(backup.size() -1 );
            result.add(backup);
            prev = current;
        }
        return result;
    }
}
