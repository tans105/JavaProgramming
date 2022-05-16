package competitiveProgramming.leetcode.phase1;

//https://leetcode.com/problems/implement-strstr/
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("aaaaa", "bba"));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
