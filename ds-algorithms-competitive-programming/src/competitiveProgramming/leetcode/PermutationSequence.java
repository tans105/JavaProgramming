package competitiveProgramming.leetcode;

import Utils.ArrayUtils;
import Utils.LoggingUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/permutation-sequence/
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * <p>
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 * <p>
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * <p>
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation2(3, 3));
        System.out.println(getPermutation3(3, 3));
    }

    /**
     * Approach 1: Find all permutation and return the sorted value
     *
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {
        if (n == 0 || k == 0) {
            return "0";
        }

        List<List<String>> permutations = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        String s = getString(n);
        getUnorderedPermutations(permutations, temp, 0, s);
        StringBuilder builder = new StringBuilder();
        List<String> list = permutations.get(k - 1);
        for (String str : list) {
            builder.append(str);
        }
        return builder.toString();
    }

    private static String getString(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            builder.append(i);
        }
        return builder.toString();
    }

    private static void getUnorderedPermutations(List<List<String>> permutations, List<String> temp, int index, String s) {
        if (temp.size() == s.length()) {
            permutations.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (temp.contains(String.valueOf(s.charAt(i)))) continue;
            temp.add(String.valueOf(s.charAt(i)));
            getUnorderedPermutations(permutations, temp, i + 1, s);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * Approach 2. Keep calculating the next greater sequence
     *
     * @param n
     * @param k
     * @return
     */
    private static String getPermutation2(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        for (int i = 0; i < k - 1; i++) {
            NextPermutation.nextPermutation(nums);
        }
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }

        return builder.toString();
    }


    /**
     * Approach 3
     *
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation3(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i * fact[i - 1];
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int ind = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }

}
