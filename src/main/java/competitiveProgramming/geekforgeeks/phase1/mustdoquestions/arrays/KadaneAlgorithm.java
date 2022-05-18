package competitiveProgramming.geekforgeeks.phase1.mustdoquestions.arrays;

//https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, -2, -3, -4, 6};
        System.out.println(getMaximumSum(arr));
    }

    private static int getMaximumSum(int[] arr) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int anArr : arr) {
            if (maxSoFar < 0) {
                maxSoFar = 0;
            } else {
                maxSoFar += anArr;
            }

            if (maxSoFar > maxEndingHere) {
                maxEndingHere = maxSoFar;
            }

        }
        return maxSoFar;
    }
}
