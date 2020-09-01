package competitiveProgramming.others.practise;


import utils.LoggingUtil;

public class MinimizeString {
    public static void main(String[] args) {
        System.out.println(minimize("aabcccabba"));
    }

    private static int minimize(String str) {
        if (str == null || str.length() == 0) return 0;

        int len = str.length();

        String left = str.substring(0, len / 2);
        String right = str.substring(len / 2);


        while (true) {
            int i = 0;
            int j = right.length() - 1;

            if (left.charAt(i) != right.charAt(j)) {
                break;
            } else {
                int rCount = 0;
                int lCount = 1;

                char ref = left.charAt(i);

                while (right.charAt(j) == ref) {
                    rCount++;
                    j--;
                }

                i++;
                while (left.charAt(i) == ref) {
                    lCount++;
                    i++;
                }

                left = left.substring(lCount);
                right = right.substring(0, right.length() - rCount);
            }
        }

        return left.length() + right.length();
    }
}
