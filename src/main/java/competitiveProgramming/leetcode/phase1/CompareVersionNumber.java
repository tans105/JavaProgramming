package competitiveProgramming.leetcode.phase1;

import utils.ArrayUtils;
import utils.LoggingUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
165. Compare Version Numbers

Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.

The . character does not represent a decimal point and is used to separate number sequences.

For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.



Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
Example 4:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
Example 5:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 */
public class CompareVersionNumber {
    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1.0"));
    }

    public static int compareVersion(String version1, String version2) {
        List<Object> v1 = new ArrayList<>(Arrays.asList(version1.split("[.]")));
        List<Object> v2 = new ArrayList<>(Arrays.asList(version2.split("[.]")));


        if (v1.size() != v2.size()) {
            if (v1.size() > v2.size()) {
                normalize(v2, v1.size() - v2.size());
            } else {
                normalize(v1, v2.size() - v1.size());
            }
        }

        for (int i = 0; i < v1.size(); i++) {
            int val1 = Integer.parseInt(v1.get(i).toString());
            int val2 = Integer.parseInt(v2.get(i).toString());

            if (val1 > val2) {
                return 1;
            }

            if (val2 > val1) {
                return -1;
            }
        }

        return 0;

    }

    private static void normalize(List<Object> list, int length) {
        for (int i = 0; i < length; i++) {
            list.add("0");
        }
    }
}
