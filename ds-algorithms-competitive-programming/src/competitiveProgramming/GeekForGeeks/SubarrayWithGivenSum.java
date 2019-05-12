package competitiveProgramming.GeekForGeeks;

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 7, 5};
        int sum = 12;
        subArrayInGivenSum(sum, array);
    }

    private static void subArrayInGivenSum(int sum, int[] array) {
        int temp = 0;
        int start = 0;
        for (int i = 0; i < array.length; i++) {

            if (temp > sum) {
                while (temp > sum && start < i) {
                    temp = temp - array[start];
                    start++;
                }
            }

            if (temp == sum) {//printing the subarray
                for (int j = start; j < i; j++) {
                    System.out.print(array[j] + "\t");
                }
            }

            if (i + 1 < array.length) {
                temp += array[i];
            }
        }
    }
}
