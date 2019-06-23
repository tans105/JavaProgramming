package competitiveProgramming.InterviewBit;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://www.interviewbit.com/problems/merge-overlapping-intervals/
public class MergeIntervals {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 4},
                {2, 5},
                {3, 6}
        };
        ArrayUtils.print2DArray(merge(arr));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        HashMap<Integer, String> mapping = new HashMap<>();
        ArrayList<Integer> members = new ArrayList<>();
        for (int[] minorArrays : intervals) {
            mapping.put(minorArrays[0], "s");
            members.add(minorArrays[0]);
            mapping.put(minorArrays[1], "l");
            members.add(minorArrays[1]);
        }
        Integer[] memberArray = members.toArray(new Integer[0]);
        Arrays.sort(memberArray);

        System.out.println(mapping);
        System.out.println(Arrays.toString(memberArray));

        boolean paired = true;
        int[] temp = new int[2];
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < memberArray.length; i++) {
            if (mapping.get(memberArray[i]).equals("s") && paired) {
                temp[0] = memberArray[i];
                paired = false;
            }
            if (mapping.get(memberArray[i]).equals("l") && !paired) {
                while ((i + 1) != memberArray.length && mapping.get(memberArray[i + 1]).equals("l")) {
                    i = i + 1;
                }
                temp[1] = memberArray[i];
                result.add(temp);
                paired = true;
                temp = new int[2];
            }
        }

        int[][] output = new int[result.size()][2];
        for (int i = 0; i < output.length; i++) {
            output[i] = result.get(i);
        }
        return output;
    }
}
