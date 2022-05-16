package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.june.week3;

import java.util.HashMap;

/*
https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3365/

Longest Duplicate Substring

Solution
Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)



Example 1:

Input: "banana"
Output: "ana"
Example 2:

Input: "abcd"
Output: ""


Note:

2 <= S.length <= 10^5
S consists of lowercase English letters.
 */
public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana"));
        System.out.println(longestDupSubstring("abcd"));
        System.out.println(longestDupSubstring("baxsazax"));
    }

    public static String longestDupSubstring(String S) {
        int low = 0;
        int high = S.length();
        String lds = "";

        while (low <= high) {

            //If size = mid has duplicate check for higher length else break
            int mid = (low + high) / 2;
            String tlds = checkDuplicateForLength(S, mid);

            if (tlds != null) {
                lds = tlds;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return lds;
    }

    private static String checkDuplicateForLength(String s, int len) {
        HashMap<Double, String> hashMap = new HashMap<>();
        String lds = null;
        char[] arr = s.toCharArray();

        double hashCode = 0d;

        for (int i = 0; i < len; i++) {
            hashCode += (arr[i] - 'a') * Math.pow(26, len - i - 1);
        }

        hashMap.put(hashCode, s.substring(0, len));

        //Creating Hashmap with custom hashcode generation vs substring for that hashcode
        //rolling hashing
        for (int i = 0; i < s.length() - len; i++) {
            char toBeRemoved = arr[i];
            char toBeAdded = arr[i + len];
            hashCode = ((hashCode - (toBeRemoved - 'a') * Math.pow(26, len - 1)) * 26) + (toBeAdded - 'a'); //Removing the old one contribution and adding new contribution
            if (hashMap.containsKey(hashCode)) { //if hascode already present, the substring has been encountered before => duplicate found
                lds = hashMap.get(hashCode);
            } else {
                hashMap.put(hashCode, s.substring(i + 1, i + 1 + len));
            }
        }

        return lds;
    }
}
