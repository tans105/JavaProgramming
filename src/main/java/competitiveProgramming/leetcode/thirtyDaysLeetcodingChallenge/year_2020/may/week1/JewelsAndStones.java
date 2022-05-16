package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.year_2020.may.week1;

/*
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/

Jewels and Stones

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
        System.out.println(numJewelsInStones("z", null));
    }

    public static int numJewelsInStones(String J, String S) {
        if (J == null || S == null) return 0;

        char[] jArr = J.toCharArray();
        char[] sArr = S.toCharArray();

        int count = 0;

        for (char jewel : jArr) {
            for (char stone : sArr) {
                if (stone == jewel) count++;
            }
        }

        return count;
    }
}
