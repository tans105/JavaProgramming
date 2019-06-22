package competitiveProgramming.InterviewBit;

import java.util.*;

//https://www.interviewbit.com/problems/largest-number/

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * For example:
 * <p>
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber implements Comparator<String> {

    private String largestNumber(final List<Integer> A) {
        List<String> B = new ArrayList<String>();
        for (Integer number : A) {
            String x = number.toString();
            B.add(x);
        }
        B.sort(this);
        StringBuilder ans = new StringBuilder();
        int sum = 0;
        for (int i = B.size() - 1; i >= 0; i--) {
            ans.append(B.get(i));
            sum += Integer.parseInt(B.get(i));
        }
        return sum == 0 ? "0" : ans.toString();
    }

    public int compare(String a, String b) {
        String fe = a + b;
        String se = b + a;
        return (fe.compareTo(se));
    }

    public static void main(String[] args) {
        LargestNumber num = new LargestNumber();
        List<Integer> list = Arrays.asList(3, 30, 34, 5, 9);
        System.out.println(num.largestNumber(list));
    }

}

