package competitiveProgramming.leetcode.thirtyDaysLeetcodingChallenge.june.week2;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-16));
    }

    public static boolean isPowerOfTwo(int n) {
        if(n < 0) return false;
        int count = 0;

        while (n != 0) {
            if (n % 2 != 0) count++;
            n = n >> 1;
        }

        return count == 1;
    }
}
