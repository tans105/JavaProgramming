package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.dynamicprogramming;

import utils.ArrayUtils;

import java.util.Arrays;

/*
https://practice.geeksforgeeks.org/problems/max-length-chain/1

You are given N pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. Your task is to complete the function maxChainLen which returns an integer denoting the longest chain which can be formed from a given set of pairs.

Input:
The first line of input contains an integer T denoting the no of test cases then T test cases follow .Then T test cases follow . The first line of input contains an integer N denoting the no of pairs . In the next line are 2*N space separated values denoting N pairs.

Output:
For each test case output will be the length of the longest chain formed.

Your Task:
Complete the function maxChainLen() which takes a structure p[] denoting the pairs and n as the number of pairs and returns the length of the longest chain formed.

Expected Time Complexity: O(N*N)
Expected Auxiliary Space: O(N)

Constraints:
1<=T<=100
1<=N<=100

Example(To be used only for expected output):
Input
2
5
5  24 39 60 15 28 27 40 50 90
2
5 10 1 11
Output
3
1
Explanation
(i) the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
(ii) The max length chain possible is only of length one.
 */
public class MaxLengthChain {
    public static void main(String[] args) {
        System.out.println(maxLength(ArrayUtils.parse2DArray("[[5,24],[39,60],[15,28],[27,40],[50,90]]")));
        System.out.println(maxLength(ArrayUtils.parse2DArray("[[5,10],[1,11]")));
    }

    private static int maxLength(int[][] chains) {
        int[] chainLength = new int[chains.length];
        Arrays.fill(chainLength, 1);

        for (int i = 1; i < chains.length; i++) {
            for (int j = 0; j < i; j++) {
                int[] current = chains[i];
                int[] reference = chains[j];

                if (current[0] > reference[1]) {
                    chainLength[i] = Math.max(chainLength[j] + 1, chainLength[i]);
                }
            }
        }

        return chainLength[chains.length - 1];
    }


}
