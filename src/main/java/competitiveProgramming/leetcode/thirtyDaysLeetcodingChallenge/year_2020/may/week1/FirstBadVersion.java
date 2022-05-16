package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.may.week1;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3316/

First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.
 */
public class FirstBadVersion {
    static boolean[] version = new boolean[]{false, true};

    public static boolean isBadVersion(int n) {
        return version[n];
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(version.length));
    }

    public static int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean midVersion = isBadVersion(mid);

            if (midVersion) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
