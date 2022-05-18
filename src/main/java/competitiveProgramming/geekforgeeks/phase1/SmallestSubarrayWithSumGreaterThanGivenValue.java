package competitiveProgramming.geekforgeeks.phase1;

public class SmallestSubarrayWithSumGreaterThanGivenValue {
    public static void main(String[] args) {
        System.out.println(getSmallestSubarray(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 280));
    }

    private static int getSmallestSubarray(int[] arr, int sum) {
        int i = 0, j = 1;
        int minLength = Integer.MAX_VALUE;
        int currentSum = arr[0];
        while (i < arr.length) {
            while (j < arr.length) {
                currentSum += arr[j];
                j++;
                if (currentSum > sum) {
                    int len = j - i;
                    if (len < minLength) minLength = len;
                    break;
                }
            }

            while (i < j) {
                currentSum -= arr[i];
                i++;
                if (currentSum > sum) {
                    int len = j - i;
                    if (len < minLength) minLength = len;
                }
            }
        }

        return minLength;
    }
}
