package competitiveProgramming.geekforgeeks.mustdoquestions.hashing;

import java.util.HashMap;
import java.util.Map;

/*
https://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/

Array Pair Sum Divisibility Problem

Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.

Input:
The first line of input contains an integer T denoting the number of test cases. The T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains the n space separated integers forming the array. The last line contains the value of k.

Output:
Print "True" (without quotes) if given array can be divided into pairs such that sum of every pair is divisible by k or else "False" (without quotes).

Constraints:
1<=T<=100
2<=n<=10^5
1<=a[i]<=10^5
1<=k<=10^5

Example:
Input:
2
4
9 7 5 3
6
4
91 74 66 48
10

Output:
True
False

** For More Input/Output Examples Use 'Expected Output' option **
 */
public class CheckIfArrayCanBeDividedInPairDivisibleByK {
    public static void main(String[] args) {
        System.out.println(isDivisible(new int[]{92, 75, 65, 48, 45, 35}, 10));
        System.out.println(isDivisible(new int[]{92, 75, 65, 48}, 9));
        System.out.println(isDivisible(new int[]{9, 7, 5, 3}, 6));
        System.out.println(isDivisible(new int[]{91, 74, 66, 48}, 10));
    }

    private static boolean isDivisible(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();

        for (int num : nums) {
            int count = remainderMap.getOrDefault(num % k, 0);
            remainderMap.put(num % k, count + 1);
        }


        for (Map.Entry<Integer, Integer> entry : remainderMap.entrySet()) {
            /*
            1. Remainder 0 => count should be even
            2. (Remainder * count) % k == 0
            3. freq[remainder] & freq[k - remainder] must match
             */
            if (entry.getKey() == 0) {
                if (entry.getValue() % 2 != 0) {
                    return false;
                }
            } else if ((entry.getKey() * entry.getValue()) % k == 0) {
                continue;
            } else if (entry.getValue().equals(remainderMap.get(k - entry.getKey()))) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }


}
