package competitiveProgramming.geekforgeeks.phase1;

/*
https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] wt = new int[]{1, 3, 4, 5};
        int[] value = new int[]{1, 4, 5, 7};
        System.out.println(getKnapsack(wt, value, 7));
    }

    public static int getKnapsack(int[] weight, int[] value, int total) {
        int[][] knapChart = new int[weight.length][total + 1];

        knapChart[0][0] = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < knapChart[i].length; j++) {
                int remaining = j - weight[i];
                if (remaining >= 0)
                    if (i - 1 < 0) knapChart[i][j] = weight[i];
                    else {
                        knapChart[i][j] = Math.max(value[i] + knapChart[i - 1][remaining], knapChart[i - 1][j]);
                    }
                else {
                    if (j - 1 < 0) knapChart[i][j] = 0;
                    else knapChart[i][j] = knapChart[i - 1][j];
                }
            }
        }

        return knapChart[weight.length - 1][total];
    }
}
