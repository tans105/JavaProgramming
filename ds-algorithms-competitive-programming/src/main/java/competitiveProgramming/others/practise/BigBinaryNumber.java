package competitiveProgramming.others.practise;

import java.math.BigInteger;

public class BigBinaryNumber {
    public static void main(String[] args) {
        System.out.println(findBigNumber(3));
        System.out.println(findBigNumber(17));
        System.out.println(findBigNumber(1000));
    }


    static long findBigNumber(int num) {
        StringBuilder nested = new StringBuilder();

        for (int j = 1; j <= num; j++) {
            nested.append(Integer.toBinaryString(j));
        }

        BigInteger temp = new BigInteger(nested.toString(), 2);

        return temp.mod(new BigInteger(String.valueOf(1000000007))).longValue();
    }

}


