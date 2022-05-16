package competitiveProgramming.leetcode;

//https://leetcode.com/discuss/interview-question/310636/microsoft-online-technical-screen
public class RecursivelyReverseString {
    public static void main(String[] args) {
        String s = "1234567";
        StringBuilder builder = new StringBuilder();
        System.out.println(recursiveReverse(builder, 0, s, s.length()));
        builder = new StringBuilder(s);
        System.out.println(recursiveReverseUsingSwap(builder, 0, s.length() - 1));
    }

    private static StringBuilder recursiveReverseUsingSwap(StringBuilder builder, int left, int right) {
        if (left > right) {
            return builder;
        }
        swap(builder, left, right);
        return recursiveReverseUsingSwap(builder, left + 1, right - 1);
    }

    private static void swap(StringBuilder builder, int left, int right) {
        char from = builder.charAt(left);
        char to = builder.charAt(right);
        builder.setCharAt(left, to);
        builder.setCharAt(right, from);
    }

    private static StringBuilder recursiveReverse(StringBuilder builder, int index, String s, int length) {
        if (index == length) {
            return builder;
        } else {
            builder.append(s.charAt(length - index - 1));
            return recursiveReverse(builder, index + 1, s, length);
        }
    }
}
