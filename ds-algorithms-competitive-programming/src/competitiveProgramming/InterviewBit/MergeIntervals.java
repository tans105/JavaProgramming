package competitiveProgramming.InterviewBit;

import Utils.ArrayUtils;
import Utils.LoggingUtil;

import java.util.*;

//https://www.interviewbit.com/problems/merge-overlapping-intervals/
//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        ArrayUtils.print2DArray(merge(arr));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        HashMap<String, String> mapping = new HashMap<>();
        ArrayList<String> members = new ArrayList<>();
        for (int[] minorArrays : intervals) {
            mapping.put(minorArrays[0] + "s", "s");
            members.add(Integer.valueOf(minorArrays[0]).toString() + "s");
            mapping.put(minorArrays[1] + "l", "l");
            members.add(Integer.valueOf(minorArrays[1]).toString() + "l");
        }
        String[] memberArray = members.toArray(new String[0]);
        Arrays.sort(memberArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.parseInt(o1.substring(0, o1.length() - 1)) > Integer.parseInt(o2.substring(0, o2.length() - 1))) {
                    return 1;
                } else if (Integer.parseInt(o1.substring(0, o1.length() - 1)) == Integer.parseInt(o2.substring(0, o2.length() - 1))) {
                    if (o1.contains("s")) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return -1;
                }
            }
        });

        boolean paired = true;
        int[] temp = new int[2];
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < memberArray.length; i++) {
            if (mapping.get(memberArray[i]).equals("s") && paired) {
                temp[0] = Integer.parseInt(memberArray[i].substring(0, memberArray[i].length() - 1));
                paired = false;
            }
            if (mapping.get(memberArray[i]).equals("l") && !paired) {
                while ((i + 1) != memberArray.length && mapping.get(memberArray[i + 1]).equals("l")) {
                    i = i + 1;
                }
                temp[1] = Integer.parseInt(memberArray[i].substring(0, memberArray[i].length() - 1));
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
