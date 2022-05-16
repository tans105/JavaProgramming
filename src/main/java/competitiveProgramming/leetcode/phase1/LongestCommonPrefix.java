package competitiveProgramming.leetcode.phase1;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = new String[]{"aa", "a"};
        System.out.println(longestCommonPrefix(s));
    }

    private static String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        if (strs.length == 0) {
            return "";
        }

        char[] arr = strs[0].toCharArray();
        int tempCount = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                for (String s : strs) {
                    if (s.charAt(i) == arr[i]) {
                        tempCount++;
                    }
                }
                if (tempCount == strs.length) {
                    builder.append(arr[i]);
                    tempCount = 0;
                } else {
                    break;
                }
            }
        } catch (Exception e) {

        }


        return builder.toString();
    }
}
