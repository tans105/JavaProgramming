package competitiveProgramming.geekforgeeks;

/*
https://www.geeksforgeeks.org/partition-problem-dp-18/


Partition problem | DP-18

Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.

Examples:

arr[] = {1, 5, 11, 5}
Output: true
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false
The array cannot be partitioned into equal sum sets.

 */
public class PartitionProblem {
    public static void main(String[] args) {
        System.out.println(isPartition(new int[]{1, 5, 11, 5}));
        System.out.println(isPartition(new int[]{1, 1, 2}));
        System.out.println(isPartition(new int[]{1, 1, 4}));
        System.out.println(isPartition(new int[]{1, 1, 1, 3}));
    }

    public static boolean isPartition(int[] nums) {
        int sum = 0;

        for (int value : nums) sum += value;

        if (sum % 2 != 0) return false;

        sum = sum / 2; // Problem is now reduced to finding subset whose sum is k. Here k = sum/2
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = dp.length - 1; j > 0; j--) {
                int nextIdx = j - num;

                if (nextIdx >= 0 && dp[nextIdx]) dp[j] = true;
            }

            try {
                dp[num] = true;
            } catch (Exception ignored) {

            }
        }

        return dp[dp.length - 1];
    }
}
